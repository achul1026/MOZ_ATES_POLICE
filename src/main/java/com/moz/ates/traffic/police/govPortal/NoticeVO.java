package com.moz.ates.traffic.police.govPortal;


import lombok.Data;

/**
 * className : NoticeVO
 * author : Mike Lim
 * description : 공지사항 VO
 */
@Data
public class NoticeVO {

    private String boardIdx;
    private String boardCdId;
    private String oprtrId;
    private String wrtrNm;
    private String boardTitle;
    private String boardContents;
    private String viewCnt;
    private String crDt;
    private String updDt;
    private String cdNm;

    private int start = 0;
    private int length = 10;

    private String sDate;
    private String eDate;
    private String searchType;
    private String searchTxt;

}
