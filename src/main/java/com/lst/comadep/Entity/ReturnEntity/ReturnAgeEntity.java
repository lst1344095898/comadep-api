package com.lst.comadep.Entity.ReturnEntity;

/**
 * 返回年纪数据
 * babyNumber 0-5岁婴儿
 * juvenileNumber 6-14岁少年
 * youthNumber 15-24 青年
 * adultNumber 25-64 壮年
 * elderlyNumber 66-? 老年
 */
public class ReturnAgeEntity {
    private Integer babyNumber;
    private Integer juvenileNumber;
    private Integer youthNumber;
    private Integer adultNumber;
    private Integer elderlyNumber;

    public Integer getBabyNumber() {
        return babyNumber;
    }

    public void setBabyNumber(Integer babyNumber) {
        this.babyNumber = babyNumber;
    }

    public Integer getJuvenileNumber() {
        return juvenileNumber;
    }

    public void setJuvenileNumber(Integer juvenileNumber) {
        this.juvenileNumber = juvenileNumber;
    }

    public Integer getYouthNumber() {
        return youthNumber;
    }

    public void setYouthNumber(Integer youthNumber) {
        this.youthNumber = youthNumber;
    }

    public Integer getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(Integer adultNumber) {
        this.adultNumber = adultNumber;
    }

    public Integer getElderlyNumber() {
        return elderlyNumber;
    }

    public void setElderlyNumber(Integer elderlyNumber) {
        this.elderlyNumber = elderlyNumber;
    }
}
