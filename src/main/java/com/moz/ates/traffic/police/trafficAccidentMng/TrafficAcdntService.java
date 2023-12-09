package com.moz.ates.traffic.police.trafficAccidentMng;

import com.moz.ates.traffic.common.entity.accident.MozTfcAcdntChgHst;
import com.moz.ates.traffic.common.entity.accident.MozTfcAcdntMaster;
import com.moz.ates.traffic.police.common.DataTableVO;

import java.util.List;

public interface TrafficAcdntService {
    /**
     * @brief : 교통사고 정보 등록
     * @details : 교통사고 정보 등록
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntMaster
     * @return : 
     */
    void registAcdnt(MozTfcAcdntMaster tfcAcdntMaster);
    
    /**
     * @brief : 교통사고 중복 체크
     * @details : 교통사고 중복 체크
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntMaster
     * @return : 
     */
    int getAcdntDupliCnt(MozTfcAcdntMaster tfcAcdntMaster);
    
    /**
     * @brief : 교통사고 관리 리스트 조회
     * @details : 교통사고 관리 리스트 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntMaster
     * @return : 
     */
    DataTableVO getMngListDatatable(MozTfcAcdntMaster tfcAcdntMaster);

    List getMngList(MozTfcAcdntMaster tfcAcdntMaster);
    
    int getMngListCnt(MozTfcAcdntMaster tfcAcdntMaster);
    
    /**
     * @brief : 교통사고 정보 상세 조회
     * @details : 교통사고 정보 상세 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntId
     * @return : 
     */
    MozTfcAcdntMaster getMngDetail(String tfcAcdntId);
    
    /**
     * @brief : 교통사고 정보 수정
     * @details : 교통사고 정보 수정
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : tfcAcdntMaster
     * @return : 
     */
    void upateAcdnt(MozTfcAcdntMaster tfcAcdntMaster);
}
