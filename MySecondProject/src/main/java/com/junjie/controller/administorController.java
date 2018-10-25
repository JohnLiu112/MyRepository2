package com.junjie.controller;

import com.junjie.model.Dep;
import com.junjie.model.Job;
import com.junjie.service.DepService;
import com.junjie.service.EmpService;
import com.junjie.service.JobService;
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
    @Resource
    private DepService depService;
    @Resource
    private JobService jobService;
    @Resource
    private EmpService empService;

    @RequestMapping("/toHRmanage")
    public String toHRmanage(){
        return "humanResource/HRmanage";
    }
    /*@RequestMapping("/")
    public String toCheckEmp(HttpServletRequest request,HttpSession session){

    }*/
    /*@RequestMapping("/toCheckEmp")
    public String toCheckEmp(HttpServletRequest request,HttpSession session){

    }*/
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
    @RequestMapping("/findJobsByDepId")
    public @ResponseBody List toCheckEmp(HttpServletRequest request)throws Exception{
        Job job=new Job();
        job.setJob_dep_id(Integer.parseInt(request.getParameter("dep_id")));
        List<Job> jobs=jobService.getJobByDepId(job);
        System.out.println(jobs);
        return jobs;
    }

}
