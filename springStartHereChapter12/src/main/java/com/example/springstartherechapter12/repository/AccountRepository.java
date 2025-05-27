package com.example.springstartherechapter12.repository;

import com.example.springstartherechapter12.mapper.AccountRowMapper;
import com.example.springstartherechapter12.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        String sql  = "select * from account where id = ?";

        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long ind, BigDecimal amount) {
        String sql  = "update account set amount = ? where id = ?";
        jdbcTemplate.update(sql, amount, ind);
    }

    public List<Account> findAllAccounts() {
        String sql  = "select * from account";

        return jdbcTemplate.query(sql, new AccountRowMapper());
    }
}
