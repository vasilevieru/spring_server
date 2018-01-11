package com.vasile.spring.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by Vasile on 20.05.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private Long id;
    private String name;
    private String addresse;
    private double rate;
    private String description;
    private byte[] photo;
    private double sum;
    private ArrayList<Product> products;

    public Product() {
    }

    @JsonCreator
    public Product(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("addresse") String addresse,
                   @JsonProperty("rate") double rate, @JsonProperty("description") String description,
                   @JsonProperty("photo") byte[] photo) {
        this.id = id;
        this.name = name;
        this.addresse = addresse;
        this.rate = rate;
        this.photo = photo;
        this.description = description;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product Id:- " + getId());
        builder.append("Product name:- " + getName());
        builder.append("Product addresse:- " + getAddresse());
        builder.append("Product rate:- " + getRate());
        builder.append("Product description:- " + getDescription());
        builder.append("Product photo:- " + getPhoto());
        builder.append("Product sum: -" + getSum());
        return builder.toString();

    }
}
