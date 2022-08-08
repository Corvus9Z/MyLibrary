package com.howtodoinjava.hibernate.test.dto.Library;

import jakarta.persistence.*;

@Entity
@Table(name="Publishing House")
public class PublishingHouse {
    @Id
    @GeneratedValue
    @Column(name="ID",unique = true,nullable = false)
    private Integer PublishingHouseID;

    @Column(name="PublishingHouseName",unique = true,nullable = false)
    private String PublishingHouseName;
    @Column(name="Years Of Appearance",nullable = false)
    private Integer yearsOfAppearance;
    @Column(name="Ranking",nullable = false)
    private Integer rank;


    public Integer getPublishingHouseID() {
        return PublishingHouseID;
    }

    public void setPublishingHouseID(Integer publishingHouseID) {
        PublishingHouseID = publishingHouseID;
    }

    public String getPublishingHouseName() {
        return PublishingHouseName;
    }

    public void setPublishingHouseName(String publishingHouseName) {
        PublishingHouseName = publishingHouseName;
    }

    public Integer getYearsOfAppearance() {
        return yearsOfAppearance;
    }

    public void setYearsOfAppearance(Integer yearsOfAppearance) {
        this.yearsOfAppearance = yearsOfAppearance;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "PublishingHouseID=" + PublishingHouseID +
                ", PublishingHouseName='" + PublishingHouseName + '\'' +
                ", yearsOfAppearance=" + yearsOfAppearance +
                ", rank=" + rank +
                '}';
    }
}
