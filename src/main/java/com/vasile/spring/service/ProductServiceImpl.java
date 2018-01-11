package com.vasile.spring.service;

import com.vasile.spring.dao.ProductDAO;
import com.vasile.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vasile on 27.05.2017.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> getListKebab() {
        List<Product> productList = productDAO.getListKebab();
        return productList;
    }

    public List<Product> getListRestaurant() {
        List<Product> productList = productDAO.getListRestaurant();
        return productList;
    }

    public List<Product> getListPizza() {
        List<Product> productList = productDAO.getListPizza();
        return productList;
    }

    public List<Product> getListFastFood() {
        List<Product> productList = productDAO.getListFastFood();
        return productList;
    }

    public List<Product> getListCafe() {
        List<Product> productList = productDAO.getListCafe();
        return productList;    }

    public Product getProduct(Long id) {
        Product product = productDAO.getProduct(id);
        return product;
    }

    public int deleteProduct(Long id) {
        return productDAO.deleteProduct(id);
    }

    public int updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    public int createProduct(Product product) {
        return productDAO.createProduct(product);
    }
}
