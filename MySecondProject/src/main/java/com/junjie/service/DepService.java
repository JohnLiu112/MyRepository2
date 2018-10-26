package com.junjie.service;

import com.junjie.model.Dep;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/24.
 */
public interface DepService {
    boolean addDep(Dep dep);
    boolean deleteDep(Dep dep);
    boolean updateDep(Dep dep);
    Dep getDepById(int dep_id);
    Dep getDepByName(String dep_name);
    List<Dep> getAllDep();
    List<Dep> getAllDepByLimit(int beginIndex,int pageSize);
}
