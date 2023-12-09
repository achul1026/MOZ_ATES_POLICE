package com.moz.ates.traffic.police.trafficEquipmentMng;

import lombok.Data;

@Data
public class TfcEqpVO {

    private String tfcEnfEqpId;
    private String roadAddr;
    private String lat;
    private String lng;
    private String eqpTy;
    private String crDt;
    private String crOprtrId;
    private String useYn;
    private String mnfctr;
    private String sttsInfoGnrCy;
    private String freightVhLmtSpd;
    private String nrVhLmtSpd;
    private String lastSyncTime;
    private String roadLnQy;

    private int start = 0;
    private int length = 10;

    private String sDate;
    private String eDate;
    private String searchType;
    private String searchTxt;

}
