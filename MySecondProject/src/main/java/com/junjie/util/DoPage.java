package com.junjie.util;

/**
 * Created by 刘俊杰 on 2018/9/7.
 */
public class DoPage {
    private static final int PAGESIZE=3;

    public static int getTotalPages(int totalRows){
        return totalRows%PAGESIZE==0?totalRows/PAGESIZE:(totalRows/PAGESIZE)+1;
    }

}
