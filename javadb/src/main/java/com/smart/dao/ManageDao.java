package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class ManageDao {
    private JdbcTemplate jdbcTemplate;
    private final static String SELECT_USER_SQL = "SELECT user_id,user_num,user_name,user_sex,user_age,password,credits FROM t_user";
    private final static String DELETE_USER_SQL = "DELETE FROM t_user WHERE user_id=?";
    private final static String QUERY_USER_SQL = "SELECT user_id,user_num,user_name,user_sex,user_age,password,credits"+" FROM t_user WHERE user_id=?";
    @Autowired
    public ManageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SqlRowSet ManageSelect() {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_USER_SQL);
        return rs;
    }

    public void DeleteUser(final String userId) {
        jdbcTemplate.update(DELETE_USER_SQL,userId);
    }
    public User QueryUser(final String userNum) {
        String sqlStr = " SELECT user_id,user_num,user_name,user_sex,user_age,password,credits "
                + " FROM t_user WHERE user_num =? ";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userNum},
                (RowCallbackHandler) sr -> {
                    user.setUserId(sr.getInt(1));
                    user.setUserNum(sr.getString(2));
                    user.setUserName(sr.getString(3));
                    user.setUserSex(sr.getString(4));
                    user.setUserAge(sr.getInt(5));
                    user.setPassword(sr.getString(6));
                    user.setCredits(sr.getInt(7));
                });
        return user;
    }
}