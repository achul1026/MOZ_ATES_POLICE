package com.moz.ates.traffic.police.trafficEnforcementMng;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moz.ates.traffic.common.entity.common.EnforcementDomain;
import com.moz.ates.traffic.common.entity.enforcement.MozTfcEnfMaster;
import com.moz.ates.traffic.common.entity.payment.MozFinePymntInfo;
import com.moz.ates.traffic.police.common.DataTableVO;
import com.moz.ates.traffic.police.gis.service.GisService;



@Controller
@RequestMapping(value = "enf")
public class TrafficEnfController {
	
	@Value("${file.upload.path}")
	private String applPath;

    @Autowired
    private TrafficEnfService trafficEnfService;
    
    @Autowired
    private GisService gService;

    @GetMapping(value = "searchDriver")
    public String searchDriver(Model model, @ModelAttribute EnfSearchVO enfSearchVO){
        DriverVO driverDetail = new DriverVO();
        
        if(enfSearchVO.getName() != null){
        	//작업필요
            driverDetail = trafficEnfService.getDriverDetail(enfSearchVO);
        }

        model.addAttribute("driverDetail", driverDetail);
        model.addAttribute("enfSearchVO", enfSearchVO);
        return "SearchDriver";
    }


    @GetMapping(value = "searchCar")
    public String searchCar(Model model, @ModelAttribute EnfSearchVO enfSearchVO){
        DriverVO driverDetail = new DriverVO();

        //작업필요
        if(enfSearchVO.getName() != null){ driverDetail = trafficEnfService.getDriverDetail(enfSearchVO);}

        model.addAttribute("driverDetail", driverDetail);
        model.addAttribute("enfSearchVO", enfSearchVO);
        return "SearchCar";
    }


    @PostMapping(value = "searchCarAjax")
    public String searchCarAjax(Model model, @ModelAttribute EnfSearchVO enfSearchVO){
        CarVO carDetail = new CarVO();
        
        //작업필요
        if(enfSearchVO.getCarNum() != null) { carDetail = trafficEnfService.getCarDetail(enfSearchVO); }

        model.addAttribute("carDetail", carDetail);
        model.addAttribute("enfSearchVO", enfSearchVO);
        return "SearchCarAjax";
    }

    /**
     * @brief : 교통단속 정보 리스트 화면
     * @details : 교통단속 정보 리스트 화면
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcEnfMaster
     * @return : 
     */
    @GetMapping(value = "infoList")
    public String infoList(Model model, @ModelAttribute MozTfcEnfMaster tfcEnfMaster ){
        model.addAttribute("tfcEnfMaster", tfcEnfMaster);
        return "InfoList";
    }
    
    /**
     * @brief : 교통단속 정보 리스트 조회
     * @details : 교통단속 정보 리스트 조회
     * @author : KY.LEE
     * @date : 2023.08.08
     * @param : tfcEnfMaster
     * @return : 
     */
    @PostMapping(value = "infoListAjax")
    @ResponseBody
    public DataTableVO infoListAjax(@ModelAttribute MozTfcEnfMaster tfcEnfMaster){

        return trafficEnfService.getInfoListDatatable(tfcEnfMaster);
    }

    /**
     * @brief : 교통단속 정보 상세 조회
     * @details : 교통단속 정보 상세 조회
     * @author : KY.LEE
     * @date : 2023.08.08
     * @param : tfcEnfId
     * @return : 
     */
    @RequestMapping(value = "infoDetail")
    public String infoDetail(Model model, @RequestParam("tfcEnfId")String tfcEnfId ){

    	MozTfcEnfMaster tfcEnfMaster = trafficEnfService.getTrafficEnfDetail(tfcEnfId);
        EnforcementDomain eDomain = gService.getMapInfo(tfcEnfId);
        model.addAttribute("eDomain",eDomain);
        model.addAttribute("tfcEnfMaster", tfcEnfMaster);
        return "InfoDetail";
    }



    /**
     * @brief : 교통단속 정보 수정 화면
     * @details : 교통단속 정보 수정 화면
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcEnfId
     * @return : 
     */
    @GetMapping(value = "infoModify")
    public String infoModify(Model model, @RequestParam("tfcEnfId")String tfcEnfId){

    	MozTfcEnfMaster tfcEnfMaster = trafficEnfService.getTrafficEnfDetail(tfcEnfId);

        model.addAttribute("tfcEnfMaster", tfcEnfMaster);
        return "InfoModify";
    }
    
    /**
     * @brief : 교통단속 정보 수정
     * @details : 교통단속 정보 수정
     * @author : KY.LEE
     * @date : 2023.08.08
     * @param : tfcEnfMaster
     * @param : imageFile
     * @param : totalPrice
     * @return : 
     */
    @PostMapping(value = "infoModifyAjax")
    @ResponseBody
    public Map<String, Object> infoModifyAjax(@ModelAttribute MozTfcEnfMaster tfcEnfMaster, @RequestParam("uploadFile") MultipartFile[] imageFile, @RequestParam("totalPrice") String totalPrice) throws IOException{
        Map<String, Object> result = new HashMap<>();
        
        if(!imageFile[0].isEmpty()) {
            String uuid = UUID.randomUUID().toString();
            String DBfileName = "";
            String fileName = "";
            String projectPath = System.getProperty("user.dir")+applPath;
            File makeFolder = new File(projectPath);
            String default_Path = projectPath;
            String default_Name = "notimage.png";
            
            if(!makeFolder.exists()) {
            	makeFolder.mkdir();
            	System.out.println("폴더 생성 성공");
            }else {
            	System.out.println("해당 폴더가 존재 합니다");
            }
            for(int i=0;i<imageFile.length;i++) {
            	fileName = uuid+"_"+imageFile[i].getOriginalFilename();
            	if(i == imageFile.length-1) {
            		DBfileName += fileName;
            	} else {
            		DBfileName += fileName+",";
            	}
                String file_path = projectPath+fileName;        
                File file = new File(file_path);        
                if(!imageFile[i].isEmpty()) {
                    FileOutputStream fo = new FileOutputStream(file);
                    byte[] fileBytes = imageFile[i].getBytes();
                    fo.write(fileBytes);
                    fo.close();
                    tfcEnfMaster.setTfcEnfImagepath(file_path);
                    tfcEnfMaster.setTfcEnfInfoimage(DBfileName);
                } else {
                	tfcEnfMaster.setTfcEnfImagepath(default_Path);
                	tfcEnfMaster.setTfcEnfInfoimage(default_Name);
                }
            }
        } else {
        	System.out.println("사진파일 수정x");
        }
        
        try {
            trafficEnfService.updateInfo(tfcEnfMaster);
            //벌금 수정
        	String chgPrice = totalPrice != null && !"".equals(totalPrice)?totalPrice:"0";
    		MozFinePymntInfo finePymntInfo = new MozFinePymntInfo();
    		finePymntInfo.setTfcEnfId(tfcEnfMaster.getTfcEnfId());
    		finePymntInfo.setTotalPrice(chgPrice);
    		trafficEnfService.updateInfoPrice(finePymntInfo);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }
        return result;
    }

}
