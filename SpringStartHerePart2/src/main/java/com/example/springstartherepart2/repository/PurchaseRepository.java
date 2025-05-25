package com.example.springstartherepart2.repository;

import com.example.springstartherepart2.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // We use the @Respository stereotype annotation to add a bean of this type to the Spring Context.
public class PurchaseRepository {
    private final JdbcTemplate jdbcTemplate;

    // We use constructor injection to get the JdbcTemplate instance from application context.
    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // The method takes a parameter that represents the data to be stored.
    public void storePurchase(Purchase purchase) {
        /* The query is written as a string, and question marks (?) replace the queries parameter value. For the ID,
        we use NULL because we configured the DBMS to generate the value for this column.*/
        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";

        /*The JdbcTemple update() method sends the query to the database server. The first parameter the method gets is the query,
        and the next parameters are the values for the parameters. These values replace, in the same order, each question mark in the query.*/
        jdbcTemplate.update(sql, purchase.getProduct(),  purchase.getPrice());
    }

    /* The method returns the records it retrieves from the database in a list of Purchase objects. */
    public List<Purchase> findAllPurchases() {
        // We define the SELECT query to get all the records from the purchase table.
        String sql = "SELECT * FROM purchase";

        /* We implement a RowMapper object that tells JdbcTemplate how to map a row in the result set into a Purchase object.
        * In the lambda expression, parameter 'r' is the ResultSet (the data you get from the database), while parameter
        * 'i' is an int representing the row number. */
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            // We set the data into a Purchase instance. JdbcTemplate will use this logic for each row in the result set.
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        /* We send the SELECT query using the query method, and we provide the row mapper object for JdbcTemplate
        to know how to transform the data it gets in Purchase objects. */
        return jdbcTemplate.query(sql, purchaseRowMapper);
    }
}
