package org.krall.translate.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Locale;

@XmlRootElement
public class Translation {

    private String key;
    private String fromValue;
    private String toValue;
    private Locale fromLocale;
    private Locale toLocale;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFromValue() {
        return fromValue;
    }

    public void setFromValue(String fromValue) {
        this.fromValue = fromValue;
    }

    public String getToValue() {
        return toValue;
    }

    public void setToValue(String toValue) {
        this.toValue = toValue;
    }

    public Locale getFromLocale() {
        return fromLocale;
    }

    public void setFromLocale(Locale fromLocale) {
        this.fromLocale = fromLocale;
    }

    public Locale getToLocale() {
        return toLocale;
    }

    public void setToLocale(Locale toLocale) {
        this.toLocale = toLocale;
    }
}
