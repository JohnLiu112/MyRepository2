package com.junjie.dao;

import com.junjie.model.Resume;

import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/19.
 */
public interface ResumeDao {
    void addResume(Resume resume);
    void deleteResume(Resume resume);
    void updateResume(Resume resume);
    Resume getResumeById(Resume resume);
    Resume getResumeByUid(Resume resume);
    List<Resume> getAllResumes();
}
