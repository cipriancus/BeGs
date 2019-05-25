package com.begs.mobile.model.entities;

public class Producer {

    private String longDescription = "";

    private String imageUrl = "";

    private String producerName = "";

    private String producerId = "";

    public Producer(String longDescription, String imageUrl, String producerName, String producerId) {
        this.producerId = producerId;
        this.producerName = producerName;
        this.longDescription = longDescription;
        this.imageUrl = imageUrl;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }
}
