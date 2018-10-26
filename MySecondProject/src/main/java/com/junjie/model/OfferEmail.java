package com.junjie.model;

import java.io.Serializable;

/**
 * Created by 刘俊杰 on 2018/10/24.
 */
public class OfferEmail implements Serializable {
    private int oe_id;
    private String oe_info;
    private String oe_emp_name;
    private String oe_emp_pass;
    private int oe_u_id;

    @Override
    public String toString() {
        return "OfferEmail{" +
                "oe_id=" + oe_id +
                ", oe_info='" + oe_info + '\'' +
                ", oe_emp_name='" + oe_emp_name + '\'' +
                ", oe_emp_pass='" + oe_emp_pass + '\'' +
                ", oe_u_id=" + oe_u_id +
                '}';
    }

    public OfferEmail() {
    }

    public OfferEmail(String oe_info, String oe_emp_name, String oe_emp_pass) {
        this.oe_info = oe_info;
        this.oe_emp_name = oe_emp_name;
        this.oe_emp_pass = oe_emp_pass;
    }

    public OfferEmail(String oe_info, String oe_emp_name, String oe_emp_pass, int oe_u_id) {
        this.oe_info = oe_info;
        this.oe_emp_name = oe_emp_name;
        this.oe_emp_pass = oe_emp_pass;
        this.oe_u_id = oe_u_id;
    }

    public int getOe_u_id() {
        return oe_u_id;
    }

    public void setOe_u_id(int oe_u_id) {
        this.oe_u_id = oe_u_id;
    }

    public int getOe_id() {
        return oe_id;
    }

    public void setOe_id(int oe_id) {
        this.oe_id = oe_id;
    }

    public String getOe_info() {
        return oe_info;
    }

    public void setOe_info(String oe_info) {
        this.oe_info = oe_info;
    }

    public String getOe_emp_name() {
        return oe_emp_name;
    }

    public void setOe_emp_name(String oe_emp_name) {
        this.oe_emp_name = oe_emp_name;
    }

    public String getOe_emp_pass() {
        return oe_emp_pass;
    }

    public void setOe_emp_pass(String oe_emp_pass) {
        this.oe_emp_pass = oe_emp_pass;
    }
}
