package com.example.jwt.domain.user;

import lombok.Data;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String roles; // USER, ADMIN

    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }else{
            return new ArrayList<>();
        }
    }

    public void userRole(){
        this.roles = "ROLE_USER";
    }
    public void managerRole(){
        this.roles = "ROLE_MANAGER";
    }
    public void adminRole(){
        this.roles = "ROLE_ADMIN";
    }
    public void setPwd(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.password = bCryptPasswordEncoder.encode(this.password);
    }
}
