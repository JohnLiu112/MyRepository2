package com.junjie.model;

import java.io.Serializable;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
public class Job implements Serializable {
    private int job_id;
    private String  job_name;
    private int job_dep_id;
    private int job_emp_num;

    @Override
    public String toString() {
        return "Job{" +
                "job_id=" + job_id +
                ", job_name='" + job_name + '\'' +
                ", job_dep_id=" + job_dep_id +
                ", job_emp_num=" + job_emp_num +
                '}';
    }

    public Job() {
    }

    public Job(String job_name, int job_dep_id, int job_emp_num) {
        this.job_name = job_name;
        this.job_dep_id = job_dep_id;
        this.job_emp_num = job_emp_num;
    }

    public int getJob_emp_num() {
        return job_emp_num;
    }

    public void setJob_emp_num(int job_emp_num) {
        this.job_emp_num = job_emp_num;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public int getJob_dep_id() {
        return job_dep_id;
    }

    public void setJob_dep_id(int job_dep_id) {
        this.job_dep_id = job_dep_id;
    }
}
