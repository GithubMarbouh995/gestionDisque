package com.example.demoe_2jee;

public class Brand {
    private int id;
    private String brand;
    private String category;
    private double price;
    private String  status;
    private String email;
    private String image_url;

    public Brand(int id,String brand, String category, double price, String status, String email, String image_url) {
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.status = status;
        this.email = email;
        this.image_url = image_url;
    }

    public Brand() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
