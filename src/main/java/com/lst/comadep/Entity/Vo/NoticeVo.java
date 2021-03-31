package com.lst.comadep.Entity.Vo;

import java.util.Arrays;
import java.util.Date;

/**
 * 通知消息  参数接收实体
 */
public class NoticeVo {
    private String noticeName;
    private String noticeRegion;
    private boolean noticeToTop;
    private String noticeType;
    private String noticeContent;
    private Date noticeDate;

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeRegion() {
        return noticeRegion;
    }

    public void setNoticeRegion(String noticeRegion) {
        this.noticeRegion = noticeRegion;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public boolean isNoticeToTop() {
        return noticeToTop;
    }

    public void setNoticeToTop(boolean noticeToTop) {
        this.noticeToTop = noticeToTop;
    }


    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    @Override
    public String toString() {
        return "NoticeVo{" +
                "noticeName='" + noticeName + '\'' +
                ", noticeRegion='" + noticeRegion + '\'' +
                ", noticeToTop=" + noticeToTop +
                ", noticeType='" + noticeType + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeDate=" + noticeDate +
                '}';
    }
}
