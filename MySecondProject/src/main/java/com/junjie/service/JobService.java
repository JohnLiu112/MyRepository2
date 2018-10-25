package com.junjie.service;

import com.junjie.model.Job;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
public interface JobService {
    boolean addJob(Job job);
    boolean deleteJob(Job job);
    boolean updateJob(Job job);
    Job getJobById(Job job);
    List<Job> getJobByDepId(Job job);
    List<Job> getAllJobs();
    List<Job> getJobByDepIdAndLimit(int job_dep_id,int beginIndex,int pageSize);
    List<Job> getJobByLimit(int beginIndex,int pageSize);
}
