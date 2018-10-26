package com.junjie.controller;

import com.junjie.model.Resume;
import com.junjie.model.User;
import com.junjie.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 刘俊杰 on 2018/10/19.
 */
@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    /*@RequestMapping("/checkEnterClick")
    public void checkEnterClick(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int code=Integer.parseInt(request.getParameter("code"));
        if (code==13){
             response.getWriter().write(1);
        }else {
            response.getWriter().write(0);
        }
    }*/
    //新增个人简历
    @RequestMapping("/saveResume")
    public String saveResume(HttpSession session, HttpServletRequest request){
        User u= (User) session.getAttribute("u");
        Resume resume=new Resume(request.getParameter("rsm_name"),request.getParameter("rsm_gender"),
                Integer.parseInt(request.getParameter("rsm_age")),request.getParameter("rsm_nationality"),
                request.getParameter("rsm_hometown"),request.getParameter("rsm_college"),
                request.getParameter("rsm_major"),request.getParameter("rsm_edu_bg"),
                request.getParameter("rsm_post"),Integer.parseInt(request.getParameter("rsm_phone")),
                request.getParameter("rsm_email"),request.getParameter("rsm_addr"),
                request.getParameter("rsm_self_eval"),request.getParameter("rsm_major_intro"),
                request.getParameter("rsm_e_level"),request.getParameter("rsm_comp_level"),
                request.getParameter("rsm_social_prac"),u.getU_id());
        System.out.println(resume);
        if (resumeService.addResume(resume)){
            session.setAttribute("MyResume",resume);
            request.setAttribute("msg","简历添加成功");
            return "customer/checkMyResume";
        }else {
            request.setAttribute("msg","简历添加失败");
            return "customer/addResume";
        }
    }
    //查看个人简历
    @RequestMapping("/checkMyResume")
    public String checkMyResume(HttpSession session,HttpServletRequest request){
        User u= (User) session.getAttribute("u");
        Resume resume=new Resume();
        resume.setRsm_u_id(u.getU_id());
        Resume resume1=resumeService.getResumeByUid(resume);
        if (resume1==null){
            return "redirect:checkRecru?currentPage=1";
        }
        return "customer/checkMyResume";
    }
    //更新个人简历
    @RequestMapping("/updateResume")
    public String updateResume(HttpSession session, HttpServletRequest request){
        User u= (User) session.getAttribute("u");
        Resume resume=new Resume(request.getParameter("rsm_name"),request.getParameter("rsm_gender"),
                Integer.parseInt(request.getParameter("rsm_age")),request.getParameter("rsm_nationality"),
                request.getParameter("rsm_hometown"),request.getParameter("rsm_college"),
                request.getParameter("rsm_major"),request.getParameter("rsm_edu_bg"),
                request.getParameter("rsm_post"),Integer.parseInt(request.getParameter("rsm_phone")),
                request.getParameter("rsm_email"),request.getParameter("rsm_addr"),
                request.getParameter("rsm_self_eval"),request.getParameter("rsm_major_intro"),
                request.getParameter("rsm_e_level"),request.getParameter("rsm_comp_level"),
                request.getParameter("rsm_social_prac"),u.getU_id());
        System.out.println(resume);
        if (resumeService.updateResume(resume)){
            session.setAttribute("MyResume",resume);
            request.setAttribute("msg","简历修改成功");
            return "customer/checkMyResume";
        }else {
            request.setAttribute("msg","简历修改失败");
            return "customer/updateResume";
        }
    }
    //删除个人简历
    @RequestMapping("/deleteResume")
    public String deleteResume(HttpSession session, HttpServletRequest request){
        User u= (User) session.getAttribute("u");
        Resume resume=new Resume(request.getParameter("rsm_name"),request.getParameter("rsm_gender"),
                Integer.parseInt(request.getParameter("rsm_age")),request.getParameter("rsm_nationality"),
                request.getParameter("rsm_hometown"),request.getParameter("rsm_college"),
                request.getParameter("rsm_major"),request.getParameter("rsm_edu_bg"),
                request.getParameter("rsm_post"),Integer.parseInt(request.getParameter("rsm_phone")),
                request.getParameter("rsm_email"),request.getParameter("rsm_addr"),
                request.getParameter("rsm_self_eval"),request.getParameter("rsm_major_intro"),
                request.getParameter("rsm_e_level"),request.getParameter("rsm_comp_level"),
                request.getParameter("rsm_social_prac"),u.getU_id());
        System.out.println(resume);
        if (resumeService.deleteResume(resume)){
            session.setAttribute("MyResume",resume);
            request.setAttribute("msg","简历删除成功");
            return "menu/userMenu";
        }else {
            request.setAttribute("msg","简历删除失败");
            return "customer/checkMyResume";
        }
    }
}
