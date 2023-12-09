package com.moz.ates.traffic.police.trafficEquipmentMng;

import com.moz.ates.traffic.police.common.DataTableVO;

import java.util.List;

public interface TrafficEqpService {
    int getEqpDupliCnt(TfcEqpVO tfcEqpVO);

    void registEqp(TfcEqpVO tfcEqpVO);

    DataTableVO getMngListDatatable(TfcEqpVO tfcEqpVO);

    List getMngList(TfcEqpVO tfcEqpVO);

    int getMngListCnt(TfcEqpVO tfcEqpVO);

    TfcEqpVO getEqpDetail(String tfcEnfEqpId);

    void updateEqp(TfcEqpVO tfcEqpVO);

    DataTableVO getLogListDatatable(EqpLogVO eqpLogVO);

    List getLogList(EqpLogVO eqpLogVO);

    int getLogListCnt(EqpLogVO eqpLogVO);
}
