package com.vasile.spring.dao;

import com.vasile.spring.model.Product;

import java.util.List;

/**
 * Created by Vasile on 20.05.2017.
 */
public interface ProductDAO {

    public List<Product> getListKebab();
    public List<Product> getListCafe();
    public List<Product> getListRestaurant();
    public List<Product> getListPizza();
    public List<Product> getListFastFood();
    public Product getProduct(Long id);
    public int deleteProduct(Long id);
    public int updateProduct(Product product);
    public int createProduct(Product product);
}
