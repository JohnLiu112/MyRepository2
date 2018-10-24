package com.junjie.model;

import java.io.Serializable;

/**
 * Created by 刘俊杰 on 2018/10/23.
 */
public class ItvInfo implements Serializable {
    private int itvInfo_id;
    private int itvInfo_offer_id;
    private int itvInfo_u_id;
    private int itvInfo_recru_id;
    private int itvInfo_u_check_state;
    private String itvInfo_info;
    private String itvInfo_itv_time;

    @Override
    public String toString() {
        return "ItvInfo{" +
                "itvInfo_id=" + itvInfo_id +
                ", itvInfo_offer_id=" + itvInfo_offer_id +
                ", itvInfo_u_id=" + itvInfo_u_id +
                ", itvInfo_recru_id=" + itvInfo_recru_id +
                ", itvInfo_u_check_state=" + itvInfo_u_check_state +
                ", itvInfo_info='" + itvInfo_info + '\'' +
                ", itvInfo_itv_time='" + itvInfo_itv_time + '\'' +
                '}';
    }

    public ItvInfo() {
    }


    public ItvInfo(int itvInfo_offer_id, int itvInfo_u_id, int itvInfo_recru_id, int itvInfo_u_check_state, String itvInfo_info, String itvInfo_itv_time) {
        this.itvInfo_offer_id = itvInfo_offer_id;
        this.itvInfo_u_id = itvInfo_u_id;
        this.itvInfo_recru_id = itvInfo_recru_id;
        this.itvInfo_u_check_state = itvInfo_u_check_state;
        this.itvInfo_info = itvInfo_info;
        this.itvInfo_itv_time = itvInfo_itv_time;
    }

    public String getItvInfo_info() {
        return itvInfo_info;
    }

    public void setItvInfo_info(String itvInfo_info) {
        this.itvInfo_info = itvInfo_info;
    }

    public String getItvInfo_itv_time() {
        return itvInfo_itv_time;
    }

    public void setItvInfo_itv_time(String itvInfo_itv_time) {
        this.itvInfo_itv_time = itvInfo_itv_time;
    }

    public int getItvInfo_id() {
        return itvInfo_id;
    }

    public void setItvInfo_id(int itvInfo_id) {
        this.itvInfo_id = itvInfo_id;
    }

    public int getItvInfo_offer_id() {
        return itvInfo_offer_id;
    }

    public void setItvInfo_offer_id(int itvInfo_offer_id) {
        this.itvInfo_offer_id = itvInfo_offer_id;
    }

    public int getItvInfo_u_id() {
        return itvInfo_u_id;
    }

    public void setItvInfo_u_id(int itvInfo_u_id) {
        this.itvInfo_u_id = itvInfo_u_id;
    }

    public int getItvInfo_recru_id() {
        return itvInfo_recru_id;
    }

    public void setItvInfo_recru_id(int itvInfo_recru_id) {
        this.itvInfo_recru_id = itvInfo_recru_id;
    }

    public int getItvInfo_u_check_state() {
        return itvInfo_u_check_state;
    }

    public void setItvInfo_u_check_state(int itvInfo_u_check_state) {
        this.itvInfo_u_check_state = itvInfo_u_check_state;
    }
}
