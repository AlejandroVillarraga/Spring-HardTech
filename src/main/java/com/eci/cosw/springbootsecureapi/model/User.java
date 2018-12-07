package com.eci.cosw.springbootsecureapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


@Entity
@Table(name = "User" )
public class User
{


    private String name;

    private String password;

    private String cc;

    private String permission;



    public User()
    {
    }

    public User(String name, String password , String cc, String permission) {
        this.cc=cc;
        this.password = password;
        this.name = name;
        this.permission = permission;
    }


    @Column(name = "permission", nullable = false)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Id
    @Column(name = "cc", nullable = false)
    public String getCc()
    {
        return cc;
    }

    public void setCc( String cc )
    {
        this.cc = cc;
    }

    @Column(name = "password", nullable = false)
    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    @Column(name = "name", nullable = false)
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }



}
