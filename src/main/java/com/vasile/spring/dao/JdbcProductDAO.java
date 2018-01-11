package com.vasile.spring.dao;


import com.vasile.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by Vasile on 20.05.2017.
 */
@Repository
public class JdbcProductDAO implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getListKebab() {
        List<Product> list = null;
        try {
            list = jdbcTemplate.query("select id,name,addresse,rate,description,photo from Chisinau.kebab", new BeanPropertyRowMapper<Product>(Product.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getListCafe() {
        List<Product> list = null;
        try {
            list = jdbcTemplate.query("select id,name,addresse,rate,description,photo from Chisinau.cafe", new BeanPropertyRowMapper<Product>(Product.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getListRestaurant() {
        List<Product> list = null;
        try {
            list = jdbcTemplate.query("select id,name,addresse,rate,description,photo from Chisinau.restaurant", new BeanPropertyRowMapper<Product>(Product.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getListPizza() {
        List<Product> list = null;
        try {
            list = jdbcTemplate.query("select id,name,addresse,rate,description,photo from Chisinau.pizza", new BeanPropertyRowMapper<Product>(Product.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getListFastFood() {
        List<Product> list = null;
        try {
            list = jdbcTemplate.query("select id,name,addresse,rate,description,photo from Chisinau.fastfood", new BeanPropertyRowMapper<Product>(Product.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProduct(Long id) {
        Product product = null;

        try {
            product = jdbcTemplate.queryForObject("select * from Chisinau.kebab where id=?", new Object[]{id},
                    new BeanPropertyRowMapper<Product>(Product.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return product;
    }

    public int deleteProduct(Long id) {
        int count = jdbcTemplate.update("delete from Chisinau.kebab where id=?", new Object[]{id});
        return count;
    }

    public int updateProduct(Product product) {
        int count = jdbcTemplate.update("update Chisinau.kebab set name=?, addresse=?, description=?,rate=?,photo=?",
                new Object[]{product.getName(), product.getAddresse(), product.getDescription(), product.getRate(), product.getPhoto()});
        return count;
    }

    public int createProduct(Product product) {
        int count = jdbcTemplate.update("insert into Chisinau.kebab(id,name,addresse,rate,description,photo) values(?,?,?,?,?,?)",
                new Object[]{product.getId(), product.getName(), product.getAddresse(), product.getRate(),
                        product.getDescription(), product.getPhoto()});
        return count;
    }
}
