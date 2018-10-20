package com.junjie.dao;

import com.junjie.model.Recru;

import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
public interface RecruDao {
    void addRecru(Recru recru);
    void deleteRecru(Recru recru);
    void updateRecru(Recru recru);
    Recru getRecruById(Recru recru);
    List<Recru> getRecruByState(Recru recru);
    List<Recru> getAllRecrus();

}
