package org.krall.translate.web;

import org.krall.translate.model.ApiKeys;
import org.krall.translate.model.TranslationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/translate.html")
public class TranslationController {

    private static final Logger log = LoggerFactory.getLogger(TranslationController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiKeys apiKeys;

    ClientHttpRequest request;

    @ModelAttribute
    private ApiKeys populateApiKeys() {
        return apiKeys;
    }

    @PostConstruct
    private void logStuff() {
        log.info("PostContruct: " + apiKeys);
    }

    @RequestMapping(method = RequestMethod.GET)
    private String setupTranslation(Model model) {

        TranslationResponse translationResult = restTemplate.getForObject("https://www.googleapis.com/language/translate/v2?key={key}&q={q}&q={q2}&source={source}&target={target}",
                TranslationResponse.class, apiKeys.getTranslateKey(), "flowers", "bottom of sack", "en", "fr");

        model.addAttribute(translationResult);

        return "translate";
    }

}
