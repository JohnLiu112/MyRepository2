package com.junjie.service;

import com.junjie.model.OfferEmail;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
public interface OfferEmailService {
    boolean addOfferEmail(OfferEmail offerEmail);
    boolean deleteOfferEmail(OfferEmail offerEmail);
    boolean updateOfferEmail(OfferEmail offerEmail);
    OfferEmail getOfferEmailById(int oe_id);
    List<OfferEmail> getAllOfferEmails();
    List<OfferEmail> getAllOfferEmailsByLimit(int beginIndex,int pageSize);
    List<OfferEmail> getAllOfferEmailsByUid(int oe_u_id);
    List<OfferEmail> getAllOfferEmailsByUidAndByLimit(int oe_u_id,int beginIndex,int pageSize);
}
