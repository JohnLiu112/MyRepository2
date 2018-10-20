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
    Resume getResumeById(Resume resume);
    Resume getResumeByUid(Resume resume);
    List<Resume> getAllResumes();
}
