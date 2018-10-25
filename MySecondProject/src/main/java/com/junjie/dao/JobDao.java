package com.junjie.dao;

import com.junjie.model.Job;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
public interface JobDao {
    void addJob(Job job);
    void deleteJob(Job job);
    void updateJob(Job job);
    Job getJobById(Job job);
    List<Job> getJobByDepId(Job job);
    List<Job> getAllJobs();
    List<Job> getJobByDepIdAndLimit(HashMap<String,Object> hashMap);
    List<Job> getJobByLimit(HashMap<String,Object> hashMap);

}
