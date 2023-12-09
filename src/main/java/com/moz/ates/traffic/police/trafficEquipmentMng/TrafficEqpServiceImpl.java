package com.moz.ates.traffic.police.trafficEquipmentMng;

import com.moz.ates.traffic.police.common.DataTableVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficEqpServiceImpl implements TrafficEqpService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int getEqpDupliCnt(TfcEqpVO tfcEqpVO) {
        return sqlSession.selectOne("TrafficEqp.selectEqpDupliCnt", tfcEqpVO);
    }

    @Override
    public void registEqp(TfcEqpVO tfcEqpVO) {
        sqlSession.insert("TrafficEqp.insertEqp", tfcEqpVO);
    }

    @Override
    public List getMngList(TfcEqpVO tfcEqpVO) {
        return sqlSession.selectList("TrafficEqp.selectMngList", tfcEqpVO);
    }

    @Override
    public int getMngListCnt(TfcEqpVO tfcEqpVO) {
        return sqlSession.selectOne("TrafficEqp.selectMngListCnt", tfcEqpVO);
    }

    @Override
    public DataTableVO getMngListDatatable(TfcEqpVO tfcEqpVO) {
        return new DataTableVO(this.getMngList(tfcEqpVO),this.getMngListCnt(tfcEqpVO));
    }

    @Override
    public TfcEqpVO getEqpDetail(String tfcEnfEqpId) {
        return sqlSession.selectOne("TrafficEqp.selectEqpDetail", tfcEnfEqpId);
    }

    @Override
    public void updateEqp(TfcEqpVO tfcEqpVO) {
        sqlSession.update("TrafficEqp.updateEqp", tfcEqpVO);
    }

    @Override
    public List getLogList(EqpLogVO eqpLogVO) {
        return sqlSession.selectList("TrafficEqp.selectLogList", eqpLogVO);
    }

    @Override
    public int getLogListCnt(EqpLogVO eqpLogVO) {
        return sqlSession.selectOne("TrafficEqp.selectLogListCnt", eqpLogVO);
    }

    @Override
    public DataTableVO getLogListDatatable(EqpLogVO eqpLogVO) {
        return new DataTableVO(this.getLogList(eqpLogVO),this.getLogListCnt(eqpLogVO));
    }
}
