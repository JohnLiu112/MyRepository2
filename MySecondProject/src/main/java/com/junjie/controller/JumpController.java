package com.junjie.controller;

import com.junjie.model.*;
import com.junjie.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
@Controller
@RequestMapping("/jump")
public class JumpController {
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

    //跳转到人事管理界面
    @RequestMapping("/toHRmanage")
    public String toHRmanage()throws Exception{
        return "humanResource/HRmanage";
    }
    //跳转到管理员主界面
    @RequestMapping("/adminMenu")
    public String adminMenu()throws Exception{
        return "menu/AdminMenu";
    }
    //返回到超主页面
    @RequestMapping("/backToSuperMenu")
    public String backToSuperMenu()throws Exception{
        return "../SuperMenu";
    }
    //用户登录跳转
    @RequestMapping("/userLogin")
    public String userLogin()throws Exception{
        return "menu/login";
    }
    //用户注册跳转
    @RequestMapping("/userRegister")
    public String userRegister()throws Exception{
        return "menu/register";
    }
    //游客登录
    @RequestMapping("/userMenu1")
    public String userMenu1()throws Exception{
        return "menu/menu";
    }
    //去添加招聘信息页面
    @RequestMapping("/toAddRecru")
    public String toAddRecru()throws Exception {
        return "administor/addRecru";
    }

    //跳转到添加简历页面
    @RequestMapping("/toAddResume")
    public String toAddResume()throws Exception{
        return "customer/addResume";
    }

    //去更新简历页面
    @RequestMapping("/toUpdateResume")
    public String toUpdateResume(HttpSession session, HttpServletRequest request)throws Exception{
        User u= (User) session.getAttribute("u");
        Resume resume1=resumeService.getResumeByUid(u.getU_id());
        session.setAttribute("MyResume",resume1);
        return "customer/updateResume";
    }
    //管理员-设置面试内容和时间
    @RequestMapping("/toSetInfoAndTime")
    public String toSetInfoAndTime()throws Exception {
        return "administor/setItvInfoAndTime";
    }

    //跳转到新增部门页面
    @RequestMapping("/toAddNewDep")
    public String toAddNewDep(HttpSession session)throws Exception{
        List<Dep> deps=depService.getAllDep();
        session.setAttribute("deps",deps);
        return "humanResource/DepManage";
    }
    //跳转到新增部门页面
    @RequestMapping("/toAddJobDep")
    public String toAddJobDep(HttpSession session)throws Exception{
        List<Dep> deps=depService.getAllDep();
        session.setAttribute("deps",deps);
        return "humanResource/jobManage";
    }
    //跳转到换岗页面
    @RequestMapping("/toChangeJob")
    public String toChangeJob(HttpSession session,HttpServletRequest request){
        int emp_id=Integer.parseInt(request.getParameter("emp_id"));
        System.out.println(emp_id);
        Emp emp=empService.getEmpByEmpId(emp_id);
        Dep dep=depService.getDepById(emp.getEmp_dep_id());
        Job job=jobService.getJobById(emp.getEmp_job_id());
        System.out.println(emp);
        List<Dep> deps=depService.getAllDep();
        System.out.println(deps);
        session.setAttribute("deps",deps);
        session.setAttribute("emp_id",emp_id);
        session.setAttribute("emp",emp);
        session.setAttribute("dep",dep);
        session.setAttribute("job",job);
        return "humanResource/changeJob";
    }
}
