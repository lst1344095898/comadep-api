package com.lst.comadep.Entity;

public class MapInfo {
    private int id;
    private int buildingWidth;
    private int buildingLength;
    private int buildingHeight;
    private int buildingNumber;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildingWidth() {
        return buildingWidth;
    }

    public void setBuildingWidth(int buildingWidth) {
        this.buildingWidth = buildingWidth;
    }

    public int getBuildingLength() {
        return buildingLength;
    }

    public void setBuildingLength(int buildingLength) {
        this.buildingLength = buildingLength;
    }

    public int getBuildingHeight() {
        return buildingHeight;
    }

    public void setBuildingHeight(int buildingHeight) {
        this.buildingHeight = buildingHeight;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString() {
        return "MapInfo{" +
                "id=" + id +
                ", buildingWidth=" + buildingWidth +
                ", buildingLength=" + buildingLength +
                ", buildingHeight=" + buildingHeight +
                ", buildingNumber=" + buildingNumber +
                '}';
    }
}
