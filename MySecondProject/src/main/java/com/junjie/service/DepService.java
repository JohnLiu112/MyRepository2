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
    Dep getDepById(Dep dep);
    Dep getDepByName(Dep dep);
    List<Dep> getAllDep();
    List<Dep> getAllDepByLimit(int beginIndex,int pageSize);
}
