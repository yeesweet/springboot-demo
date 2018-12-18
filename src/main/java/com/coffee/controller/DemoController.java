package com.coffee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang.hp
 * @date 2018/12/18.
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("/hello")
    String  hello(){
        return "hello world";
    }
}
