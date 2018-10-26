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

    public Offer getOfferById(int offer_id) {
        if (offer_id<1){
            return null;
        }
        Offer offer=new Offer();
        offer.setOffer_id(offer_id);
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

    public List<Offer> getOffersByUid(int offer_u_id) {
        if (offer_u_id<=0){
            return null;
        }
        return offerDao.getOffersByUid(offer_u_id);
    }

    public Offer getOfferByRecruIdAndUid(int offer_recru_id,int offer_u_id) {
        if (offer_recru_id<1||offer_u_id<1){
            return null;
        }
        System.out.println(offer_recru_id);
        return offerDao.getOfferByRecruIdAndUid(offer_recru_id,offer_u_id);
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

    public List<Offer> getOffersBySendingState(int offer_sending_state) {
        if (offer_sending_state<0||offer_sending_state>1){
            return null;
        }
        Offer offer=new Offer();
        offer.setOffer_emp_state(offer_sending_state);
        return offerDao.getOffersBySendingState(offer);
    }

    public List<Offer> getOffersByEmpState(int offer_emp_state) {
        if (offer_emp_state<0||offer_emp_state>2){
            return null;
        }
        Offer offer=new Offer();
        offer.setOffer_emp_state(offer_emp_state);
        return offerDao.getOffersByEmpState(offer);
    }

    public List<Offer> getOfferByEmpStateAndLimits(int offer_emp_state, int beginIndex, int pageSize) {
        if (offer_emp_state!=0||beginIndex<=0||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("offer_emp_state",offer_emp_state);
        hashMap.put("beginIndex",(beginIndex-1)*pageSize+1);
        hashMap.put("pageSize",pageSize*beginIndex);
        return offerDao.getOfferBySendingStateAndLimits(hashMap);
    }
}
