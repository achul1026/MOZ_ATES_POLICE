package com.moz.ates.traffic.police.govPortal;

import com.moz.ates.traffic.police.common.DataTableVO;

import java.util.List;

/**
 * className : PortalService
 * author : Mike Lim
 * description : 포털 관련 서비스
 */
public interface PortalService {

    void registNotice(NoticeVO noticeVO);

    DataTableVO getNoticeListDatatable(NoticeVO noticeVO);

    List<NoticeVO> getNoticeList(NoticeVO noticeVO);

    int getNoticeListCnt(NoticeVO noticeVO);

    NoticeVO getNoticeDetail(String boardIdx);

    void updateNotice(NoticeVO noticeVO);

    DataTableVO getFaqListDatatable(FaqVO faqVO);

    List getFaqList(FaqVO faqVO);

    int getFaqListCnt(FaqVO faqVO);

    void registFaq(FaqVO faqVO);

    FaqVO getFaqDetail(String faqIdx);

    void updateFaq(FaqVO faqVO);

    DataTableVO getObjectionListDatatable(ObjectionVO objectionVO);

    List getObjectionList(ObjectionVO objectionVO);

    int getObjectionListCnt(ObjectionVO objectionVO);

    ObjectionVO getObjectionDetail(String objIdx);

    DataTableVO getComplaintListDatatable(ComplainVO complainVO);

    List getComplaintList(ComplainVO complainVO);

    int getComplaintListCnt(ComplainVO complainVO);

    ComplainVO getComplaintDetail(String complaintsIdx);

    void registPenaltyPlace(PlaceVO placeVO);

    DataTableVO getPenaltyPlaceListDatatable(PlaceVO placeVO);

    List getPenaltyPlaceList(PlaceVO placeVO);

    int getPenaltyPlaceListCnt(PlaceVO placeVO);

    PlaceVO getPenaltyPlaceDetail(String placePymntId);

    void updatePenaltyPlace(PlaceVO placeVO);

    void deleteNotice(String boardIdx);

    void deleteFaq(String faqIdx);

    void deletePenaltyPlace(String placePymntId);
}
