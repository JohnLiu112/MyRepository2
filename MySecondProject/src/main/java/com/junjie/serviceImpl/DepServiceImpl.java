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

    public Dep getDepById(Dep dep) {
        if (dep==null){
            return null;
        }
        return depDao.getDepById(dep);
    }

    public Dep getDepByName(Dep dep) {
        if (dep==null){
            return null;
        }
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
