package org.krall.translate.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TranslationResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TranslationResponse{" +
                "data=" + data +
                '}';
    }
}

