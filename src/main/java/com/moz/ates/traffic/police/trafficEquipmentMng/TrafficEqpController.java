package com.moz.ates.traffic.police.trafficEquipmentMng;

import com.moz.ates.traffic.police.common.CommonCdService;
import com.moz.ates.traffic.police.common.DataTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "eqp")
public class TrafficEqpController {

    @Autowired
    private CommonCdService commonCdService;

    @Autowired
    private TrafficEqpService trafficEqpService;


    @RequestMapping(value = "mngList")
    public String mngList(Model model, @ModelAttribute TfcEqpVO tfcEqpVO){

        model.addAttribute("tfcEqpVO",tfcEqpVO);
        return "EqpMngList";
    }

    @PostMapping(value = "mngListAjax")
    @ResponseBody
    public DataTableVO mngListAjax(@ModelAttribute TfcEqpVO tfcEqpVO){

        return trafficEqpService.getMngListDatatable(tfcEqpVO);
    }

    @RequestMapping(value = "mngRegist")
    public String mngRegist(Model model){

        return "EqpMngRegist";
    }

    @RequestMapping(value = "mngRegistAjax")
    @ResponseBody
    public Map<String,Object> mngRegistAjax(@ModelAttribute TfcEqpVO tfcEqpVO){
        Map<String, Object> result = new HashMap<>();

        int dupliCnt = trafficEqpService.getEqpDupliCnt(tfcEqpVO);
        if(dupliCnt > 0){
            result.put("code", "-1");
            result.put("msg", "중복된 장비번호 입니다.");
        }else{
            try {
                trafficEqpService.registEqp(tfcEqpVO);
                result.put("code", "1");
            }catch (Exception e){
                result.put("code", "0");
                result.put("msg", "error");
            }
        }


        return result;
    }
    @RequestMapping(value = "mngDetail")
    public String mngDetail(Model model, @RequestParam("tfcEnfEqpId")String tfcEnfEqpId){

        TfcEqpVO tfcEqpVO = trafficEqpService.getEqpDetail(tfcEnfEqpId);
        model.addAttribute("tfcEqpVO",tfcEqpVO);
        return "EqpMngDetail";
    }
    @RequestMapping(value = "mngModify")
    public String mngModify(Model model, @RequestParam("tfcEnfEqpId")String tfcEnfEqpId){

        TfcEqpVO tfcEqpVO = trafficEqpService.getEqpDetail(tfcEnfEqpId);
        model.addAttribute("tfcEqpVO",tfcEqpVO);
        return "EqpMngModify";
    }

    @PostMapping(value = "mngModifyAjax")
    @ResponseBody
    public Map<String, Object> mngModifyAjax(@ModelAttribute TfcEqpVO tfcEqpVO){
        Map<String, Object> result = new HashMap<>();

        try {
            trafficEqpService.updateEqp(tfcEqpVO);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }


        return result;
    }

    @RequestMapping(value = "logList")
    public String logList(Model model,@ModelAttribute EqpLogVO eqpLogVO){

        model.addAttribute("eqpLogVO", eqpLogVO);

        return "EqpLogList";
    }

    @RequestMapping(value = "logListAjax")
    @ResponseBody
    public DataTableVO logListAjax(@ModelAttribute EqpLogVO eqpLogVO){

        return trafficEqpService.getLogListDatatable(eqpLogVO);
    }


}
