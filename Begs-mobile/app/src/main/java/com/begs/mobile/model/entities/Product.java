/**
 *
 */
package com.begs.mobile.model.entities;

public class Product {

    private Producer producer;

    private String tags = "";

    /**
     * The item detail.
     */
    private String longDescription = "";

    /**
     * The mrp.
     */
    private String mrp;

    /**
     * The discount.
     */
    private String discount;

    /**
     * The sell mrp.
     */
    private String salePrice;

    /**
     * The quantity.
     */
    private String orderQty;

    /**
     * The image url.
     */
    private String imageUrl = "";

    /**
     * The item name.
     */
    private String productName = "";

    private String productId = "";

    /**
     * @param itemName
     * @param itemDetail
     * @param MRP
     * @param discount
     * @param sellMRP
     * @param quantity
     * @param imageURL
     */
    public Product(String itemName, String tags, String itemDetail,
                   String MRP, String discount, String sellMRP, String quantity,
                   String imageURL, String orderId, Producer producer) {
        this.productName = itemName;
        this.tags = tags;
        this.longDescription = itemDetail;
        this.mrp = MRP;
        this.discount = discount;
        this.salePrice = sellMRP;
        this.orderQty = quantity;
        this.imageUrl = imageURL;
        this.productId = orderId;
        this.producer = producer;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getItemName() {
        return productName;
    }

    public void setItemName(String itemName) {
        this.productName = itemName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String itemShortDesc) {
        this.tags = itemShortDesc;
    }

    public String getItemDetail() {
        return longDescription;
    }

    public void setItemDetail(String itemDetail) {
        this.longDescription = itemDetail;
    }

    public String getMRP() {
        return this.mrp;
    }

    public void setMRP(String MRP) {
        this.mrp = MRP;
    }

    public String getDiscount() {
        return discount + "%";
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountNumeric() {
        return discount;
    }

    public String getSellMRP() {
        return salePrice;
    }

    public void setSellMRP(String sellMRP) {
        this.salePrice = sellMRP;
    }

    public String getQuantity() {
        return orderQty;
    }

    public void setQuantity(String quantity) {
        this.orderQty = quantity;
    }

    public String getImageURL() {
        return imageUrl;
    }

    public void setImageURL(String imageURL) {
        this.imageUrl = imageURL;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
