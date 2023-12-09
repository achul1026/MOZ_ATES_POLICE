package com.moz.ates.traffic.police.govPortal;


import lombok.Data;


/**
 * className : PlaceVO
 * author : Mike Lim
 * description : 장소 VO
 */
@Data
public class PlaceVO {

    private String placePymntId;
    private String placePymntNm;
    private String placePymntAddr;
    private String placePymntRprsvNm;
    private String crDt;
    private String crtr;

    private int start = 0;
    private int length = 10;

    private String sDate;
    private String eDate;
    private String searchType;
    private String searchTxt;

}
