package com.moz.ates.traffic.police.trafficEquipmentMng;

import lombok.Data;

@Data
public class EqpLogVO {

    private String logId;
    private String tfcEnfEqpId;
    private String roadLn;
    private String cntrlReqTy;
    private String cntrlResult;
    private String crDt;
    private String crtr;

    private int start = 0;
    private int length = 10;

    private String sDate;
    private String eDate;
    private String searchType;
    private String searchTxt;

}
