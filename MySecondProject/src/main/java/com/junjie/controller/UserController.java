package com.junjie.controller;

import com.junjie.model.User;
import com.junjie.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 刘俊杰 on 2018/10/4.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //用户登录
    @RequestMapping("/loginServlet")
    public String login( HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
        User user=new User(request.getParameter("uname"),request.getParameter("upass"));
        User user1 = userService.login(user);
        String log=request.getParameter("autoLogin");
        if (null != user1) {
            session.setAttribute("u", user1);
            if ("on".equals(log)){
                Cookie cookie = new Cookie("username",user1.getU_name());
                cookie.setMaxAge(60*10);
                response.addCookie(cookie);
            }
            model.addAttribute("msg","登录成功");
            return "redirect:/recru/checkRecru?currentPage=1";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "menu/login";
        }
    }
    //自动登录检查cookie
    @RequestMapping("/check")
    public String checkAutoLogin(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception{
        User user= (User) session.getAttribute("u");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name);
            System.out.println(value);
            if (name.equals("username")&&value.equals(user.getU_name())){
                session.setAttribute("u",user);
                model.addAttribute("msg","登录成功");
                return "menu/userMenu";
            }
        }
        model.addAttribute("msg","登录失败");
        return "menu/login";
    }
    //跳转到注册界面
    @RequestMapping("/register")
    public String register(Model model, HttpServletRequest request)throws Exception{
        String pass2=request.getParameter("userpass2");
        User user=new User(request.getParameter("username"),request.getParameter("userpass1"));
        if (user.getU_pass().equals(pass2)){
            if (userService.queryUserByName(user.getU_name())!=null){
                model.addAttribute("msg","用户名已存在");
                return "menu/register";
            }else {
                if(userService.register(user)){
                    model.addAttribute("msg","注册成功");
                    return "menu/register";
                }else {
                    model.addAttribute("msg","注册失败");
                    return "menu/register";
                }
            }
        }else {
            model.addAttribute("msg","密码输入不一致");
            return "menu/register";
        }
    }
    //跳转到管理员登录界面
    @RequestMapping("/adminLogin")
    public String adminLogin()throws Exception{
        return "menu/AdminLogin";
    }

    //管理员登录
    @RequestMapping("/adminLogin1")
    public String adminLogin1(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String adminName=request.getParameter("adminname");
        String adminPass=request.getParameter("adminpass");
        String log =request.getParameter("autoLogin");
        if (adminName.equals("admin")&&adminPass.equals("123456")){
            request.setAttribute("adminName",adminName);
            if ("on".equals(log)){
                Cookie cookie = new Cookie("adminName",adminName);
                cookie.setMaxAge(60*10);
                response.addCookie(cookie);
            }
            session.setAttribute("adminName",adminName);
            model.addAttribute("msg","登陆成功");
            return "menu/AdminMenu";
        }else {
            model.addAttribute("msg","用户名或者密码不正确，请重新输入");
            return "menu/AdminLogin";
        }
    }
    //管理员自动登录检查
    @RequestMapping("/checkAdminLogin")
    public String checkAdminLogin(HttpSession session,  HttpServletRequest request)throws Exception{
        String adminName= (String) session.getAttribute("adminName");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String adminname = cookie.getName();
            String value = cookie.getValue();

            if (adminname.equals("adminName")&&value.equals(adminName)){
                request.getSession().setAttribute("adminName",value);
                return "menu/AdminMenu";
            }
        }
        return "menu/AdminLogin";
    }
}
