package com.moz.ates.traffic.police.govPortal;


import lombok.Data;


/**
 * className : ObjectionVO
 * author : Mike Lim
 * description : 이의제가 VO
 */
@Data
public class ObjectionVO {

    private String objIdx;
    private String tfcEnfId;
    private String cateCd;
    private String wrtrEmail;
    private String postTtl;
    private String postCn;
    private String crDt;
    private String oprtrId;
    private String ansEmail;
    private String ansStts;
    private String ansContents;
    private String andCrDt;
    private String andUpdDt;
    private String cdNm;

    private int start = 0;
    private int length = 10;

    private String sDate;
    private String eDate;
    private String searchType;
    private String searchTxt;

}
