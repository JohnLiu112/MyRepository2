package com.junjie.service;

import com.junjie.model.Recru;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
public interface RecruService {
    boolean addRecru(Recru recru);
    boolean deleteRecru(Recru recru);
    boolean updateRecru(Recru recru);
    Recru getRecruById(int recru_id);
    List<Recru> getRecruByState(int recru_state);
    List<Recru> getAllRecrus();
    List<Recru> getRecrusByStateAndLimits(int recru_state,int beginIndex,int pageSize);
    List<Recru> getRecrusByLimits(int beginIndex,int pageSize);
}
