package com.example.sign_lang_ml;

//创建user类，并添加属性和构造方法、get、set方法
public class User {
    public String username;
    public String password;
    public String identity;
    public String phone;
    public String signature;
    public String age;


    public User(){}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.phone = "";
        this.signature = "";
        this.age = "";
        this.identity = "";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }


}
