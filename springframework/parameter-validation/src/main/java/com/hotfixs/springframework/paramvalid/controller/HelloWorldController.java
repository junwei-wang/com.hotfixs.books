package com.hotfixs.springframework.paramvalid.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjunwei
 */
@RestController
@Validated
public class HelloWorldController {
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String hello(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("age") int age
            //            @RequestParam("birthday") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday
    ) {
        return "hello";
    }
}
