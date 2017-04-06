package com.chenyx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/6.
 */
@Controller
public class IndexController {

    @RequestMapping({"/","/index"})
    public String index(Model model){
        return "index";
    }
}
