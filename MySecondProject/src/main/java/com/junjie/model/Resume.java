package com.junjie.model;

import java.io.Serializable;

/**
 * Created by 刘俊杰 on 2018/10/19.
 */
public class Resume implements Serializable {

    private int rsm_id;
    private String rsm_name;
    private String rsm_gender;
    private int rsm_age;
    private String rsm_nationality;
    private String rsm_hometown;
    private String rsm_college;
    private String rsm_major;
    private String rsm_edu_bg;
    private String rsm_post;
    private int rsm_phone;
    private String rsm_email;
    private String rsm_addr;
    private String rsm_self_eval;
    private String rsm_major_intro;
    private String rsm_e_level;
    private String rsm_comp_level;
    private String rsm_social_prac;
    private int rsm_u_id;

    @Override
    public String toString() {
        return "Resume{" +
                "rsm_id=" + rsm_id +
                ", rsm_name='" + rsm_name + '\'' +
                ", rsm_gender='" + rsm_gender + '\'' +
                ", rsm_age=" + rsm_age +
                ", rsm_nationality='" + rsm_nationality + '\'' +
                ", rsm_hometown='" + rsm_hometown + '\'' +
                ", rsm_college='" + rsm_college + '\'' +
                ", rsm_major='" + rsm_major + '\'' +
                ", rsm_edu_bg='" + rsm_edu_bg + '\'' +
                ", rsm_post='" + rsm_post + '\'' +
                ", rsm_phone=" + rsm_phone +
                ", rsm_email='" + rsm_email + '\'' +
                ", rsm_addr='" + rsm_addr + '\'' +
                ", rsm_self_eval='" + rsm_self_eval + '\'' +
                ", rsm_major_intro='" + rsm_major_intro + '\'' +
                ", rsm_e_level='" + rsm_e_level + '\'' +
                ", rsm_comp_level='" + rsm_comp_level + '\'' +
                ", rsm_social_prac='" + rsm_social_prac + '\'' +
                ", rsm_u_id=" + rsm_u_id +
                '}';
    }

    public Resume() {
    }

    public Resume(String rsm_name, String rsm_gender, int rsm_age, String rsm_nationality, String rsm_hometown, String rsm_college, String rsm_major, String rsm_edu_bg, String rsm_post, int rsm_phone, String rsm_email, String rsm_addr, String rsm_self_eval, String rsm_major_intro, String rsm_e_level, String rsm_comp_level, String rsm_social_prac, int rsm_u_id) {
        this.rsm_name = rsm_name;
        this.rsm_gender = rsm_gender;
        this.rsm_age = rsm_age;
        this.rsm_nationality = rsm_nationality;
        this.rsm_hometown = rsm_hometown;
        this.rsm_college = rsm_college;
        this.rsm_major = rsm_major;
        this.rsm_edu_bg = rsm_edu_bg;
        this.rsm_post = rsm_post;
        this.rsm_phone = rsm_phone;
        this.rsm_email = rsm_email;
        this.rsm_addr = rsm_addr;
        this.rsm_self_eval = rsm_self_eval;
        this.rsm_major_intro = rsm_major_intro;
        this.rsm_e_level = rsm_e_level;
        this.rsm_comp_level = rsm_comp_level;
        this.rsm_social_prac = rsm_social_prac;
        this.rsm_u_id = rsm_u_id;
    }

    public int getRsm_id() {
        return rsm_id;
    }

    public void setRsm_id(int rsm_id) {
        this.rsm_id = rsm_id;
    }

    public String getRsm_name() {
        return rsm_name;
    }

    public void setRsm_name(String rsm_name) {
        this.rsm_name = rsm_name;
    }

    public String getRsm_gender() {
        return rsm_gender;
    }

    public void setRsm_gender(String rsm_gender) {
        this.rsm_gender = rsm_gender;
    }

    public int getRsm_age() {
        return rsm_age;
    }

    public void setRsm_age(int rsm_age) {
        this.rsm_age = rsm_age;
    }

    public String getRsm_nationality() {
        return rsm_nationality;
    }

    public void setRsm_nationality(String rsm_nationality) {
        this.rsm_nationality = rsm_nationality;
    }

    public String getRsm_hometown() {
        return rsm_hometown;
    }

    public void setRsm_hometown(String rsm_hometown) {
        this.rsm_hometown = rsm_hometown;
    }

    public String getRsm_college() {
        return rsm_college;
    }

    public void setRsm_college(String rsm_college) {
        this.rsm_college = rsm_college;
    }

    public String getRsm_major() {
        return rsm_major;
    }

    public void setRsm_major(String rsm_major) {
        this.rsm_major = rsm_major;
    }

    public String getRsm_edu_bg() {
        return rsm_edu_bg;
    }

    public void setRsm_edu_bg(String rsm_edu_bg) {
        this.rsm_edu_bg = rsm_edu_bg;
    }

    public String getRsm_post() {
        return rsm_post;
    }

    public void setRsm_post(String rsm_post) {
        this.rsm_post = rsm_post;
    }

    public int getRsm_phone() {
        return rsm_phone;
    }

    public void setRsm_phone(int rsm_phone) {
        this.rsm_phone = rsm_phone;
    }

    public String getRsm_email() {
        return rsm_email;
    }

    public void setRsm_email(String rsm_email) {
        this.rsm_email = rsm_email;
    }

    public String getRsm_addr() {
        return rsm_addr;
    }

    public void setRsm_addr(String rsm_addr) {
        this.rsm_addr = rsm_addr;
    }

    public String getRsm_self_eval() {
        return rsm_self_eval;
    }

    public void setRsm_self_eval(String rsm_self_eval) {
        this.rsm_self_eval = rsm_self_eval;
    }

    public String getRsm_major_intro() {
        return rsm_major_intro;
    }

    public void setRsm_major_intro(String rsm_major_intro) {
        this.rsm_major_intro = rsm_major_intro;
    }

    public String getRsm_e_level() {
        return rsm_e_level;
    }

    public void setRsm_e_level(String rsm_e_level) {
        this.rsm_e_level = rsm_e_level;
    }

    public String getRsm_comp_level() {
        return rsm_comp_level;
    }

    public void setRsm_comp_level(String rsm_comp_level) {
        this.rsm_comp_level = rsm_comp_level;
    }

    public String getRsm_social_prac() {
        return rsm_social_prac;
    }

    public void setRsm_social_prac(String rsm_social_prac) {
        this.rsm_social_prac = rsm_social_prac;
    }

    public int getRsm_u_id() {
        return rsm_u_id;
    }

    public void setRsm_u_id(int rsm_u_id) {
        this.rsm_u_id = rsm_u_id;
    }
}
