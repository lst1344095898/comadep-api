package com.lst.comadep.Entity.Vo;

public class PageParameter {
    private int currPage;
    private int total;
    private int pageSize;
    private int buildingNumber;
    private int floorNumber;
    private String searchParameter;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }

    @Override
    public String toString() {
        return "PageParameter{" +
                "currPage=" + currPage +
                ", total=" + total +
                ", pageSize=" + pageSize +
                ", buildingNumber=" + buildingNumber +
                ", floorNumber=" + floorNumber +
                ", searchParameter='" + searchParameter + '\'' +
                '}';
    }
}
