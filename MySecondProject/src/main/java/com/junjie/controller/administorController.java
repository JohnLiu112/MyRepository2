package com.junjie.controller;

import com.junjie.model.*;
import com.junjie.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String toCheckJob(HttpServletRequest request, HttpSession session) throws Exception{
        List<Dep> deps = depService.getAllDep();
        if (deps == null) {
            return "redirect:toHRmanage";
        }
        session.setAttribute("deps", deps);
        System.out.println(deps);
        return "humanResource/checkJob";
    }

    //ajax部门和职位的二级联动
    @RequestMapping("/findJobsByDepId")
    public @ResponseBody
    List toCheckEmp(HttpServletRequest request) throws Exception {
        List<Job> jobs =
                jobService.getJobByDepId
                        (Integer.parseInt(request.getParameter("dep_id")));
        System.out.println(jobs);
        return jobs;
    }

    //发送offer邮件
    @RequestMapping("/deliverOe")
    public String toSendOffer(HttpServletRequest request, HttpSession session)throws Exception{
        int rsm_id = Integer.parseInt(request.getParameter("rsm_id"));
        int offer_id = Integer.parseInt(request.getParameter("offer_id"));
        Offer offer = offerService.getOfferById(offer_id);
        offer.setOffer_emp_state(2);
        Resume resume = resumeService.getResumeById(rsm_id);
        List<Dep> deps=depService.getAllDep();
        if (resume != null && offerService.updateOffer(offer)) {
            session.setAttribute("resume", resume);
            session.setAttribute("deps", deps);
            return "humanResource/sendOfferAndAddEmp";
        } else {
            return "";
        }

    }

    //再发送offer的同时创建游客对应的新用户
    @RequestMapping("/createNewEmp")
    public String createNewEmp(HttpServletRequest request, HttpSession session) throws Exception{
        Resume resume = resumeService.getResumeById(Integer.parseInt(request.getParameter("rsm_id")));
        OfferEmail offerEmail = new OfferEmail(request.getParameter("oe_info"),
                request.getParameter("oe_emp_name"),
                request.getParameter("oe_emp_pass"),
                resume.getRsm_u_id());
        String rsm_phone=""+resume.getRsm_phone();
        Emp emp = new Emp(
                resume.getRsm_name(),
                resume.getRsm_email(),
                rsm_phone,
                resume.getRsm_gender(),
                resume.getRsm_age(),
                resume.getRsm_hometown(),
                Integer.parseInt(request.getParameter("emp_salary")),
                Integer.parseInt(request.getParameter("job_id")),
                Integer.parseInt(request.getParameter("dep_id")),
                0,
                "",
                resume.getRsm_phone(),
                resume.getRsm_email());
        if (offerEmail != null && emp != null) {
            offerEmailService.addOfferEmail(offerEmail);
            empService.addEmp(emp);
            return "redirect:/jump/adminMenu";
        } else {
            return "redirect:deliverOe?rsm_id=" + resume.getRsm_id();
        }
    }

    //添加部门
    @RequestMapping("/addDep")
    public String addDep(HttpServletRequest request) throws Exception{
        String dep_name = request.getParameter("dep_name");
        Dep dep1 = depService.getDepByName(dep_name);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String createDate = format.format(date);
        if (dep1 == null) {
            Dep dep = new Dep(
                    request.getParameter("dep_name"),
                    createDate,
                    Integer.parseInt(request.getParameter("dep_emp_num"))

            );
            if (depService.addDep(dep)) {
                return "redirect:/jump/toAddNewDep";
            }
        }
        request.setAttribute("msg", "添加失败");
        return "redirect:jump/toAddNewDep";
    }


    //ajax根据部门名字查出部门其他信息，返回一个部门对象
    @RequestMapping("/toCheckDep")
    public @ResponseBody
    Dep toCheckDep(HttpServletRequest request) throws Exception {
        Dep dep = depService.getDepById(Integer.parseInt(request.getParameter("dep_id")));
        System.out.println(dep);
        return dep;
    }

    //更新部门信息
    @RequestMapping("/updateDep")
    public String updateDep(HttpServletRequest request)throws Exception {
        String dep_name1 = request.getParameter("dep_name1");
        String dep_name2 = request.getParameter("dep_name2");
        int dep_emp_num=Integer.parseInt(request.getParameter("dep_emp_num2"));
        Dep dep1 = depService.getDepByName(dep_name1);
        if (depService.getDepByName(dep_name2)==null) {
            dep1.setDep_name(dep_name2);
            dep1.setDep_emp_num(dep_emp_num);
            if (depService.updateDep(dep1)) {
                return "redirect:/jump/toAddNewDep";
            }
        }
        return "redirect:/jump/toHRmanage";
    }

    //删除部门
    @RequestMapping("/deleteDep")
    public String deleteDep(HttpServletRequest request)throws Exception {
        String dep_name = request.getParameter("dep_name1");
        Dep dep1 = depService.getDepByName(dep_name);
        if (dep1.getDep_emp_num()==0){
            if (depService.deleteDep(dep1)){
                return "redirect:/jump/toAddNewDep";
            }
        }
        return "redirect:/jump/toHRmanage";
    }
    //ajax 根据dep_id查询dep-职位查询
    @RequestMapping("/findDepByDepId")
    public @ResponseBody Dep findDepByDepId(HttpServletRequest request){
        int dep_id=Integer.parseInt(request.getParameter("dep_id"));
        Dep dep=depService.getDepById(dep_id);
        System.out.println(dep);
        return dep;
    }

    @RequestMapping("/findJobByJobId")
    public @ResponseBody Job findJobByJobId(HttpServletRequest request){
        int job_id=Integer.parseInt(request.getParameter("job_id"));
        Job job=jobService.getJobById(job_id);
        System.out.println(job);
        return job;
    }
    //更新职位
    @RequestMapping("/updateJob")
    public String updateJob(HttpServletRequest request)throws Exception{
        String dep_name=request.getParameter("dep_name2");
        String job_name=request.getParameter("job_name2");
        String job_name1=request.getParameter("job_name3");
        System.out.println(dep_name);
        System.out.println(job_name);
        int job_emp_num=Integer.parseInt(request.getParameter("job_emp_num"));
        Dep dep=depService.getDepByName(dep_name);
        System.out.println(dep);
        Job job1=jobService.getJobByDepIdAndName(dep.getDep_id(),job_name);
        Job job2=jobService.getJobByDepIdAndName(dep.getDep_id(),job_name1);
        if (job2!=null){
            request.setAttribute("msg","职位名重复");
            return "redirect:/jump/toAddJobDep";
        }
        job1.setJob_name(job_name1);
        job1.setJob_emp_num(job_emp_num);
        if (jobService.updateJob(job1)){
            return "redirect:/jump/toAddJobDep";
        }
        request.setAttribute("msg","更新失败");
        return "redirect:/jump/toAddJobDep";
    }
    //删除职位
    @RequestMapping("/deleteJob")
    public String deleteJob(HttpServletRequest request)throws Exception{
        String dep_name=request.getParameter("dep_name2");
        String job_name=request.getParameter("job_name2");
        Dep dep=depService.getDepByName(dep_name);
        Job job=jobService.getJobByDepIdAndName(dep.getDep_id(),job_name);
        if (job.getJob_emp_num()==0){
            if (jobService.deleteJob(job)){
                return "redirect:/jump/toAddJobDep";
            }
        }
        request.setAttribute("msg","该职位还有员工，删除失败");
        return "redirect:/jump/toAddJobDep";

    }
    //添加职位
    @RequestMapping("/addJob")
    public String addJob(HttpServletRequest request) throws Exception{
        String job_name=request.getParameter("job_name1");
        String dep_name=request.getParameter("dep_name1");
        int job_emp_num=Integer.parseInt(request.getParameter("job_emp_num1"));
        Dep dep=depService.getDepByName(dep_name);

        Job job1=jobService.getJobByDepIdAndName(dep.getDep_id(),job_name);
        if (job1!=null){
            request.setAttribute("msg","职位名重复");
            return "redirect:/jump/toAddJobDep";
        }
        Job job=new Job(job_name,dep.getDep_id(),job_emp_num);
        if (jobService.addJob(job)){
            return "redirect:/jump/toAddJobDep";
        }
        return "redirect:/jump/toHRmanage";
    }
    //查看员工界面（三级联动）
    @RequestMapping("/tocheckEmp")
    public String tocheckEmp(HttpSession session){
        List<Dep> deps=depService.getAllDep();
        session.setAttribute("deps",deps);
        return "humanResource/checkEmp";
    }
    //查看员工
    @RequestMapping("/findEmpsByJobId")
    public @ResponseBody List findEmpsByJobId(HttpServletRequest request){
        int job_id=Integer.parseInt(request.getParameter("job_id"));
        List<Emp> emps=empService.getEmpByJobId(job_id);
        System.out.println(emps);
        return emps;
    }
    //查找员工
    @RequestMapping("/getEmpById")
    public String getEmpById(HttpSession session,HttpServletRequest request){
        int emp_id=Integer.parseInt(request.getParameter("emp_id"));
        Emp emp=empService.getEmpByEmpId(emp_id);
        List<Dep> deps=depService.getAllDep();
        session.setAttribute("deps",deps);
        System.out.println(emp_id);
        Dep dep=depService.getDepById(emp.getEmp_dep_id());
        Job job=jobService.getJobById(emp.getEmp_job_id());
        session.setAttribute("emp",emp);
        session.setAttribute("dep",dep);
        session.setAttribute("job",job);
        return "humanResource/checkEmp";
    }
    //换岗
    @RequestMapping("/changeJob")
    public String changeJob(HttpServletRequest request,HttpSession session){
        String dep_name=request.getParameter("dep_name2");
        String job_name=request.getParameter("job_name2");
        int emp_id=Integer.parseInt(request.getParameter("emp_id"));
        Dep dep=depService.getDepByName(dep_name);
        Job job=jobService.getJobByDepIdAndName(dep.getDep_id(),job_name);
        Emp emp=empService.getEmpByEmpId(emp_id);
        emp.setEmp_job_id(job.getJob_id());
        emp.setEmp_dep_id(dep.getDep_id());
        emp.setEmp_off_reason("");
        if (empService.updateEmp(emp)){
            return "redirect:/jump/toChangeJob?emp_id="+emp_id;
        }
        return "redirect:/jump/toHRmanage";
    }
}
