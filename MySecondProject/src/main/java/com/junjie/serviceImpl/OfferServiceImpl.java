package com.junjie.serviceImpl;

import com.junjie.dao.OfferDao;
import com.junjie.model.Offer;
import com.junjie.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/22.
 */
@Service
public class OfferServiceImpl implements OfferService{
    @Autowired
    private OfferDao offerDao;

    public boolean addOffer(Offer offer) {
        if (offer==null){
            return false;
        }
        offerDao.addOffer(offer);
        return true;
    }

    public boolean deleteOffer(Offer offer) {
        if (offer==null){
            return false;
        }
        offerDao.deleteOffer(offer);
        return true;
    }

    public boolean updateOffer(Offer offer) {
        if (offer==null){
            return false;
        }
        offerDao.updateOffer(offer);
        return true;
    }

    public Offer getOfferById(Offer offer) {
        if (offer==null){
            return null;
        }
        return offerDao.getOfferById(offer);
    }

    public List<Offer> getAllOffers() {
        return offerDao.getAllOffers();
    }

    public List<Offer> getOfferByLimits(int beginIndex, int pageSize) {
        if (beginIndex<=0||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("beginIndex",(beginIndex-1)*pageSize+1);
        hashMap.put("pageSize",pageSize*beginIndex);
        return offerDao.getOfferByUidAndLimits(hashMap);
    }

    public List<Offer> getOfferByUidAndLimits(int offer_u_id, int beginIndex, int pageSize) {
        if (offer_u_id<=0||beginIndex<=0||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("offer_u_id",offer_u_id);
        hashMap.put("beginIndex",(beginIndex-1)*pageSize+1);
        hashMap.put("pageSize",pageSize*beginIndex);
        return offerDao.getOfferByUidAndLimits(hashMap);
    }

    public List<Offer> getOffersByUid(int uid) {
        if (uid<=0){
            return null;
        }
        return offerDao.getOffersByUid(uid);
    }

    public Offer getOfferByRecruIdAndUid(int recru_id,int uid) {
        if (recru_id<1||uid<1){
            return null;
        }
        System.out.println(recru_id);
        return offerDao.getOfferByRecruIdAndUid(recru_id,uid);
    }

    public List<Offer> getOfferBySendingStateAndLimits(int offer_sending_state, int beginIndex, int pageSize) {
        if (offer_sending_state!=0||beginIndex<=0||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("offer_sending_state",offer_sending_state);
        hashMap.put("beginIndex",(beginIndex-1)*pageSize+1);
        hashMap.put("pageSize",pageSize*beginIndex);
        return offerDao.getOfferBySendingStateAndLimits(hashMap);
    }

    public List<Offer> getOffersBySendingState(Offer offer) {
        if (offer==null){
            return null;
        }
        return offerDao.getOffersBySendingState(offer);
    }
}
