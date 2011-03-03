package org.krall.translate.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiKeys {

    private String javascriptKey;
    private String translateKey;
    private String analyticsKey;

    public String getJavascriptKey() {
        return javascriptKey;
    }

    public void setJavascriptKey(String javascriptKey) {
        this.javascriptKey = javascriptKey;
    }

    public String getTranslateKey() {
        return translateKey;
    }

    public void setTranslateKey(String translateKey) {
        this.translateKey = translateKey;
    }

    public String getAnalyticsKey() {
        return analyticsKey;
    }

    public void setAnalyticsKey(String analyticsKey) {
        this.analyticsKey = analyticsKey;
    }

    @Override
    public String toString() {
        return "ApiKeys{" +
                "javascriptKey='" + javascriptKey + '\'' +
                ", translateKey='" + translateKey + '\'' +
                ", analyticsKey='" + analyticsKey + '\'' +
                '}';
    }
}
