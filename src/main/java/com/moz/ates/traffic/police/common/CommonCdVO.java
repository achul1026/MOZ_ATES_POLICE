package com.moz.ates.traffic.police.common;


import lombok.Data;

/**
 * className : CommonCdVO
 * author : Mike Lim
 * description : 공통 코드 VO
 */
@Data
public class CommonCdVO {

    private String cdId;
    private String cdGroupId;
    private String cdNm;
    private String cdDesc;
    private String userYn;
    private String crtr;
    private String crDt;

}
