package com.junjie.dao;

import com.junjie.model.Dep;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/24.
 */
public interface DepDao {
    void addDep(Dep dep);
    void deleteDep(Dep dep);
    void updateDep(Dep dep);
    Dep getDepById(Dep dep);
    Dep getDepByName(Dep dep);
    List<Dep> getAllDep();
    List<Dep> getAllDepByLimit(HashMap<String,Object> hashMap);
}
