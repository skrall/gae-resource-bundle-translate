package org.krall.translate.web;

import org.krall.translate.model.ApiKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index.html")
public class IndexController {

    @Autowired
    private ApiKeys apiKeys;

    @ModelAttribute
    private ApiKeys popluateApiKeys() {
        return apiKeys;
    }

    @RequestMapping(method = RequestMethod.GET)
    private String displayIndex(Model model) {
        return "index";
    }

}
