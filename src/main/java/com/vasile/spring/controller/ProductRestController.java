package com.vasile.spring.controller;

import com.vasile.spring.model.Product;
import com.vasile.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vasile on 20.05.2017.
 */
@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/kebab", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> product() {
        HttpHeaders headers = new HttpHeaders();
        List<Product> productList = productService.getListKebab();

        if (productList == null) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        headers.add("Number of records found", String.valueOf(productList.size()));
        return new ResponseEntity<List<Product>>(productList, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/cafe", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> cafe(){

        HttpHeaders headers = new HttpHeaders();
        List<Product> productList = productService.getListCafe();

        if (productList == null) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        headers.add("Number of records found", String.valueOf(productList.size()));
        return new ResponseEntity<List<Product>>(productList, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> restaurant(){

        HttpHeaders headers = new HttpHeaders();
        List<Product> productList = productService.getListRestaurant();

        if (productList == null) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        headers.add("Number of records found", String.valueOf(productList.size()));
        return new ResponseEntity<List<Product>>(productList, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/pizza", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> pizza(){

        HttpHeaders headers = new HttpHeaders();
        List<Product> productList = productService.getListPizza();

        if (productList == null) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        headers.add("Number of records found", String.valueOf(productList.size()));
        return new ResponseEntity<List<Product>>(productList, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/fastfood", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> fastfood(){

        HttpHeaders headers = new HttpHeaders();
        List<Product> productList = productService.getListFastFood();

        if (productList == null) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        headers.add("Number of records found", String.valueOf(productList.size()));
        return new ResponseEntity<List<Product>>(productList, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        Product product = productService.getProduct(id);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);
        httpHeaders.add("Product deleted: -", String.valueOf(id));
        return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(product);
        httpHeaders.add("Product created: -", String.valueOf(product.getId()));
        return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        Product isExist = productService.getProduct(id);
        if (isExist == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        } else if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(product);
        headers.add("Product updated:-", String.valueOf(id));
        return new ResponseEntity<Product>(product, headers, HttpStatus.OK);
    }
}
