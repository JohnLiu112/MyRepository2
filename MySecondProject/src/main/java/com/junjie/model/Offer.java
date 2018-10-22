package com.junjie.model;

import java.io.Serializable;

/**
 * Created by 刘俊杰 on 2018/10/22.
 */
public class Offer implements Serializable{
    private int offer_id;
    private int offer_resume_id;
    private int offer_recru_id;
    private int offer_sending_state;
    private int offer_emp_state;
    private int offer_u_id;

    @Override
    public String toString() {
        return "Offer{" +
                "offer_id=" + offer_id +
                ", offer_resume_id=" + offer_resume_id +
                ", offer_recru_id=" + offer_recru_id +
                ", offer_sending_state=" + offer_sending_state +
                ", offer_emp_state=" + offer_emp_state +
                ", offer_u_id=" + offer_u_id +
                '}';
    }

    public Offer() {
    }

    public Offer(int offer_resume_id, int offer_recru_id, int offer_sending_state, int offer_emp_state) {
        this.offer_resume_id = offer_resume_id;
        this.offer_recru_id = offer_recru_id;
        this.offer_sending_state = offer_sending_state;
        this.offer_emp_state = offer_emp_state;
    }

    public Offer(int offer_resume_id, int offer_recru_id, int offer_sending_state, int offer_emp_state, int offer_u_id) {
        this.offer_resume_id = offer_resume_id;
        this.offer_recru_id = offer_recru_id;
        this.offer_sending_state = offer_sending_state;
        this.offer_emp_state = offer_emp_state;
        this.offer_u_id = offer_u_id;
    }

    public int getOffer_u_id() {
        return offer_u_id;
    }

    public void setOffer_u_id(int offer_u_id) {
        this.offer_u_id = offer_u_id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getOffer_resume_id() {
        return offer_resume_id;
    }

    public void setOffer_resume_id(int offer_resume_id) {
        this.offer_resume_id = offer_resume_id;
    }

    public int getOffer_recru_id() {
        return offer_recru_id;
    }

    public void setOffer_recru_id(int offer_recru_id) {
        this.offer_recru_id = offer_recru_id;
    }

    public int getOffer_sending_state() {
        return offer_sending_state;
    }

    public void setOffer_sending_state(int offer_sending_state) {
        this.offer_sending_state = offer_sending_state;
    }

    public int getOffer_emp_state() {
        return offer_emp_state;
    }

    public void setOffer_emp_state(int offer_emp_state) {
        this.offer_emp_state = offer_emp_state;
    }
}
