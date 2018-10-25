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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 刘俊杰 on 2018/10/20.
 */
@Controller
@RequestMapping("/recru")
public class RecruController {
    private static final int PAGESIZE = 3;
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
        User u= (User) session.getAttribute("u");
        System.out.println(u.getU_id());
        List<ItvInfo> itvInfos=itvInfoService.getItvInfoByUidAndCheckState(u.getU_id(),0);
        System.out.println(itvInfos);
        List<Recru> recrus = recruService.getAllRecrus();
        int totalPages = DoPage.getTotalPages(recrus.size());
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        List<Recru> recrus1 = recruService.getRecrusByLimits(currentPage, PAGESIZE);
        if (recrus1 != null) {
            session.setAttribute("recrus", recrus1);
            session.setAttribute("itvInfos",itvInfos);
            session.setAttribute("totalPages", totalPages);
            return "menu/userMenu";
        } else {
            return "menu/userMenu";
        }
    }

    @RequestMapping("/checkRecruDetails")
    public String checkRecruDetails(HttpSession session, HttpServletRequest request) {
        int recru_id = Integer.parseInt(request.getParameter("recru_id"));
        System.out.println(recru_id);
        Recru recru = new Recru();
        recru.setRecru_id(recru_id);
        Recru recru1 = recruService.getRecruById(recru);
        if (recru1 != null) {
            session.setAttribute("recru", recru1);
            return "recru/checkRecruDetails";
        } else {
            return "recru/checkRecru";
        }
    }

    @RequestMapping("/job_apply")
    public String jobApply(HttpServletRequest request, HttpSession session) {
        int recru_id = Integer.parseInt(request.getParameter("recru_id"));
        Recru recru1 = new Recru();
        recru1.setRecru_id(recru_id);
        Recru recru = recruService.getRecruById(recru1);
        User u = (User) session.getAttribute("u");
        System.out.println(recru_id);
        System.out.println(u.getU_id());
        System.out.println(offerService.getOfferByRecruIdAndUid(recru_id, u.getU_id()));
        if (offerService.getOfferByRecruIdAndUid(recru_id, u.getU_id()) == null) {
            Resume resume = new Resume();
            resume.setRsm_u_id(u.getU_id());
            Resume resume1 = resumeService.getResumeByUid(resume);
            Offer offer = new Offer(resume1.getRsm_id(), recru_id, 0, 0, u.getU_id());
            if (offerService.addOffer(offer)) {
                recru.setRecru_state(1);
                recruService.updateRecru(recru);
                return "redirect:checkRecru?currentPage=1";
            } else {
                request.setAttribute("msg", "申请失败");
                return "redirect:recru/checkRecru";
            }
        } else {
            request.setAttribute("msg", "已经申请过此职位");
            return "recru/checkRecruDetails";
        }


    }

    @RequestMapping("/toJobApplied")
    public String toJobApplied(HttpServletRequest request, HttpSession session) {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        User u = (User) session.getAttribute("u");
        List<Offer> offers1 = offerService.getOffersByUid(u.getU_id());
        System.out.println(offers1);
        int totalPages = DoPage.getTotalPages(offers1.size());
        System.out.println(totalPages);
        List<Offer> offers = offerService.getOfferByUidAndLimits(u.getU_id(), currentPage, PAGESIZE);
        System.out.println(offers);
        List<Recru> recrus = recruService.getAllRecrus();
        System.out.println(recrus);
        if (offers != null) {
            session.setAttribute("offers", offers);
            session.setAttribute("recrus", recrus);
            session.setAttribute("totalPages", totalPages);
            return "customer/checkJobApplied";
        } else {
            return "recru/checkRecru";
        }
    }

    @RequestMapping("/checkApplication")
    @ResponseBody
    public Map<String, Object> checkApplication(HttpServletRequest request, HttpSession session) {
        int recru_id = Integer.parseInt(request.getParameter("recru_id"));
        User u = (User) session.getAttribute("u");
        Map<String, Object> result = null;
        System.out.println(offerService.getOfferByRecruIdAndUid(recru_id, u.getU_id()));
        if (offerService.getOfferByRecruIdAndUid(recru_id, u.getU_id()) == null) {
            result = new HashMap<String, Object>();
            result.put("msg", "");
            return result;
        } else {
            result = new HashMap<String, Object>();
            result.put("msg", "该职位已申请");
            return result;
        }
    }

    @RequestMapping("/saveRecru")
    public String saveRecru(HttpSession session, HttpServletRequest request) {
        Recru recru = new Recru(
                request.getParameter("recru_job_name"),
                request.getParameter("recru_firm_name"),
                request.getParameter("recru_workplace"),
                request.getParameter("recru_salary"),
                request.getParameter("recru_release_time"),
                request.getParameter("recru_spec_wp"),
                request.getParameter("recru_job_requirement"),
                request.getParameter("recru_job_duties"),
                request.getParameter("recru_dep_info"),
                request.getParameter("recru_firm_intro"),
                request.getParameter("recru_firm_bonus"),
                Integer.parseInt(request.getParameter("recru_state")));
        System.out.println(recru);
        if (recruService.addRecru(recru)) {
            request.setAttribute("msg", "添加成功，可继续添加");
            return "administor/addRecru";
        } else {
            request.setAttribute("msg", "添加失败，请重新尝试");
            return "administor/addRecru";
        }
    }

    @RequestMapping("/toAddRecru")
    public String toAddRecru() {
        return "administor/addRecru";
    }

    @RequestMapping("/toCheckRecrus")
    public String toCheckRecrus(HttpSession session, HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        Offer offer=new Offer();
        offer.setOffer_sending_state(0);
        List<Offer> offers1 = offerService.getOffersBySendingState(offer);
        int totalPages = DoPage.getTotalPages(offers1.size());
        List<Offer> offers = offerService.getOfferBySendingStateAndLimits(0,currentPage, PAGESIZE);
        List<Recru> recrus = recruService.getAllRecrus();
        System.out.println(recrus);
        System.out.println(offers);
        if (offers != null) {
            session.setAttribute("offers", offers);
            session.setAttribute("recrus", recrus);
            session.setAttribute("totalPages", totalPages);
            return "administor/checkRecrus";
        } else {
            return "menu/AdminMenu";
        }

    }

    //查看申请人简历
    @RequestMapping("/checkResumes")
    public String checkResumes(HttpServletRequest request, HttpSession session) {
        int offer_resume_id = Integer.parseInt(request.getParameter("offer_resume_id"));
        int offer_recru_id = Integer.parseInt(request.getParameter("offer_recru_id"));
        int offer_id = Integer.parseInt(request.getParameter("offer_id"));
        int offer_u_id = Integer.parseInt(request.getParameter("offer_u_id"));
        Resume resume = new Resume();
        resume.setRsm_id(offer_resume_id);
        Resume resume1 = resumeService.getResumeById(resume);
        if (resume1 == null) {
            return "redirect:toCheckRecrus?currentPage=1";
        } else {
            session.setAttribute("offer_recru_id", offer_recru_id);
            session.setAttribute("offer_u_id", offer_u_id);
            session.setAttribute("offer_id", offer_id);
            session.setAttribute("MyResume", resume1);
            return "administor/CheckResumeOfApplier";
        }

    }

    @RequestMapping("/toSetInfoAndTime")
    public String toSetInfoAndTime() {
        return "administor/setItvInfoAndTime";
    }

    @RequestMapping("/sendOffer")
    public String sendOffer(HttpServletRequest request, HttpSession session) {
        int offer_id = (Integer) session.getAttribute("offer_id");
        int offer_u_id = (Integer) session.getAttribute("offer_u_id");
        int offer_recru_id = (Integer) session.getAttribute("offer_recru_id");
        String itv_Info = request.getParameter("itv_Info");
        String itv_time = request.getParameter("itv_time");
        ItvInfo itvInfo = new ItvInfo(offer_id, offer_u_id, offer_recru_id, 0, itv_Info, itv_time);
        if (itvInfoService.addItvInfo(itvInfo)) {
            Offer offer=new Offer();
            offer.setOffer_id(offer_id);
            Offer offer1=offerService.getOfferById(offer);
            offer1.setOffer_sending_state(1);
            if (offerService.updateOffer(offer1)){
                return "redirect:toCheckRecrus?currentPage=1";
            }
        }
        return "administor/CheckResumeOfApplier";

    }

    @RequestMapping("/checkItvInfo1")
    public String checkItvInfo1(HttpSession session,HttpServletRequest request){
        User u= (User) session.getAttribute("u");
        ItvInfo itvInfo=new ItvInfo();
        itvInfo.setItvInfo_u_id(u.getU_id());
        List<ItvInfo> itvInfos1=itvInfoService.getItvInfoByUidAndCheckState(u.getU_id(),0);
        int totalPages = DoPage.getTotalPages(itvInfos1.size());
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        List<ItvInfo> itvInfos=itvInfoService.getItvInfoByUidAndCheckStateAndByLimit(u.getU_id(),0,currentPage,PAGESIZE);
        if (itvInfos!=null){
            session.setAttribute("itvInfos",itvInfos);
            session.setAttribute("totalPages",totalPages);
            List<ItvInfo> itvInfos2=itvInfoService.getItvInfoByUid(itvInfo);
            for (ItvInfo i:itvInfos2) {
                i.setItvInfo_u_check_state(1);
                itvInfoService.updateItvInfo(i);
            }
            return "customer/checkItvInfo";
        }
        return "redirect:checkRecru?currentPage=1";
    }
    @RequestMapping("/checkItvInfo2")
    public String checkItvInfo2(HttpSession session,HttpServletRequest request){
        User u= (User) session.getAttribute("u");
        ItvInfo itvInfo=new ItvInfo();
        itvInfo.setItvInfo_u_id(u.getU_id());
        List<ItvInfo> itvInfos=itvInfoService.getItvInfoByUid(itvInfo);
        int totalPages = DoPage.getTotalPages(itvInfos.size());
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        List<ItvInfo> itvInfos1=itvInfoService.getItvInfoByUidAndLimits(u.getU_id(),currentPage,PAGESIZE);
        if (itvInfos1!=null){
            session.setAttribute("itvInfos",itvInfos);
            session.setAttribute("totalPages",totalPages);
            return "customer/checkItvInfo";
        }
        return "redirect:checkRecru?currentPage=1";
    }
    @RequestMapping("/checkItvTime")
    public void checkItvTime(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String dateOfItv=request.getParameter("itv_time");
        String dateOfFirstPart=dateOfItv.substring(0,10);
        String dateOfLastPart=dateOfItv.substring(11,16);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");


        Date now = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(now);
        c1.add(Calendar.DAY_OF_MONTH, 1);
        now=c1.getTime();
        String date= format.format(now);
        String date1= format1.format(new Date());
        String date2=date+" "+date1;
        Date date3=format2.parse(date2);


        String date6= dateOfFirstPart+" "+dateOfLastPart;
        System.out.println(date6);
        Date date7=format2.parse(date6);
        int res=date7.compareTo(date3);
        System.out.println(res);
        if (res!=-1){
            response.getWriter().write("1");
        }else {
            response.getWriter().write("0");
        }
    }
    @RequestMapping("/toCheckAllRecrus")
    public String toCheckAllRecrus(HttpServletRequest request,HttpSession session){
        List<Recru> recrus = recruService.getAllRecrus();
        int totalPages = DoPage.getTotalPages(recrus.size());
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        List<Recru> recrus1 = recruService.getRecrusByLimits(currentPage, PAGESIZE);
        if (recrus1 != null) {
            session.setAttribute("recrus", recrus1);
            session.setAttribute("totalPages", totalPages);
            return "administor/checkAllRecrus";
        } else {
            return "redirect:/user/adminMenu";
        }
    }
    @RequestMapping("/checkRecruDetails1")
    public String checkRecruDetails(HttpServletRequest request,HttpSession session){
        int recru_id = Integer.parseInt(request.getParameter("recru_id"));
        Recru recru = new Recru();
        recru.setRecru_id(recru_id);
        Recru recru1 = recruService.getRecruById(recru);
        if (recru1 != null) {
            session.setAttribute("recru", recru1);
            return "administor/checkRecruDetails2";
        } else {
            return "recru/checkRecru";
        }
    }
    @RequestMapping("/toUpdateRecruDetails1")
    public String toUpdateRecruDetails1(HttpServletRequest request,HttpSession session){
        int recru_id = Integer.parseInt(request.getParameter("recru_id"));
        Recru recru = new Recru();
        recru.setRecru_id(recru_id);
        Recru recru1 = recruService.getRecruById(recru);
        if (recru1 != null) {
            session.setAttribute("recru", recru1);
            return "administor/updateRecruDetails2";
        } else {
            return "recru/checkRecru";
        }
    }
    @RequestMapping("/updateRecruDetails1")
    public String updateRecruDetails1(HttpServletRequest request,HttpSession session){
        System.out.println(Integer.parseInt(request.getParameter("recru_state")));
        Recru recru = new Recru(
                request.getParameter("recru_job_name"),
                request.getParameter("recru_firm_name"),
                request.getParameter("recru_workplace"),
                request.getParameter("recru_salary"),
                request.getParameter("recru_release_time"),
                request.getParameter("recru_spec_wp"),
                request.getParameter("recru_job_requirement"),
                request.getParameter("recru_job_duties"),
                request.getParameter("recru_dep_info"),
                request.getParameter("recru_firm_intro"),
                request.getParameter("recru_firm_bonus"),
                Integer.parseInt(request.getParameter("recru_state")));
        recru.setRecru_id(Integer.parseInt(request.getParameter("recru_id")));
        int recru_id=Integer.parseInt(request.getParameter("recru_id"));
        if (recruService.updateRecru(recru)){

            return "redirect:toUpdateRecruDetails1?recru_id="+recru_id;
        }else {
            return "redirect:toUpdateRecruDetails1";
        }
    }

    @RequestMapping("/deleteRecruDetails1")
    public String deleteRecruDetails1(HttpSession session,HttpServletRequest request){
        int recru_id = Integer.parseInt(request.getParameter("recru_id"));
        Recru recru = new Recru();
        recru.setRecru_id(recru_id);
        if (recruService.deleteRecru(recru)){
            return "redirect:toCheckAllRecrus?currentPage=1";
        }else {
            return "redirect:toCheckAllRecrus?currentPage=1";
        }
    }

}
