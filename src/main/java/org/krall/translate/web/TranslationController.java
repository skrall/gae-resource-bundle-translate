package org.krall.translate.web;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.krall.translate.model.ApiKeys;
import org.krall.translate.model.TranslationResponse;
import org.krall.translate.service.TranslationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Controller
@RequestMapping("/translate.html")
public class TranslationController {

    private static final Logger log = LoggerFactory.getLogger(TranslationController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiKeys apiKeys;

    @Autowired
    private TranslationService translationService;

    @ModelAttribute
    private ApiKeys populateApiKeys() {
        return apiKeys;
    }

    @RequestMapping(method = RequestMethod.GET)
    private String setupTranslation(Model model) {

        TranslationResponse translationResponse = restTemplate.getForObject("https://www.googleapis.com/language/translate/v2?key={key}&q={q}&q={q2}&source={source}&target={target}",
                TranslationResponse.class, apiKeys.getTranslateKey(), "flowers", "bottom of sack", "en", "fr");

        model.addAttribute(translationResponse);

        return "translate";
    }

    @RequestMapping(method = RequestMethod.POST)
    private String handleTranslation(Model model, HttpServletRequest request) throws IOException, FileUploadException {

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload();
        upload.setSizeMax(512 & 1024);

        // Parse the request
        FileItemIterator iter = upload.getItemIterator(request);
        while (iter.hasNext()) {
            FileItemStream item = iter.next();
            String name = item.getFieldName();
            InputStream stream = item.openStream();
            if (item.isFormField()) {
                log.info("Form field " + name + " with value "
                        + Streams.asString(stream) + " detected.");
            } else {
                log.info("File field " + name + " with file name "
                        + item.getName() + " detected.");
                translationService.translateZipFile(stream);
            }
        }

        return "translateResult";
    }
}
