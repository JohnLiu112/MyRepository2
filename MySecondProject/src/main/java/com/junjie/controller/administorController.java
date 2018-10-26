package com.junjie.controller;

import com.junjie.model.*;
import com.junjie.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
@Controller
@RequestMapping("/admin")
public class administorController {
    private static final int PAGESIZE = 3;
    @Resource
    private DepService depService;
    @Resource
    private JobService jobService;
    @Resource
    private EmpService empService;
    @Resource
    private RecruService recruService;
    @Resource
    private OfferService offerService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private ItvInfoService itvInfoService;
    @Resource
    private OfferEmailService offerEmailService;


    /*@RequestMapping("/")
    public String toCheckEmp(HttpServletRequest request,HttpSession session){

    }*/
    /*@RequestMapping("/toCheckEmp")
    public String toCheckEmp(HttpServletRequest request,HttpSession session){

    }*/
    //查看部门-职位二级联动
    @RequestMapping("/toCheckJob")
    public String toCheckJob(HttpServletRequest request,HttpSession session){
        List<Dep> deps=depService.getAllDep();
        if (deps==null){
            return "redirect:toHRmanage";
        }
        session.setAttribute("deps",deps);
        System.out.println(deps);
        return "humanResource/checkJob";
    }
    //ajax部门和职位的二级联动
    @RequestMapping("/findJobsByDepId")
    public @ResponseBody List toCheckEmp(HttpServletRequest request)throws Exception{
        List<Job> jobs=
                jobService.getJobByDepId
                        (Integer.parseInt(request.getParameter("dep_id")));
        return jobs;
    }
    //发送offer邮件
    @RequestMapping("/deliverOe")
    public String toSendOffer(HttpServletRequest request,HttpSession session){
        int rsm_id=Integer.parseInt(request.getParameter("rsm_id"));
        int offer_id=Integer.parseInt(request.getParameter("offer_id"));
        Offer offer=offerService.getOfferById(offer_id);
        offer.setOffer_emp_state(2);
        Resume resume=resumeService.getResumeById(rsm_id);
        if (resume!=null&&offerService.updateOffer(offer)){
            session.setAttribute("resume",resume);
            return "humanResource/sendOfferAndAddEmp";
        }else {
            return "";
        }

    }
    //再发送offer的同时创建游客对应的新用户
    @RequestMapping("/createNewEmp")
    public String createNewEmp(HttpServletRequest request,HttpSession session){
        Resume resume=resumeService.getResumeById(Integer.parseInt(request.getParameter("rsm_id")));

        OfferEmail offerEmail=new OfferEmail(request.getParameter("oe_info"),
                request.getParameter("oe_emp_name"),
                request.getParameter("oe_emp_pass"),
                resume.getRsm_u_id());
        Emp emp=new Emp(
                resume.getRsm_name(),
                resume.getRsm_email(),
                resume.getRsm_phone(),
                resume.getRsm_gender(),
                resume.getRsm_age(),
                resume.getRsm_hometown(),
                Integer.parseInt(request.getParameter("emp_salary")),
                Integer.parseInt(request.getParameter("job_id")),
                Integer.parseInt(request.getParameter("dep_id")),
                0,
                null,
                resume.getRsm_phone(),
                resume.getRsm_email());
        if(offerEmail!=null&&emp!=null){
            return "redirect:jump/adminMenu";
        }else {
            return "redirect:deliverOe?rsm_id="+resume.getRsm_id();
        }
    }

    //添加部门
    @RequestMapping("/addDep")
    public String addDep(HttpServletRequest request){
        String dep_name=request.getParameter("dep_name");
        Dep dep1=depService.getDepByName(dep_name);
        if (dep1==null){
            Dep dep=new Dep(
                    request.getParameter("dep_name"),
                    request.getParameter("date"),
                    Integer.parseInt(request.getParameter("dep_emp_num"))

            );
             if (depService.addDep(dep)) {
                return "redirect:jump/toAddNewDep";
            }
        }
        request.setAttribute("msg","添加失败");
        return "redirect:jump/toAddNewDep";
    }
    @RequestMapping("/addJob")
    public String
}
