package com.vasile.spring.service;

import com.vasile.spring.model.Product;

import java.util.List;

/**
 * Created by Vasile on 27.05.2017.
 */
public interface ProductService {
    public List<Product> getListKebab();
    public List<Product> getListRestaurant();
    public List<Product> getListPizza();
    public List<Product> getListFastFood();
    public List<Product> getListCafe();
    public Product getProduct(Long id);
    public int deleteProduct(Long id);
    public int updateProduct(Product product);
    public int createProduct(Product product);
}
