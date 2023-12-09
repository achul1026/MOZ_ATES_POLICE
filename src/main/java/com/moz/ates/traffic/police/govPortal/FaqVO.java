package com.moz.ates.traffic.police.govPortal;


import lombok.Data;


/**
 * className : FaqVO
 * author : Mike Lim
 * description :
 */
@Data
public class FaqVO {
    private String faqIdx;
    private String faqSeq;
    private String cateTy;
    private String wrtrId;
    private String postTitle;
    private String postContent;
    private String ansCn;
    private String regDt;
    private String mdfDt;
    private String delDt;
    private String delYn;
    private String viewCnt;
    private String cdNm;


    private int start = 0;
    private int length = 10;

    private String sDate;
    private String eDate;
    private String searchType;
    private String searchTxt;







}
