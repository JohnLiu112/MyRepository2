package com.junjie.service;

import com.junjie.model.Offer;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/22.
 */
public interface OfferService {
    boolean addOffer(Offer offer);
    boolean deleteOffer(Offer offer);
    boolean updateOffer(Offer offer);
    Offer getOfferById(Offer offer);
    List<Offer> getAllOffers();
    List<Offer> getOfferByUidAndLimits(int offer_u_id,int beginIndex,int pageSize);
    List<Offer> getOffersByUid(int uid);
    Offer getOfferByRecruIdAndUid(int recru_id,int uid);
}
