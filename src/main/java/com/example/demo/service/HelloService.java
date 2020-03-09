package com.example.demo.service;

import com.example.demo.dao.HelloDao;
import com.example.demo.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.corba.EncapsInputStreamFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("helloService")
public class HelloService {
    private static HelloService helloService;
    @Autowired
    private  HelloDao helloDao;
    public List<Entity> getList(){
        Entity entity =new Entity();
        entity.setId("1");
        //entity.setUserName("2");
        //entity.setPassWord("3");
        List<Entity> list=new ArrayList<Entity>();
        list.add(entity);
        return helloDao.getList();
    }
    public List<Entity> getAll(){
        return helloDao.getAll();
    }
    public List<Entity> getOne(String id){
        return helloDao.getOne(id);
    }
    public static void main(String[] args) {
         System.out.println("");
    }
}
