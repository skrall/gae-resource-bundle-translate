package org.krall.translate.model;

import java.util.List;

public class Data {

    private List<TranslatedText> translations;

    public List<TranslatedText> getTranslations() {
        return translations;
    }

    public void setTranslations(List<TranslatedText> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "Data{" +
                "translations=" + translations +
                '}';
    }
}


