package com.junjie.service;

import com.junjie.model.ItvInfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/24.
 */
public interface ItvInfoService {
    boolean addItvInfo(ItvInfo itvInfo);
    boolean deleteItvInfo(ItvInfo itvInfo);
    boolean updateItvInfo(ItvInfo itvInfo);
    ItvInfo getItvInfoById(int itvInfo_id);
    ItvInfo getItvInfoByOfferId(int itvInfo_offer_id);
    List<ItvInfo> getItvInfoByUidAndCheckState(int itvInfo_u_id,int itvInfo_u_check_state);
    List<ItvInfo> getItvInfoByUid(int itvInfo_u_id);
    List<ItvInfo> getItvInfoByUidAndLimits(int itvInfo_u_id,int beginIndex,int pageSize);
    List<ItvInfo> getItvInfoByUidAndCheckStateAndByLimit(int itvInfo_u_id,int itvInfo_u_check_state,int beginIndex,int pageSize);
}
