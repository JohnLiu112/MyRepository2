package com.junjie.service;

import com.junjie.model.ItvInfo;
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
    Offer getOfferById(int offer_id);
    List<Offer> getAllOffers();
    List<Offer> getOfferByLimits(int beginIndex, int pageSize);
    List<Offer> getOfferByUidAndLimits(int offer_u_id,int beginIndex,int pageSize);
    List<Offer> getOffersByUid(int offer_u_id);
    Offer getOfferByRecruIdAndUid(int offer_recru_id,int offer_u_id);
    List<Offer> getOfferBySendingStateAndLimits(int offer_sending_state, int beginIndex, int pageSize);
    List<Offer> getOffersBySendingState(int offer_sending_state);
    List<Offer> getOffersByEmpState(int offer_emp_state);
    List<Offer> getOfferByEmpStateAndLimits(int offer_emp_state, int beginIndex, int pageSize);
}
