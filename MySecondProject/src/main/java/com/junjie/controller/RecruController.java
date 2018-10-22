package com.junjie.controller;

import com.junjie.model.Offer;
import com.junjie.model.Recru;
import com.junjie.model.Resume;
import com.junjie.model.User;
import com.junjie.service.OfferService;
import com.junjie.service.RecruService;
import com.junjie.service.ResumeService;
import com.junjie.util.DoPage;
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
    private static  final int PAGESIZE=3;
    @Resource
    private RecruService recruService;
    @Resource
    private OfferService offerService;
    @Resource
    private ResumeService resumeService;
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
        int totalPages= DoPage.getTotalPages(offers1.size());
        List<Offer> offers=offerService.getOfferByUidAndLimits(u.getU_id(),currentPage,PAGESIZE);
        List<Recru> recrus=recruService.getAllRecrus();
        if (offers!=null) {
            session.setAttribute("offers",offers);
            session.setAttribute("recrus",recrus);
            return "customer/checkJobApplied";
        }else {
            return "recru/checkRecru";
        }
    }
}
