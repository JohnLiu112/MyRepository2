package com.junjie.serviceImpl;

import com.junjie.dao.ResumeDao;
import com.junjie.model.Resume;
import com.junjie.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/19.
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    public boolean addResume(Resume resume) {
        if (resume==null){
            return false;
        }
        resumeDao.addResume(resume);
        return true;
    }

    public boolean deleteResume(Resume resume) {
        if (resume==null){
            return false;
        }
        resumeDao.deleteResume(resume);
        return true;
    }

    public boolean updateResume(Resume resume) {
        if (resume==null){
            return false;
        }
        resumeDao.updateResume(resume);
        return true;
    }

    public Resume getResumeById(Resume resume) {
        if (resume==null){
            return null;
        }
        return resumeDao.getResumeById(resume);
    }

    public Resume getResumeByUid(Resume resume) {
        if (resume==null){
            return null;
        }
        return resumeDao.getResumeByUid(resume);
    }

    public List<Resume> getAllResumes() {
        return resumeDao.getAllResumes();
    }
}
