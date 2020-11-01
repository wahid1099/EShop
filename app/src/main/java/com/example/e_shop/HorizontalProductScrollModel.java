package com.example.e_shop;

public class HorizontalProductScrollModel {
    private String productImage, productID;
    private String productTitle, productDescription, productPrice;

    public HorizontalProductScrollModel(String productImage, String productID, String productTitle, String productDescription, String productPrice) {
        this.productImage = productImage;
        this.productID = productID;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;

    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}