package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class ManageDao {
    private JdbcTemplate jdbcTemplate;
    private final static String SELECT_USER_SQL="SELECT user_id,user_num,user_name,user_sex,user_age,password,credits FROM t_user";

    @Autowired
    public ManageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public SqlRowSet ManageSelect(){
        SqlRowSet rs =jdbcTemplate.queryForRowSet(SELECT_USER_SQL);
        return rs;
    }
}
