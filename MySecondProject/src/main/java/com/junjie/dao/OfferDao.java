package com.junjie.dao;

import com.junjie.model.Offer;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/22.
 */
public interface OfferDao {
    void addOffer(Offer offer);
    void deleteOffer(Offer offer);
    void updateOffer(Offer offer);
    Offer getOfferById(Offer offer);
    List<Offer> getAllOffers();
    List<Offer> getOfferByUidAndLimits(HashMap<String,Object> hashMap);
    List<Offer> getOfferByLimits(HashMap<String,Object> hashMap);
    List<Offer> getOfferBySendingStateAndLimits(HashMap<String,Object> hashMap);
    List<Offer> getOfferByEmpStateAndLimits(HashMap<String,Object> hashMap);
    List<Offer> getOffersByUid(int offer_u_id);
    List<Offer> getOffersBySendingState(Offer offer);
    List<Offer> getOffersByEmpState(Offer offer);
    Offer getOfferByRecruIdAndUid(int recru_id,int uid);
}
