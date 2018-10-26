package com.junjie.model;

import java.io.Serializable;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
public class Emp implements Serializable {
    private int emp_id;
    private String  emp_name;
    private String emp_account;
    private String emp_pass;
    private String emp_gender;
    private int emp_age;
    private String emp_hometown;
    private int emp_salary;
    private int emp_job_id;
    private int emp_dep_id;
    private int emp_on_off;
    private String emp_off_reason;
    private int emp_phoneNum;
    private String emp_email;

    @Override
    public String toString() {
        return "Emp{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_account='" + emp_account + '\'' +
                ", emp_pass='" + emp_pass + '\'' +
                ", emp_gender='" + emp_gender + '\'' +
                ", emp_age=" + emp_age +
                ", emp_hometown='" + emp_hometown + '\'' +
                ", emp_salary=" + emp_salary +
                ", emp_job_id=" + emp_job_id +
                ", emp_dep_id=" + emp_dep_id +
                ", emp_on_off=" + emp_on_off +
                ", emp_off_reason='" + emp_off_reason + '\'' +
                ", emp_phoneNum=" + emp_phoneNum +
                ", emp_email='" + emp_email + '\'' +
                '}';
    }

    public Emp() {
    }

    public Emp(String rsm_name, String rsm_email, int rsm_phone, String rsm_gender, int rsm_age, String rsm_hometown, int emp_salary, int job_id, int dep_id, int emp_on_off, Object emp_off_reason, int rsmPhone, String rsmEmail) {

    }

    public Emp(String emp_name, String emp_account, String emp_pass, String emp_gender, int emp_age, String emp_hometown, int emp_salary, int emp_job_id, int emp_dep_id, int emp_on_off, String emp_off_reason, int emp_phoneNum, String emp_email) {
        this.emp_name = emp_name;
        this.emp_account = emp_account;
        this.emp_pass = emp_pass;
        this.emp_gender = emp_gender;
        this.emp_age = emp_age;
        this.emp_hometown = emp_hometown;
        this.emp_salary = emp_salary;
        this.emp_job_id = emp_job_id;
        this.emp_dep_id = emp_dep_id;
        this.emp_on_off = emp_on_off;
        this.emp_off_reason = emp_off_reason;
        this.emp_phoneNum = emp_phoneNum;
        this.emp_email = emp_email;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_account() {
        return emp_account;
    }

    public void setEmp_account(String emp_account) {
        this.emp_account = emp_account;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_hometown() {
        return emp_hometown;
    }

    public void setEmp_hometown(String emp_hometown) {
        this.emp_hometown = emp_hometown;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(int emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getEmp_job_id() {
        return emp_job_id;
    }

    public void setEmp_job_id(int emp_job_id) {
        this.emp_job_id = emp_job_id;
    }

    public int getEmp_dep_id() {
        return emp_dep_id;
    }

    public void setEmp_dep_id(int emp_dep_id) {
        this.emp_dep_id = emp_dep_id;
    }

    public int getEmp_on_off() {
        return emp_on_off;
    }

    public void setEmp_on_off(int emp_on_off) {
        this.emp_on_off = emp_on_off;
    }

    public String getEmp_off_reason() {
        return emp_off_reason;
    }

    public void setEmp_off_reason(String emp_off_reason) {
        this.emp_off_reason = emp_off_reason;
    }

    public int getEmp_phoneNum() {
        return emp_phoneNum;
    }

    public void setEmp_phoneNum(int emp_phoneNum) {
        this.emp_phoneNum = emp_phoneNum;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }
}
