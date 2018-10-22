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
    List<Offer> getOffersByUid(int uid);
    Offer getOfferByRecruIdAndUid(int recru_id,int uid);
}
