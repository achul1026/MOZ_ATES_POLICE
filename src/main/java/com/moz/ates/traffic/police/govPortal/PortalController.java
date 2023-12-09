package com.moz.ates.traffic.police.govPortal;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moz.ates.traffic.common.entity.common.MozCmCd;
import com.moz.ates.traffic.police.common.CommonCdService;
import com.moz.ates.traffic.police.common.DataTableVO;
import com.moz.ates.traffic.police.common.Email;

@Controller
@RequestMapping(value = "portal")
public class PortalController {

    @Autowired
    private CommonCdService commonCdService;

    @Autowired
    private PortalService portalService;

    @Autowired
    private Email email;



    @RequestMapping(value = "noticeList")
    public String noticeList(Model model, @ModelAttribute NoticeVO noticeVO){

        model.addAttribute("noticeVO", noticeVO);
        return "NoticeList";
    }

    @PostMapping(value = "noticeListAjax")
    @ResponseBody
    public DataTableVO noticeListAjax(@ModelAttribute NoticeVO noticeVO){


        return portalService.getNoticeListDatatable(noticeVO);
    }




    @RequestMapping(value = "noticeRegist")
    public String noticeRegist(Model model){

        List<MozCmCd> cdList = commonCdService.getCdList("ntc");
        model.addAttribute("cdList", cdList);

        return "NoticeRegist";
    }


    @RequestMapping(value = "noticeRegistAjax")
    @ResponseBody
    public Map<String,Object> noticeRegistAjax(NoticeVO noticeVO){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.registNotice(noticeVO);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    @RequestMapping(value = "noticeDeleteAjax")
    @ResponseBody
    public Map<String,Object> noticeDeleteAjax(@RequestParam("boardIdx")String boardIdx){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.deleteNotice(boardIdx);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    @RequestMapping(value = "noticeDetail")
    public String noticeDetail(Model model, @RequestParam("boardIdx")String boardIdx){

        NoticeVO noticeVO = portalService.getNoticeDetail(boardIdx);
        model.addAttribute("noticeVO", noticeVO);

        return "NoticeDetail";
    }

    @RequestMapping(value = "noticeModify")
    public String noticeModify(Model model, @RequestParam("boardIdx")String boardIdx){

        List<MozCmCd> cdList = commonCdService.getCdList("ntc");
        model.addAttribute("cdList", cdList);

        NoticeVO noticeVO = portalService.getNoticeDetail(boardIdx);
        model.addAttribute("noticeVO", noticeVO);

        return "NoticeModify";
    }



    @RequestMapping(value = "noticeModifyAjax")
    @ResponseBody
    public Map<String,Object> noticeModifyAjax(@ModelAttribute NoticeVO noticeVO){
        Map<String, Object> result = new HashMap<>();
        try {
            portalService.updateNotice(noticeVO);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }



    @RequestMapping(value = "faqList")
    public String faqList(Model model, @ModelAttribute FaqVO faqVO){

        model.addAttribute("faqVO", faqVO);
        return "FaqList";
    }

    @PostMapping(value = "faqListAjax")
    @ResponseBody
    public DataTableVO faqListAjax(@ModelAttribute FaqVO faqVO){

        return portalService.getFaqListDatatable(faqVO);
    }

    @RequestMapping(value = "faqRegist")
    public String faqRegist(Model model){

        List<MozCmCd> cdList = commonCdService.getCdList("faq");
        model.addAttribute("cdList", cdList);

        return "FaqRegist";
    }

    @RequestMapping(value = "faqRegistAjax")
    @ResponseBody
    public Map<String,Object> faqRegistAjax(FaqVO faqVO){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.registFaq(faqVO);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    @RequestMapping(value = "faqDetail")
    public String faqDetail(Model model, @RequestParam("faqIdx")String faqIdx){

        List<MozCmCd> cdList = commonCdService.getCdList("faq");
        model.addAttribute("cdList", cdList);

        FaqVO faqVO = portalService.getFaqDetail(faqIdx);
        model.addAttribute("faqVO", faqVO);

        return "FaqDetail";
    }

    @RequestMapping(value = "faqModify")
    public String faqModify(Model model, @RequestParam("faqIdx")String faqIdx){

        List<MozCmCd> cdList = commonCdService.getCdList("faq");
        model.addAttribute("cdList", cdList);

        FaqVO faqVO = portalService.getFaqDetail(faqIdx);
        model.addAttribute("faqVO", faqVO);

        return "FaqModify";
    }

    @RequestMapping(value = "faqModifyAjax")
    @ResponseBody
    public Map<String,Object> faqModifyAjax(@ModelAttribute FaqVO faqVO){
        Map<String, Object> result = new HashMap<>();
        try {
            portalService.updateFaq(faqVO);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    @RequestMapping(value = "faqDeleteAjax")
    @ResponseBody
    public Map<String,Object> faqDeleteAjax(@RequestParam("faqIdx")String faqIdx){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.deleteFaq(faqIdx);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }


    @RequestMapping(value = "objectionList")
    public String objectionList(Model model, @ModelAttribute ObjectionVO objectionVO){

        model.addAttribute("objectionVO", objectionVO);

        return "ObjectionList";
    }

    @PostMapping(value = "objectionListAjax")
    @ResponseBody
    public DataTableVO objectionListAjax(@ModelAttribute ObjectionVO objectionVO){

        return portalService.getObjectionListDatatable(objectionVO);
    }

    @RequestMapping(value = "objectionDetail")
    public String objectionDetail(Model model, @RequestParam("objIdx")String objIdx){

        ObjectionVO objectionVO = portalService.getObjectionDetail(objIdx);
        model.addAttribute("objectionVO", objectionVO);
        return "ObjectionDetail";
    }

    @RequestMapping(value = "sendObjAnswerAjax")
    @ResponseBody
    public Map<String, Object> sendObjAnswer(ObjectionVO objectionVO) throws MessagingException, IOException {

        HashMap<String, Object> emailValues = new HashMap<>();
        emailValues.put("answer","답변입니다.");

        email.send("답변 메일입니다.","do1it@naver.com","welcome",emailValues);
        return null;
    }


    @RequestMapping(value = "complaintList")
    public String complaintList(Model model, @ModelAttribute ComplainVO complainVO){

        model.addAttribute("complainVO", complainVO);
        return "ComplaintList";
    }

    @PostMapping(value = "complaintListAjax")
    @ResponseBody
    public DataTableVO complaintListAjax(@ModelAttribute ComplainVO complainVO){

        return portalService.getComplaintListDatatable(complainVO);
    }

    @RequestMapping(value = "complaintDetail")
    public String complaintDetail(Model model, @RequestParam("complaintsIdx")String complaintsIdx){

        ComplainVO complainVO = portalService.getComplaintDetail(complaintsIdx);
        model.addAttribute("complainVO", complainVO);
        return "ComplaintDetail";
    }


    @RequestMapping(value = "penaltyPlaceList")
    public String penaltyPlaceList(Model model,@ModelAttribute PlaceVO placeVO){

        model.addAttribute("placeVO", placeVO);
        return "PenaltyPlaceList";
    }


    @PostMapping(value = "penaltyPlaceListAjax")
    @ResponseBody
    public DataTableVO penaltyPlaceListAjax(@ModelAttribute PlaceVO placeVO){

        return portalService.getPenaltyPlaceListDatatable(placeVO);
    }

    @RequestMapping(value = "penaltyPlaceRegist")
    public String penaltyPlaceRegist(Model model){

        return "PenaltyPlaceRegist";
    }


    @RequestMapping(value = "penaltyPlaceRegistAjax")
    @ResponseBody
    public Map<String,Object> penaltyPlaceRegistAjax(PlaceVO placeVO){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.registPenaltyPlace(placeVO);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }


    @RequestMapping(value = "penaltyPlaceDetail")
    public String penaltyPlaceDetail(Model model,@RequestParam("placePymntId")String placePymntId){

        PlaceVO placeVO = portalService.getPenaltyPlaceDetail(placePymntId);
        model.addAttribute("placeVO", placeVO);

        return "PenaltyPlaceDetail";
    }

    @RequestMapping(value = "penaltyPlaceModify")
    public String penaltyPlaceModify(Model model,@RequestParam("placePymntId")String placePymntId){

        PlaceVO placeVO = portalService.getPenaltyPlaceDetail(placePymntId);
        model.addAttribute("placeVO", placeVO);

        return "PenaltyPlaceModify";
    }




    @RequestMapping(value = "penaltyPlaceModifyAjax")
    @ResponseBody
    public Map<String,Object> penaltyPlaceModifyAjax(@ModelAttribute PlaceVO placeVO){
        Map<String, Object> result = new HashMap<>();
        try {
            portalService.updatePenaltyPlace(placeVO);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }


    @RequestMapping(value = "penaltyPlaceDeleteAjax")
    @ResponseBody
    public Map<String,Object> penaltyPlaceDeleteAjax(@RequestParam("placePymntId")String placePymntId){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.deletePenaltyPlace(placePymntId);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }



}
