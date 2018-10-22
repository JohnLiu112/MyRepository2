package com.junjie.serviceImpl;

import com.junjie.dao.RecruDao;
import com.junjie.model.Recru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
@Service
public class RecruServiceImpl implements com.junjie.service.RecruService {
    @Autowired
    private RecruDao recruDao;

    public boolean addRecru(Recru recru) {
        if (recru==null){
            return false;
        }
        recruDao.addRecru(recru);
        return true;
    }

    public boolean deleteRecru(Recru recru) {
        if (recru==null){
            return false;
        }
        recruDao.deleteRecru(recru);
        return true;
    }

    public boolean updateRecru(Recru recru) {
        if (recru==null){
            return false;
        }
        recruDao.updateRecru(recru);
        return true;
    }

    public Recru getRecruById(Recru recru) {
        if (recru==null){
            return null;
        }
        return recruDao.getRecruById(recru);
    }

    public List<Recru> getRecruByState(Recru recru) {
        if (recru==null){
            return null;
        }
        return recruDao.getRecruByState(recru);
    }

    public List<Recru> getAllRecrus() {
        return recruDao.getAllRecrus();
    }

    public List<Recru> getRecrusByStateAndLimits(int recru_state,int beginIndex,int pageSize) {
        if (recru_state!=1||recru_state!=0||beginIndex<=0||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("recru_state",recru_state);
        hashMap.put("beginIndex",(beginIndex-1)*pageSize+1);
        hashMap.put("pageSize",pageSize*beginIndex);
        return recruDao.getRecrusByStateAndLimits(hashMap);
    }

    public List<Recru> getRecrusByLimits(int beginIndex, int pageSize) {
        if (beginIndex<=0||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("beginIndex",(beginIndex-1)*pageSize+1);
        hashMap.put("pageSize",pageSize*beginIndex);
        return recruDao.getRecrusByLimits(hashMap);
    }
}
