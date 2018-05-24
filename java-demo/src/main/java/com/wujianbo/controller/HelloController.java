package com.wujianbo.controller;

import com.wujianbo.config.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wujianbo
 * @date 2018/5/15
 */
@RestController
public class HelloController {

    @Autowired
    private DataCache dataCache;

    @GetMapping("/hello")
    public String sayHello(String args){
        String result = "good job!";
        return result;
    }

    @RequestMapping("/put")
    public String put(Long id, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(new Date()) + " : value is " + dataCache.put(id, value) ;
    }

    @RequestMapping("/get")
    public String query(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " : value is " +dataCache.query(id) ;
    }

    @RequestMapping("/remove")
    public String remove(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataCache.remove(id) ;
        return sdf.format(new Date()) + " : success " ;
    }
}
