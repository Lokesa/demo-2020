package com.example.demo.controller;

import com.example.demo.entity.Entity;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
    @GetMapping(value="/hello")
    public Object hello() {
        return "Hello Mango00000!";
    }
    //返回String类型代表页面跳转
    @RequestMapping("/ref")
    public String refHello(){
        List<Entity> list=helloService.getList();
        System.out.println(list);
        for(Entity entity:list){
            System.out.println(entity.getId()+","+entity.getPassword()+","+entity.getUsername());
        }
        System.out.println(list);
        System.out.println("HelloController...refHello...");
        return "hello";
    }
    @GetMapping("/getAll")
    public String getAll(Model model){
        System.out.println("getALL-----");
        List<Entity> list=helloService.getAll();
        //System.out.println(list);
        for(Entity entity:list){
            System.out.println(entity.getId()+","+entity.getPassword()+","+entity.getUsername());
        }
        model.addAttribute("emps", list);
       // System.out.println(list);
        //System.out.println("HelloController...refHello...");
        return "/getAll";
    }
    @PutMapping("/getOne")
    public List<Entity> getOne(Model model){
        List<Entity> list=helloService.getOne("1");
        System.out.println(list);
        for(Entity entity:list){
            System.out.println(entity.getId()+","+entity.getPassword()+","+entity.getUsername());
        }
        return list;
    }
    @RequestMapping("/login.do")
    public ModelAndView login(){
        List<Entity> result= helloService.getAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("newText","你好，Thymeleaf！");
        mv.addObject("gender","1");
        mv.addObject("userList",result);
        if(result!=null) {
            mv.addObject("emps",result);
        }
        mv.setViewName("getAll.html");
        return mv;
    }

}
