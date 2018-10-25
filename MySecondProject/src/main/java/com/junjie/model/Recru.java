package com.junjie.model;

import java.io.Serializable;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
public class Recru implements Serializable {
    private int recru_id;
    private String recru_job_name;
    private String recru_firm_name;
    private String recru_workplace;
    private String recru_salary;
    private String recru_release_time;
    private String recru_spec_wp;
    private String recru_job_requirement;
    private String recru_job_duties;
    private String recru_dep_info;
    private String recru_firm_intro;
    private String recru_firm_bonus;
    private int recru_state;


    @Override
    public String toString() {
        return "Recru{" +
                "recru_id=" + recru_id +
                ", recru_job_name='" + recru_job_name + '\'' +
                ", recru_firm_name='" + recru_firm_name + '\'' +
                ", recru_workplace='" + recru_workplace + '\'' +
                ", recru_salary=" + recru_salary +
                ", recru_release_time='" + recru_release_time + '\'' +
                ", recru_spec_wp='" + recru_spec_wp + '\'' +
                ", recru_job_requirement='" + recru_job_requirement + '\'' +
                ", recru_job_duties='" + recru_job_duties + '\'' +
                ", recru_dep_info='" + recru_dep_info + '\'' +
                ", recru_firm_intro='" + recru_firm_intro + '\'' +
                ", recru_firm_bonus='" + recru_firm_bonus + '\'' +
                ", recru_state=" + recru_state +
                '}';
    }

    public Recru() {
    }

    public Recru(String recru_job_name, String recru_firm_name, String recru_workplace, String recru_salary, String recru_release_time, String recru_spec_wp, String recru_job_requirement, String recru_job_duties, String recru_dep_info, String recru_firm_intro, String recru_firm_bonus, int recru_state) {
        this.recru_job_name = recru_job_name;
        this.recru_firm_name = recru_firm_name;
        this.recru_workplace = recru_workplace;
        this.recru_salary = recru_salary;
        this.recru_release_time = recru_release_time;
        this.recru_spec_wp = recru_spec_wp;
        this.recru_job_requirement = recru_job_requirement;
        this.recru_job_duties = recru_job_duties;
        this.recru_dep_info = recru_dep_info;
        this.recru_firm_intro = recru_firm_intro;
        this.recru_firm_bonus = recru_firm_bonus;
        this.recru_state = recru_state;
    }

    public int getRecru_id() {
        return recru_id;
    }

    public void setRecru_id(int recru_id) {
        this.recru_id = recru_id;
    }

    public String getRecru_job_name() {
        return recru_job_name;
    }

    public void setRecru_job_name(String recru_job_name) {
        this.recru_job_name = recru_job_name;
    }

    public String getRecru_firm_name() {
        return recru_firm_name;
    }

    public void setRecru_firm_name(String recru_firm_name) {
        this.recru_firm_name = recru_firm_name;
    }

    public String getRecru_workplace() {
        return recru_workplace;
    }

    public void setRecru_workplace(String recru_workplace) {
        this.recru_workplace = recru_workplace;
    }

    public String getRecru_salary() {
        return recru_salary;
    }

    public void setRecru_salary(String recru_salary) {
        this.recru_salary = recru_salary;
    }

    public String getRecru_release_time() {
        return recru_release_time;
    }

    public void setRecru_release_time(String recru_release_time) {
        this.recru_release_time = recru_release_time;
    }

    public String getRecru_spec_wp() {
        return recru_spec_wp;
    }

    public void setRecru_spec_wp(String recru_spec_wp) {
        this.recru_spec_wp = recru_spec_wp;
    }

    public String getRecru_job_requirement() {
        return recru_job_requirement;
    }

    public void setRecru_job_requirement(String recru_job_requirement) {
        this.recru_job_requirement = recru_job_requirement;
    }

    public String getRecru_job_duties() {
        return recru_job_duties;
    }

    public void setRecru_job_duties(String recru_job_duties) {
        this.recru_job_duties = recru_job_duties;
    }

    public String getRecru_dep_info() {
        return recru_dep_info;
    }

    public void setRecru_dep_info(String recru_dep_info) {
        this.recru_dep_info = recru_dep_info;
    }

    public String getRecru_firm_intro() {
        return recru_firm_intro;
    }

    public void setRecru_firm_intro(String recru_firm_intro) {
        this.recru_firm_intro = recru_firm_intro;
    }

    public String getRecru_firm_bonus() {
        return recru_firm_bonus;
    }

    public void setRecru_firm_bonus(String recru_firm_bonus) {
        this.recru_firm_bonus = recru_firm_bonus;
    }

    public int getRecru_state() {
        return recru_state;
    }

    public void setRecru_state(int recru_state) {
        this.recru_state = recru_state;
    }
}
