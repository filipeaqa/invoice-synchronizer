package com.api.challenge.invoicesynchronizer.client.response;

public class Data {

    private String access_key;
    private String xml;

    public Data() {
    }

    public Data(String access_key, String xml) {
        this.access_key = access_key;
        this.xml = xml;
    }

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getXml() { return xml; }

    public void setXml(String xml) {
        this.xml = xml;
    }

    @Override
    public String toString() {
        return "Data{" +
                "access_key='" + access_key + '\'' +
                ", xml='" + xml + '\'' +
                '}';
    }
}
