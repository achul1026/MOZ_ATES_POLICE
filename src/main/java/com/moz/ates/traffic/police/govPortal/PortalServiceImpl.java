package com.moz.ates.traffic.police.govPortal;

import com.moz.ates.traffic.police.common.DataTableVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className : PortalServiceImpl
 * author : Mike Lim
 * description : 포털 관련 impl
 */
@Service
public class PortalServiceImpl implements PortalService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void registNotice(NoticeVO noticeVO) {

        sqlSession.insert("Portal.insertNotice", noticeVO);

    }

    @Override
    public List<NoticeVO> getNoticeList(NoticeVO noticeVO) {
        return sqlSession.selectList("Portal.selectNoticeList", noticeVO);
    }

    @Override
    public int getNoticeListCnt(NoticeVO noticeVO) {
        return sqlSession.selectOne("Portal.selectNoticeListCnt", noticeVO);
    }

    @Override
    public NoticeVO getNoticeDetail(String boardIdx) {
        return sqlSession.selectOne("Portal.selectNoticeDetail", boardIdx);
    }

    @Override
    public void updateNotice(NoticeVO noticeVO) {
        sqlSession.update("Portal.updateNotice", noticeVO);
    }

    @Override
    public DataTableVO getNoticeListDatatable(NoticeVO noticeVO) {
        return new DataTableVO(this.getNoticeList(noticeVO), this.getNoticeListCnt(noticeVO));
    }

    @Override
    public List getFaqList(FaqVO faqVO) {
        return sqlSession.selectList("Portal.selectFaqList", faqVO);
    }

    @Override
    public int getFaqListCnt(FaqVO faqVO) {
        return sqlSession.selectOne("Portal.selectFaqListCnt", faqVO);
    }

    @Override
    public DataTableVO getFaqListDatatable(FaqVO faqVO) {
        return new DataTableVO(this.getFaqList(faqVO), this.getFaqListCnt(faqVO));
    }

    @Override
    public void registFaq(FaqVO faqVO) {
        faqVO.setWrtrId("lim");
        sqlSession.insert("Portal.insertFaq", faqVO);
    }

    @Override
    public FaqVO getFaqDetail(String faqIdx) {
        return sqlSession.selectOne("Portal.findOneMozFaq", faqIdx);
    }

    @Override
    public void updateFaq(FaqVO faqVO) {
        sqlSession.update("Portal.updateFaq", faqVO);
    }

    @Override
    public List getObjectionList(ObjectionVO objectionVO) {
        return sqlSession.selectList("Portal.selectObjectionList",objectionVO);
    }

    @Override
    public int getObjectionListCnt(ObjectionVO objectionVO) {
        return sqlSession.selectOne("Portal.selectObjectionListCnt",objectionVO);
    }

    @Override
    public DataTableVO getObjectionListDatatable(ObjectionVO objectionVO) {
        return new DataTableVO(this.getObjectionList(objectionVO), this.getObjectionListCnt(objectionVO));
    }

    @Override
    public ObjectionVO getObjectionDetail(String objIdx) {
        return sqlSession.selectOne("Portal.selectObjectionDetail",objIdx);
    }

    @Override
    public List getComplaintList(ComplainVO complainVO) {
        return sqlSession.selectList("Portal.selectComplaintList",complainVO);
    }

    @Override
    public int getComplaintListCnt(ComplainVO complainVO) {
        return sqlSession.selectOne("Portal.selectComplaintListCnt",complainVO);
    }

    @Override
    public DataTableVO getComplaintListDatatable(ComplainVO complainVO) {
        return new DataTableVO(this.getComplaintList(complainVO), this.getComplaintListCnt(complainVO));
    }

    @Override
    public ComplainVO getComplaintDetail(String complaintsIdx) {
        return sqlSession.selectOne("Portal.selectComplaintDetail",complaintsIdx);
    }

    @Override
    public void registPenaltyPlace(PlaceVO placeVO) {
        placeVO.setCrtr("lim");
        sqlSession.insert("Portal.insertPenaltyPlace", placeVO);
    }

    @Override
    public List getPenaltyPlaceList(PlaceVO placeVO) {
        return sqlSession.selectList("Portal.selectPenaltyPlaceList",placeVO);
    }

    @Override
    public int getPenaltyPlaceListCnt(PlaceVO placeVO) {
        return sqlSession.selectOne("Portal.selectPenaltyPlaceListCnt",placeVO);
    }

    @Override
    public DataTableVO getPenaltyPlaceListDatatable(PlaceVO placeVO) {
        return new DataTableVO(this.getPenaltyPlaceList(placeVO), this.getPenaltyPlaceListCnt(placeVO));
    }

    @Override
    public PlaceVO getPenaltyPlaceDetail(String placePymntId) {
        return sqlSession.selectOne("Portal.selectPenaltyPlaceDetail",placePymntId);
    }

    @Override
    public void updatePenaltyPlace(PlaceVO placeVO) {
        sqlSession.update("Portal.updatePenaltyPlace",placeVO);
    }

    @Override
    public void deleteNotice(String boardIdx) {
        sqlSession.delete("Portal.deleteNotice",boardIdx);
    }

    @Override
    public void deleteFaq(String faqIdx) {
        sqlSession.delete("Portal.deleteFaq",faqIdx);
    }

    @Override
    public void deletePenaltyPlace(String placePymntId) {
        sqlSession.delete("Portal.deletePenaltyPlace",placePymntId);
    }
}
