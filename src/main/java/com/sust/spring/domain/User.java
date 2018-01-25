package com.sust.spring.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户类
 */
public class User {

    private Long id;
    private String name;      //注册名称
    private String userName;  //真实姓名
    private String password;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateOfBirth;
    private File profileImage;  //上传图片信息

    public User() {
    }

    public User(Long id, String name, String userName, String password, Date dateOfBirth) {
        super();
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public File getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(File profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password
                + ", dateOfBirth=" + dateOfBirth + ", profileImage=" + profileImage + "]";
    }

}
