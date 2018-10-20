package com.junjie.service;

import com.junjie.model.Recru;

import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
public interface RecruService {
    boolean addRecru(Recru recru);
    boolean deleteRecru(Recru recru);
    boolean updateRecru(Recru recru);
    Recru getRecruById(Recru recru);
    List<Recru> getRecruByState(Recru recru);
    List<Recru> getAllRecrus();
}
