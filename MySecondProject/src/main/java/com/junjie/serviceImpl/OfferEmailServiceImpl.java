package com.junjie.serviceImpl;

import com.junjie.dao.OfferEmailDao;
import com.junjie.model.OfferEmail;
import com.junjie.service.OfferEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
@Service
public class OfferEmailServiceImpl implements OfferEmailService {
    @Autowired
    private OfferEmailDao offerEmailDao;
    public boolean addOfferEmail(OfferEmail offerEmail) {
        if (offerEmail==null){
            return false;
        }
        offerEmailDao.addOfferEmail(offerEmail);
        return true;
    }

    public boolean deleteOfferEmail(OfferEmail offerEmail) {
        if (offerEmail==null){
            return false;
        }
        offerEmailDao.deleteOfferEmail(offerEmail);
        return true;
    }

    public boolean updateOfferEmail(OfferEmail offerEmail) {
        if (offerEmail==null){
            return false;
        }
        offerEmailDao.updateOfferEmail(offerEmail);
        return true;
    }

    public OfferEmail getOfferEmailById(int oe_id) {
        if (oe_id<1){
            return null;
        }
        OfferEmail offerEmail=new OfferEmail();
        offerEmail.setOe_id(oe_id);
        return offerEmailDao.getOfferEmailById(offerEmail);
    }

    public List<OfferEmail> getAllOfferEmails() {
        return offerEmailDao.getAllOfferEmails();
    }

    public List<OfferEmail> getAllOfferEmailsByLimit(int beginIndex, int pageSize) {
        if (beginIndex<1||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("beginIndex",beginIndex);
        hashMap.put("pageSize",pageSize);
        return offerEmailDao.getAllOfferEmailsByLimit(hashMap);
    }

    public List<OfferEmail> getAllOfferEmailsByUid(int oe_u_id) {
        if (oe_u_id<1){
            return null;
        }
        OfferEmail offerEmail=new OfferEmail();
        offerEmail.setOe_u_id(oe_u_id);
        return offerEmailDao.getAllOfferEmailsByUid(offerEmail);
    }

    public List<OfferEmail> getAllOfferEmailsByUidAndByLimit(int oe_u_id, int beginIndex, int pageSize) {
        if (oe_u_id<1||beginIndex<1||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("oe_u_id",oe_u_id);
        hashMap.put("beginIndex",beginIndex);
        hashMap.put("pageSize",pageSize);
        return offerEmailDao.getAllOfferEmailsByLimit(hashMap);
    }
}
