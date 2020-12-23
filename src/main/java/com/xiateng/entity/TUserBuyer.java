package com.xiateng.entity;

public class TUserBuyer {
    private Long userId;

    private String name;

    private String description;

    private Integer level;

    private Integer bond;

    private Short bondStatus;

    private Short bidStatus;

    private Integer deposit;

    private Integer score;

    private Short smAuction;

    private Short smTrade;

    private Short smOrder;

    private Short smArbitration;

    private Short smActivity;

    private Long tenantid;

    private String weixinCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBond() {
        return bond;
    }

    public void setBond(Integer bond) {
        this.bond = bond;
    }

    public Short getBondStatus() {
        return bondStatus;
    }

    public void setBondStatus(Short bondStatus) {
        this.bondStatus = bondStatus;
    }

    public Short getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(Short bidStatus) {
        this.bidStatus = bidStatus;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Short getSmAuction() {
        return smAuction;
    }

    public void setSmAuction(Short smAuction) {
        this.smAuction = smAuction;
    }

    public Short getSmTrade() {
        return smTrade;
    }

    public void setSmTrade(Short smTrade) {
        this.smTrade = smTrade;
    }

    public Short getSmOrder() {
        return smOrder;
    }

    public void setSmOrder(Short smOrder) {
        this.smOrder = smOrder;
    }

    public Short getSmArbitration() {
        return smArbitration;
    }

    public void setSmArbitration(Short smArbitration) {
        this.smArbitration = smArbitration;
    }

    public Short getSmActivity() {
        return smActivity;
    }

    public void setSmActivity(Short smActivity) {
        this.smActivity = smActivity;
    }

    public Long getTenantid() {
        return tenantid;
    }

    public void setTenantid(Long tenantid) {
        this.tenantid = tenantid;
    }

    public String getWeixinCode() {
        return weixinCode;
    }

    public void setWeixinCode(String weixinCode) {
        this.weixinCode = weixinCode == null ? null : weixinCode.trim();
    }
}