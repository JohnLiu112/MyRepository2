package com.junjie.serviceImpl;

import com.junjie.dao.JobDao;
import com.junjie.model.Job;
import com.junjie.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;
    public boolean addJob(Job job) {
        if (job==null){
            return false;
        }
        jobDao.addJob(job);
        return true;
    }

    public boolean deleteJob(Job job) {
        if (job==null){
            return false;
        }
        jobDao.deleteJob(job);
        return true;
    }

    public boolean updateJob(Job job) {
        if (job==null){
            return false;
        }
        jobDao.updateJob(job);
        return true;
    }

    public Job getJobById(int job_id) {
        if (job_id<1){
            return null;
        }
        Job job=new Job();
        job.setJob_id(job_id);
        return jobDao.getJobById(job);
    }

    public List<Job> getJobByDepId(int job_dep_id) {
        if (job_dep_id<1){
            return null;
        }
        Job job=new Job();
        job.setJob_dep_id(job_dep_id);
        return jobDao.getJobByDepId(job);
    }

    public List<Job> getAllJobs() {
        return jobDao.getAllJobs();
    }

    public List<Job> getJobByDepIdAndLimit(int job_dep_id, int beginIndex, int pageSize) {
        if (job_dep_id<=0||beginIndex<1||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("job_dep_id",job_dep_id);
        hashMap.put("beginIndex",beginIndex);
        hashMap.put("pageSize",pageSize);
        return jobDao.getJobByDepIdAndLimit(hashMap);
    }

    public List<Job> getJobByLimit(int beginIndex, int pageSize) {
        if (beginIndex<1||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("beginIndex",beginIndex);
        hashMap.put("pageSize",pageSize);
        return jobDao.getJobByLimit(hashMap);
    }
}
