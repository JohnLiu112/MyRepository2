package com.junjie.model;

import java.io.Serializable;

/**
 * Created by 刘俊杰 on 2018/10/24.
 */
public class Dep implements Serializable {
    private int dep_id;
    private String dep_name;
    private String dep_create_time;
    private int dep_emp_num;

    @Override
    public String toString() {
        return "Dep{" +
                "dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                ", dep_create_time='" + dep_create_time + '\'' +
                ", dep_emp_num=" + dep_emp_num +
                '}';
    }

    public Dep() {
    }

    public Dep(String dep_name, String dep_create_time, int dep_emp_num) {
        this.dep_name = dep_name;
        this.dep_create_time = dep_create_time;
        this.dep_emp_num = dep_emp_num;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_create_time() {
        return dep_create_time;
    }

    public void setDep_create_time(String dep_create_time) {
        this.dep_create_time = dep_create_time;
    }

    public int getDep_emp_num() {
        return dep_emp_num;
    }

    public void setDep_emp_num(int dep_emp_num) {
        this.dep_emp_num = dep_emp_num;
    }
}
