package com.junjie.service;

import com.junjie.model.Resume;

import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/19.
 */
public interface ResumeService {
    boolean addResume(Resume resume);
    boolean deleteResume(Resume resume);
    boolean updateResume(Resume resume);
    Resume getResumeById(int rsm_id);
    Resume getResumeByUid(int rsm_u_id);
    List<Resume> getAllResumes();
}
