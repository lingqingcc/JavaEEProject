package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ManageDao {
    private JdbcTemplate jdbcTemplate;
    private final static String SELECT_USER_SQL = "SELECT user_id,user_num,user_name,user_sex,user_age,password,credits FROM t_user";
    private final static String DELETE_USER_SQL = "DELETE FROM t_user WHERE user_id=?";
    private final static String QUERY_USER_NUM_SQL = " SELECT user_id,user_num,user_name,user_sex,user_age,password,credits " + " FROM t_user WHERE user_num =? ";
    private final static String QUERY_USER_NAME_SQL = " SELECT user_id,user_num,user_name,user_sex,user_age,password,credits " + " FROM t_user WHERE user_name =? ";
    private final static String REVISE_USER_SQL= " UPDATE t_user SET " + " user_num=?,user_name=?,user_age=?,user_sex=?,password=?,credits=? WHERE user_id =?";

    @Autowired
    public ManageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SqlRowSet ManageSelect() {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_USER_SQL);
        return rs;
    }

    public void ReviseUser(User user){
        jdbcTemplate.update(REVISE_USER_SQL,new Object[] {
                user.getUserNum(),
                user.getUserName(),
                user.getUserAge(),
                user.getUserSex(),
                user.getPassword(),
                user.getCredits(),
                user.getUserId()
        });
    }

    public void DeleteUser(final String userId) {
        jdbcTemplate.update(DELETE_USER_SQL,userId);
    }
    public User QueryNum(final String userNum) {
        final User user = new User();
        jdbcTemplate.query(QUERY_USER_NUM_SQL, new Object[]{userNum},
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
    public User QueryName(final String userName) {
        final User user = new User();
        jdbcTemplate.query(QUERY_USER_NAME_SQL, new Object[]{userName}, sr -> {
            user.setUserId(sr.getInt("user_id"));
            user.setUserNum(sr.getString("user_num"));
            user.setUserName(sr.getString("user_name"));
            user.setUserSex(sr.getString("user_sex"));
            user.setUserAge(sr.getInt("user_age"));
            user.setPassword(sr.getString("password"));
            user.setCredits(sr.getInt("credits"));
        });
        return user;
    }
}