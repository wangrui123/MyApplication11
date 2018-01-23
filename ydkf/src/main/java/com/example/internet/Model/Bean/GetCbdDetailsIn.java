package com.example.internet.Model.Bean;

/**
 * author: wangrui
 * date : 2017/5/25
 * description :
 */

public class GetCbdDetailsIn {

//    private String bh;
    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "GetCbdDetailsIn{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
