package com.junjie.controller;

import com.junjie.model.Recru;
import com.junjie.service.RecruService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
@Controller
@RequestMapping("/recru")
public class RecruController {
    @Resource
    private RecruService recruService;

    @RequestMapping("/checkRecru")
    public String checkRecru(HttpSession session, HttpServletRequest request) {
        List<Recru> recrus = recruService.getAllRecrus();
        if (recrus != null) {
            session.setAttribute("recrus", recrus);
            return "menu/userMenu";
        } else {
            return "menu/userMenu";
        }
    }
    @RequestMapping("/checkRecruDetails")
    public String checkRecruDetails(HttpSession session, HttpServletRequest request){
        int recru_id=Integer.parseInt(request.getParameter("recru_id"));
        Recru recru=new Recru();
        recru.setRecru_id(recru_id);
        Recru recru1=recruService.getRecruById(recru);
        if (recru1!=null){
            session.setAttribute("recru",recru1);
            return "recru/checkRecruDetails";
        }else {
            return "recru/checkRecru";
        }
    }
}
