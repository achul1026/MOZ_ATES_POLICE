package com.moz.ates.traffic.police.trafficAccidentMng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moz.ates.traffic.common.entity.accident.MozTfcAcdntMaster;
import com.moz.ates.traffic.common.entity.common.AccidentDomain;
import com.moz.ates.traffic.common.entity.common.MozCmCd;
import com.moz.ates.traffic.police.common.CommonCdService;
import com.moz.ates.traffic.police.common.DataTableVO;
import com.moz.ates.traffic.police.gis.service.GisService;

@Controller
@RequestMapping(value = "acdnt")
public class TrafficAcdntController {

    @Autowired
    private CommonCdService commonCdService;

    @Autowired
    private TrafficAcdntService trafficAcdntService;
    
    @Autowired
    private GisService gService;

    /**
     * @brief : 교통사고 관리 리스트 화면
     * @details : 교통사고 관리 리스트 화면
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntMaster
     * @return : 
     */
    @RequestMapping(value = "mngList")
    public String mngList(Model model, @ModelAttribute MozTfcAcdntMaster tfcAcdntMaster){

        model.addAttribute("tfcAcdntMaster", tfcAcdntMaster);

        return "AcdntMngList";
    }

    /**
     * @brief : 교통사고 관리 리스트 조회
     * @details : 교통사고 관리 리스트 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntMaster
     * @return : 
     */
    @PostMapping(value = "mngListAjax")
    @ResponseBody
    public DataTableVO mngListAjax(@ModelAttribute MozTfcAcdntMaster tfcAcdntMaster){

        return trafficAcdntService.getMngListDatatable(tfcAcdntMaster);
    }

    /**
     * @brief : 교통사고 등록 화면
     * @details : 교통사고 등록 화면
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "mngRegist")
    public String mngRegist(Model model){

        List<MozCmCd> cdList = commonCdService.getCdList("TAP");
        model.addAttribute("cdList", cdList);

        return "AcdntMngRegist";
    }
    
    /**
     * @brief : 교통사고 등록
     * @details : 교통사고 등록
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntMaster
     * @return : 
     */
    @RequestMapping(value = "mngRegistAjax")
    @ResponseBody
    public Map<String,Object> mngRegistAjax(@ModelAttribute MozTfcAcdntMaster tfcAcdntMaster){
        Map<String, Object> result = new HashMap<>();

        int dupliCnt = trafficAcdntService.getAcdntDupliCnt(tfcAcdntMaster);
        if(dupliCnt > 0){
            result.put("code", "-1");
            result.put("msg", "중복된 사고번호 입니다.");
        }else{
            try {
                trafficAcdntService.registAcdnt(tfcAcdntMaster);
                result.put("code", "1");
            }catch (Exception e){
                result.put("code", "0");
                result.put("msg", "error");
            }
        }


        return result;
    }
    
    /**
     * @brief : 교통사고 상세 조회
     * @details : 교통사고 상세 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntId
     * @return : 
     */
    @RequestMapping(value = "mngDetail")
    public String mngDetail(Model model, @RequestParam("tfcAcdntId")String tfcAcdntId ){
    	MozTfcAcdntMaster tfcAcdntMaster = trafficAcdntService.getMngDetail(tfcAcdntId);
    	AccidentDomain aDomain = gService.getAcMapInfo(tfcAcdntId);
    	model.addAttribute("aDomain",aDomain);
    	model.addAttribute("tfcAcdntMaster",tfcAcdntMaster);
        return "AcdntMngDetail";
    }

    /**
     * @brief : 교통사고 수정 화면
     * @details : 교통사고 수정 화면
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntId
     * @return : 
     */
    @RequestMapping(value = "mngModify")
    public String mngModify(Model model, @RequestParam("tfcAcdntId")String tfcAcdntId){

        List<MozCmCd> cdList = commonCdService.getCdList("TAP");
        model.addAttribute("cdList", cdList);

        MozTfcAcdntMaster tfcAcdntMaster = trafficAcdntService.getMngDetail(tfcAcdntId);
        model.addAttribute("tfcAcdntMaster", tfcAcdntMaster);
        return "AcdntMngModify";
    }
    
    /**
     * @brief : 교통사고 정보 수정
     * @details : 교통사고 정보 수정
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntMaster
     * @return : 
     */
    @RequestMapping(value = "mngModifyAjax")
    @ResponseBody
    public Map<String,Object> mngModifyAjax(@ModelAttribute MozTfcAcdntMaster tfcAcdntMaster){
        Map<String, Object> result = new HashMap<>();

            try {
                trafficAcdntService.upateAcdnt(tfcAcdntMaster);
                result.put("code", "1");
            }catch (Exception e){
                result.put("code", "0");
                result.put("msg", "error");
            }
        return result;
    }
}
