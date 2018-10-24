package com.junjie.controller;

import com.junjie.model.*;
import com.junjie.service.ItvInfoService;
import com.junjie.service.OfferService;
import com.junjie.service.RecruService;
import com.junjie.service.ResumeService;
import com.junjie.util.DoPage;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
@Controller
@RequestMapping("/recru")
public class RecruController {
    private static  final int PAGESIZE=3;
    @Resource
    private RecruService recruService;
    @Resource
    private OfferService offerService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private ItvInfoService itvInfoService;

    @RequestMapping("/checkRecru")
    public String checkRecru(HttpSession session, HttpServletRequest request) {
        List<Recru> recrus = recruService.getAllRecrus();
        int totalPages= DoPage.getTotalPages(recrus.size());
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
        List<Recru> recrus1=recruService.getRecrusByLimits(currentPage,PAGESIZE);
        if (recrus1 != null) {
            session.setAttribute("recrus", recrus1);
            session.setAttribute("totalPages",totalPages);
            return "menu/userMenu";
        } else {
            return "menu/userMenu";
        }
    }
    @RequestMapping("/checkRecruDetails")
    public String checkRecruDetails(HttpSession session, HttpServletRequest request){
        int recru_id=Integer.parseInt(request.getParameter("recru_id"));
        System.out.println(recru_id);
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
    @RequestMapping("/job_apply")
    public String jobApply(HttpServletRequest request,HttpSession session){
        int recru_id=Integer.parseInt(request.getParameter("recru_id"));
        Recru recru1=new Recru();
        recru1.setRecru_id(recru_id);
        Recru recru= recruService.getRecruById(recru1);
        User u= (User) session.getAttribute("u");
        System.out.println(recru_id);
        System.out.println(u.getU_id());
        System.out.println(offerService.getOfferByRecruIdAndUid(recru_id,u.getU_id()));
        if (offerService.getOfferByRecruIdAndUid(recru_id,u.getU_id())==null){
            Resume resume=new Resume();
            resume.setRsm_u_id(u.getU_id());
            Resume resume1=resumeService.getResumeByUid(resume);
            Offer offer=new Offer(resume1.getRsm_id(),recru_id,0,0,u.getU_id());
            if (offerService.addOffer(offer)){
                recru.setRecru_state(1);
                recruService.updateRecru(recru);
                return "redirect:checkRecru?currentPage=1";
            }else {
                request.setAttribute("msg","申请失败");
                return "redirect:recru/checkRecru";
            }
        }else {
            request.setAttribute("msg","已经申请过此职位");
            return "recru/checkRecruDetails";
        }


    }

    @RequestMapping("/toJobApplied")
    public String toJobApplied(HttpServletRequest request,HttpSession session){
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
        User u= (User) session.getAttribute("u");
        List<Offer> offers1=offerService.getOffersByUid(u.getU_id());
        System.out.println(offers1);
        int totalPages= DoPage.getTotalPages(offers1.size());
        System.out.println(totalPages);
        List<Offer> offers=offerService.getOfferByUidAndLimits(u.getU_id(),currentPage,PAGESIZE);
        System.out.println(offers);
        List<Recru> recrus=recruService.getAllRecrus();
        System.out.println(recrus);
        if (offers!=null) {
            session.setAttribute("offers",offers);
            session.setAttribute("recrus",recrus);
            session.setAttribute("totalPages",totalPages);
            return "customer/checkJobApplied";
        }else {
            return "recru/checkRecru";
        }
    }
    @RequestMapping("/checkApplication")
    @ResponseBody
    public Map<String,Object> checkApplication(HttpServletRequest request, HttpSession session){
        int recru_id=Integer.parseInt(request.getParameter("recru_id"));
        User u= (User) session.getAttribute("u");
        Map<String,Object> result=null;
        System.out.println(offerService.getOfferByRecruIdAndUid(recru_id,u.getU_id()));
        if (offerService.getOfferByRecruIdAndUid(recru_id,u.getU_id())==null){
            result=new HashMap<String,Object>();
            result.put("msg","");
            return result;
        }else {
            result=new HashMap<String,Object>();
            result.put("msg","该职位已申请");
            return result;
        }
    }
    @RequestMapping("/saveRecru")
    public String saveRecru(HttpSession session,HttpServletRequest request){
        Recru recru=new Recru(
                request.getParameter("recru_job_name"),
                request.getParameter("recru_firm_name"),
                request.getParameter("recru_workplace"),
                Integer.parseInt(request.getParameter("recru_salary")),
                request.getParameter("recru_release_time"),
                request.getParameter("recru_spec_wp"),
                request.getParameter("recru_job_requirement"),
                request.getParameter("recru_job_duties"),
                request.getParameter("recru_dep_info"),
                request.getParameter("recru_firm_intro"),
                request.getParameter("recru_firm_bonus"),
                Integer.parseInt(request.getParameter("recru_state")));
        System.out.println(recru);
        if (recruService.addRecru(recru)){
            request.setAttribute("msg","添加成功，可继续添加");
            return "administor/addRecru";
        }else {
            request.setAttribute("msg","添加失败，请重新尝试");
            return "administor/addRecru";
        }
    }
    @RequestMapping("/toAddRecru")
    public String toAddRecru(){
        return "administor/addRecru";
    }
    @RequestMapping("/toCheckRecrus")
    public String toCheckRecrus(HttpSession session,HttpServletRequest request){
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
        List<Offer> offers1=offerService.getAllOffers();
        int totalPages= DoPage.getTotalPages(offers1.size());
        List<Offer> offers=offerService.getOfferByLimits(currentPage,PAGESIZE);
        List<Recru> recrus=recruService.getAllRecrus();
        System.out.println(recrus);
        if (offers!=null) {
            session.setAttribute("offers",offers);
            session.setAttribute("recrus",recrus);
            session.setAttribute("totalPages",totalPages);
            return "administor/checkRecrus";
        }else {
            return "menu/AdminMenu";
        }

    }
    //查看申请人简历
    @RequestMapping("/checkResumes")
    public String checkResumes(HttpServletRequest request,HttpSession session){
        int offer_resume_id=Integer.parseInt(request.getParameter("offer_resume_id"));
        int offer_recru_id=Integer.parseInt(request.getParameter("offer_recru_id"));
        int offer_id=Integer.parseInt(request.getParameter("offer_id"));
        int offer_u_id=Integer.parseInt(request.getParameter("offer_u_id"));
        Offer offer=new Offer();
        offer.setOffer_id(offer_id);
        Offer offer1=offerService.getOfferById(offer);
        offer1.setOffer_sending_state(1);
        Resume resume=new Resume();
        resume.setRsm_id(offer_resume_id);
        Resume resume1=resumeService.getResumeById(resume);
        if (resume1==null){
            ItvInfo itvInfo=new ItvInfo(offer_id,offer_u_id,offer_recru_id,0,null,null);
            if (itvInfoService.addItvInfo(itvInfo)){
                return "redirect:toCheckRecrus?currentPage=1";
            }
            request.setAttribute("msg","没有添加游客推送消息");
            session.setAttribute("MyResume",resume1);
            return "administor/CheckResumeOfApplier";
        }else {
            if (offerService.updateOffer(offer1)){
                session.setAttribute("MyResume",resume1);
                return "administor/CheckResumeOfApplier";
            }
            return "redirect:user/adminMenu";
        }

    }
    @RequestMapping("/sendOffer")
    public String sendOffer(HttpServletRequest request){
        int offer_id=Integer.parseInt(request.getParameter("offer_id"));
        ItvInfo itvInfo1=new ItvInfo();
        itvInfo1.setItvInfo_offer_id(offer_id);
        ItvInfo itvInfo=itvInfoService.getItvInfoByOfferId(itvInfo1);

    }
}
