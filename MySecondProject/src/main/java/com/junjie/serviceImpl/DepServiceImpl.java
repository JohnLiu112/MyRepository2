package com.junjie.serviceImpl;

import com.junjie.dao.DepDao;
import com.junjie.model.Dep;
import com.junjie.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/24.
 */
@Service
public class DepServiceImpl implements DepService {

    @Autowired
    private DepDao depDao;

    public boolean addDep(Dep dep) {
        if (dep==null){
            return false;
        }
        depDao.addDep(dep);
        return true;
    }

    public boolean deleteDep(Dep dep) {
        if (dep==null){
            return false;
        }
        depDao.deleteDep(dep);
        return true;
    }

    public boolean updateDep(Dep dep) {
        if (dep==null){
            return false;
        }
        depDao.updateDep(dep);
        return true;
    }

    public Dep getDepById(int dep_id) {
        if (dep_id<1){
            return null;
        }
        Dep dep=new Dep();
        dep.setDep_id(dep_id);
        return depDao.getDepById(dep);
    }

    public Dep getDepByName(String dep_name) {
        if (dep_name==null){
            return null;
        }
        Dep dep=new Dep();
        dep.setDep_name(dep_name);
        return depDao.getDepByName(dep);
    }

    public List<Dep> getAllDep() {
        return depDao.getAllDep();
    }

    public List<Dep> getAllDepByLimit(int beginIndex,int pageSize) {
        if (beginIndex<=0||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("beginIndex",beginIndex);
        hashMap.put("pageSize",pageSize);
        return depDao.getAllDepByLimit(hashMap);
    }

}
