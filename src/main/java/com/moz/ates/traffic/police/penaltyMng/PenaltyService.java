package com.moz.ates.traffic.police.penaltyMng;

import java.util.List;
import java.util.Map;

import com.moz.ates.traffic.common.entity.payment.MozFinePymntInfo;
import com.moz.ates.traffic.police.common.DataTableVO;

public interface PenaltyService {
	
    /**
     * @brief : 범칙금 등록
     * @details : 범칙금 등록
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : finePymntInfo
     * @return : 
     */
	void registPenaltyMaster(MozFinePymntInfo finePymntInfo);
	
    /**
     * @brief : 범칙금 등록
     * @details : 범칙금 등록
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : finePymntInfo
     * @return : 
     */
    void registPenalty(MozFinePymntInfo finePymntInfo);
    
    /**
     * @brief : 범칙금 리스트 조회
     * @details : 범칙금 리스트 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : finePymntInfo
     * @return : DataTableVO
     */
    DataTableVO getPenaltyListDatatable(MozFinePymntInfo finePymntInfo);

    List getPenaltyList(MozFinePymntInfo finePymntInfo);

    int getPenaltyListCnt(MozFinePymntInfo finePymntInfo);
    
    /**
     * @brief : 범칙금 상세 조회
     * @details : 범칙금 상세 조회
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : pymntId
     * @return : 
     */
    MozFinePymntInfo getPenaltyDetail(String pymntId);
    
    /**
     * @brief : 범칙금 수정
     * @details : 범칙금 수정
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : finePymntInfo
     * @return : 
     */
	void updatePenaltyMaster(MozFinePymntInfo finePymntInfo);
	
    /**
     * @brief : 범칙금 수정
     * @details : 범칙금 수정
     * @author : KY.LEE
     * @date : 2023.08.09
     * @param : finePymntInfo
     * @return : 
     */
	void updatePenalty(MozFinePymntInfo finePymntInfo);

	void paymentClear(String pymntId);

	void paymentCencal(String pymntId);


	Map<String, Object> penaltySendEmail(String pymntId, String emailAddr, String content);

}
