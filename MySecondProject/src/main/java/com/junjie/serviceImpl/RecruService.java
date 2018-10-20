package com.junjie.serviceImpl;

import com.junjie.dao.RecruDao;
import com.junjie.model.Recru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
@Service
public class RecruService implements com.junjie.service.RecruService {
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
}
