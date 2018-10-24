package com.junjie.serviceImpl;

import com.junjie.dao.ItvInfoDao;
import com.junjie.model.ItvInfo;
import com.junjie.service.ItvInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/24.
 */
@Service
public class ItvServiceImpl implements ItvInfoService {

    @Autowired
    private ItvInfoDao itvInfoDao;
    public boolean addItvInfo(ItvInfo itvInfo) {
        if (itvInfo==null){
            return false;
        }
        itvInfoDao.addItvInfo(itvInfo);
        return true;
    }

    public boolean deleteItvInfo(ItvInfo itvInfo) {
        if (itvInfo==null){
            return false;
        }
        itvInfoDao.deleteItvInfo(itvInfo);
        return true;
    }

    public boolean updateItvInfo(ItvInfo itvInfo) {
        if (itvInfo==null){
            return false;
        }
        itvInfoDao.updateItvInfo(itvInfo);
        return true;
    }

    public ItvInfo getItvInfoById(ItvInfo itvInfo) {
        if (itvInfo==null){
            return null;
        }
        return itvInfoDao.getItvInfoById(itvInfo);
    }

    public ItvInfo getItvInfoByOfferId(ItvInfo itvInfo) {
        if (itvInfo==null){
            return null;
        }
        return itvInfoDao.getItvInfoByOfferId(itvInfo);
    }

    public List<ItvInfo> getItvInfoByUidAndCheckState(int itvInfo_u_id, int itvInfo_u_check_state) {
        if (itvInfo_u_id<=0||(itvInfo_u_check_state!=0&&itvInfo_u_check_state!=1)){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("itvInfo_u_id",itvInfo_u_id);
        hashMap.put("itvInfo_u_check_state",itvInfo_u_check_state);
        System.out.println(itvInfoDao.getItvInfoByUidAndCheckState(hashMap));
        return itvInfoDao.getItvInfoByUidAndCheckState(hashMap);

    }

    public List<ItvInfo> getItvInfoByUid(ItvInfo itvInfo) {
        if (itvInfo==null){
            return null;
        }
        return itvInfoDao.getItvInfoByUid(itvInfo);
    }

    public List<ItvInfo> getItvInfoByUidAndLimits(int itvInfo_u_id, int beginIndex, int pageSize) {
        if (itvInfo_u_id<=0||beginIndex<=0||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("itvInfo_u_id",itvInfo_u_id);
        hashMap.put("beginIndex",(beginIndex-1)*pageSize+1);
        hashMap.put("pageSize",pageSize*beginIndex);
        return itvInfoDao.getItvInfoByUidAndLimits(hashMap);
    }

    public List<ItvInfo> getItvInfoByUidAndCheckStateAndByLimit(int itvInfo_u_id, int itvInfo_u_check_state, int beginIndex, int pageSize) {
        if (itvInfo_u_id<=0||beginIndex<=0||pageSize<1||(itvInfo_u_check_state!=1&&itvInfo_u_check_state!=0)){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("itvInfo_u_id",itvInfo_u_id);
        hashMap.put("itvInfo_u_check_state",itvInfo_u_check_state);
        hashMap.put("beginIndex",(beginIndex-1)*pageSize+1);
        hashMap.put("pageSize",pageSize*beginIndex);
        return itvInfoDao.getItvInfoByUidAndCheckStateAndByLimit(hashMap);
    }
}
