package com.moz.ates.traffic.police.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {


    @RequestMapping("login")
    public String login(Model model){

        return "Login";
    }

    /**
     * methodName : dashboard
     * author : Mike Lim
     * description : 대시보드 화면
     * @param model
     * @return string
     */
    @RequestMapping(value = "dashboard")
    public String dashboard(Model model){

        return "DashboardMain";
    }






}
