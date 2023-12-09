package com.moz.ates.traffic.police.statistic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "stat")
public class StatController {

    @RequestMapping(value = "enforceChart")
    public String mngList(Model model){

        return "EnforceChart";
    }

    @RequestMapping(value = "penaltyChart")
    public String mngRegist(Model model){

        return "PenaltyChart";
    }
    @RequestMapping(value = "accidentChart")
    public String mngDetail(Model model){

        return "AccidentChart";
    }


}
