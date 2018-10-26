package com.junjie.dao;

import com.junjie.model.OfferEmail;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/24.
 */
public interface OfferEmailDao {
    void addOfferEmail(OfferEmail offerEmail);
    void deleteOfferEmail(OfferEmail offerEmail);
    void updateOfferEmail(OfferEmail offerEmail);
    OfferEmail getOfferEmailById(OfferEmail offerEmail);
    List<OfferEmail> getAllOfferEmails();
    List<OfferEmail> getAllOfferEmailsByUid(OfferEmail offerEmail);
    List<OfferEmail> getAllOfferEmailsByLimit(HashMap<String,Object> hashMap);
    List<OfferEmail> getAllOfferEmailsByUidAndByLimit(HashMap<String,Object> hashMap);
}
