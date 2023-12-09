package com.moz.ates.traffic.police.trafficEnforcementMng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.enforcement.MozTfcEnfMaster;
import com.moz.ates.traffic.common.entity.payment.MozFinePymntInfo;
import com.moz.ates.traffic.common.repository.enforcement.MozTfcEnfHstRepository;
import com.moz.ates.traffic.common.repository.enforcement.MozTfcEnfMasterRepository;
import com.moz.ates.traffic.common.repository.law.MozTfcLwInfoRepository;
import com.moz.ates.traffic.common.repository.payment.MozFinePymntInfoRepository;
import com.moz.ates.traffic.police.common.DataTableVO;

@Service
public class TrafficEnfServiceImpl implements TrafficEnfService{
	
    @Autowired
    MozTfcEnfMasterRepository tfcEnfMasterRepository;
    
    @Autowired
    MozFinePymntInfoRepository finePymntInfoRepository;
    
    @Autowired
    MozTfcEnfHstRepository tfcEnfHstRepository;
    
    @Autowired
    MozTfcLwInfoRepository tfcLwInfoRepository;

    @Override
    public DriverVO getDriverDetail(EnfSearchVO enfSearchVO) {
        //test
        DriverVO driverVO = new DriverVO();
//        driverVO.setName("홍길동");
//        driverVO.setPhoneNum("010-1111-2456");

        if("hs".equals(enfSearchVO.getName()) && "010".equals(enfSearchVO.getPhone())){
            driverVO.setName(enfSearchVO.getName());
            driverVO.setPhone(enfSearchVO.getPhone());
            driverVO.setDriverLicense("111-23-4555");
            driverVO.setNid("123123123123");
            driverVO.setNationality("모잠비크");
            driverVO.setLicenseRenewal("2회");
            driverVO.setAddress("moz africa city");
            driverVO.setBirth("920926");
            driverVO.setSex("m");
            driverVO.setEmail("mike.lim@bluedus.com");
            driverVO.setDrivetLicenseDate("2017-07-27");
            driverVO.setLicenseCheck("유효");
//            driverVO.set_LicenseCheck(true);
        }
//        return sqlSession.selectOne("TrafficEnf.selectSearchDriverDetail",tfcEnfId);

        return driverVO;
        // test end

//        return sqlSession.selectOne("TrafficEnf.selectDriverDetail",enfSearchVO);
    }

    @Override
    public CarVO getCarDetail(EnfSearchVO enfSearchVO) {

        //text
        CarVO carVO = new CarVO();
        
        String carNum = "9199";
        enfSearchVO.setCarNum("9199");
        
        if(carNum.equals(enfSearchVO.getCarNum())){
            carVO.setCarNum(enfSearchVO.getCarNum());
            carVO.setCarDriverName("lim hs");
            carVO.setRegDt("2020-11-22");
            carVO.setCarType("Avante(2022 XD)");
            carVO.setCarClassification("소형");
            carVO.setCompetentAuthority("Maputo");
            carVO.setWtCarIsScrapped("해당 사항 없음");
            carVO.setNote("비고");
            carVO.setAutomotiveUse("자가용");
        }

        return carVO;
        // test end


//        return sqlSession.selectOne("TrafficEnf.selectCarDetail",enfSearchVO);
    }

    /**
     * @brief : 교통단속 정보 리스트 조회
     * @details : 교통단속 정보 리스트 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcEnfMaster
     * @return : 
     */
    @Override
    public DataTableVO getInfoListDatatable(MozTfcEnfMaster tfcEnfMaster) {
        return new DataTableVO(this.getInfoList(tfcEnfMaster),this.getInfoListCnt(tfcEnfMaster));
    }
    
    @Override
    public List getInfoList(MozTfcEnfMaster tfcEnfMaster) {
    	return tfcEnfMasterRepository.selectInfoList(tfcEnfMaster);
    }

    @Override
    public int getInfoListCnt(MozTfcEnfMaster tfcEnfMaster) {
    	return tfcEnfMasterRepository.selectInfoListCnt(tfcEnfMaster);
    }

    /**
     * @brief : 교통단속 정보 상세 조회
     * @details : 교통단속 정보 상세 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcEnfId
     * @return : 
     */
    @Override
    public MozTfcEnfMaster getTrafficEnfDetail(String tfcEnfId) {
    	return tfcEnfMasterRepository.selectTrafficEnfDetail(tfcEnfId);
    }

    /**
     * @brief : 교통단속 정보 수정
     * @details : 교통단속 정보 수정
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcEnfMaster
     * @return : 
     */
    @Override
    public void updateInfo(MozTfcEnfMaster tfcEnfMaster) {
    	tfcEnfMasterRepository.updateInfo(tfcEnfMaster);
    }

    /**
     * @brief : 벌금 정보 수정
     * @details : 벌금 정보 수정
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : finePymntInfo
     * @return : 
     */
	@Override
	public void updateInfoPrice(MozFinePymntInfo finePymntInfo) {
		finePymntInfoRepository.updateFineTotalPrice(finePymntInfo);
	}
}
