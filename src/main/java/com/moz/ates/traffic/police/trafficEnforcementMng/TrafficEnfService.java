package com.moz.ates.traffic.police.trafficEnforcementMng;

import com.moz.ates.traffic.common.entity.enforcement.MozTfcEnfMaster;
import com.moz.ates.traffic.common.entity.payment.MozFinePymntInfo;
import com.moz.ates.traffic.police.common.DataTableVO;

import java.util.List;

public interface TrafficEnfService {
    DriverVO getDriverDetail(EnfSearchVO enfSearchVO);

    CarVO getCarDetail(EnfSearchVO enfSearchVO);

    /**
     * @brief : 교통단속 정보 리스트 조회
     * @details : 교통단속 정보 리스트 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcEnfMaster
     * @return : 
     */
    DataTableVO getInfoListDatatable(MozTfcEnfMaster tfcEnfMaster);

    List getInfoList(MozTfcEnfMaster tfcEnfMaster);

    int getInfoListCnt(MozTfcEnfMaster tfcEnfMaster);

    /**
     * @brief : 교통단속 정보 상세 조회
     * @details : 교통단속 정보 상세 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcEnfId
     * @return : 
     */
    MozTfcEnfMaster getTrafficEnfDetail(String tfcEnfId);
    
    /**
     * @brief : 교통단속 정보 수정
     * @details : 교통단속 정보 수정
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcEnfMaster
     * @return : 
     */
    void updateInfo(MozTfcEnfMaster tfcEnfMaster);
    
    /**
     * @brief : 벌금 정보 수정
     * @details : 벌금 정보 수정
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : finePymntInfo
     * @return : 
     */
    void updateInfoPrice(MozFinePymntInfo finePymntInfo);
}
