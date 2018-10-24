package com.junjie.dao;

import com.junjie.model.ItvInfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/23.
 */
public interface ItvInfoDao {
    /*这个是管理员发送offer后会生成的一张表，上面有信息状态，用户id，招聘信息id
    * state为0时为未读信息，点击查看时为变为1，显示为已查看
    * itv=interview+info=面试信息
    * */

    void addItvInfo(ItvInfo itvInfo);
    void deleteItvInfo(ItvInfo itvInfo);
    void updateItvInfo(ItvInfo itvInfo);
    ItvInfo getItvInfoById(ItvInfo itvInfo);
    ItvInfo getItvInfoByOfferId(ItvInfo itvInfo);
    List<ItvInfo> getItvInfoByUidAndCheckState(HashMap<String,Object> hashMap);
    List<ItvInfo> getItvInfoByUid(ItvInfo itvInfo);
    List<ItvInfo> getItvInfoByUidAndLimits(HashMap<String,Object> hashMap);
    List<ItvInfo> getItvInfoByUidAndCheckStateAndByLimit(HashMap<String,Object> hashMap);
}
