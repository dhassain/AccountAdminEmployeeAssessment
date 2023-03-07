package com.example.ecommerce.signup.repository;

import com.example.ecommerce.signup.model.SignUpModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SignUpRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public int saveOrUpdateDetails(SignUpModel signUpModel){
        String saveQuery = "INSERT INTO users VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(saveQuery, new Object[]{
                signUpModel.getId(),
                signUpModel.getFirstName(),
                signUpModel.getLastName(),
                signUpModel.getEmailId(),
                signUpModel.getPassword(),
        });
    }

    public List<SignUpModel> getAllUsers(){
        String getAllUsersQuery = "SELECT * FROM users";
        return jdbcTemplate.query(getAllUsersQuery, new BeanPropertyRowMapper<>(SignUpModel.class));
    }


}
