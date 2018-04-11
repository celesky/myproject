package com.jvm.generic.base;


import java.util.Date;

public class BaseAnalysisResultBean {

    private String id;
    private Long userId;
    private String deviceId;
    private Date sleepTime;
    private Date awakeningTime;
    private Integer deepSleep;
    private Integer shallowSleep;
    private Integer awakening;
    private Integer awakeningCount;
    private Date analysisTime;
    private Date resetSleepTime;
    private Date resetAwakeningTime;
    private String sleepStateDetail;
    private Integer isCompleted;
    private Date created;
    private Long updated;
    private String xLabels;
    private String yValues;
    private boolean nightSleep;
    private String sleepDay;

    public BaseAnalysisResultBean() {
    }

    public int getTotalSleepTime() {
        return this.awakening + this.shallowSleep + this.deepSleep;
    }

    public String getId() {
        return this.id;
    }

    public BaseAnalysisResultBean setId(String id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return this.userId;
    }

    public BaseAnalysisResultBean setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public BaseAnalysisResultBean setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public Date getSleepTime() {
        return this.sleepTime;
    }

    public BaseAnalysisResultBean setSleepTime(Date sleepTime) {
        this.sleepTime = sleepTime;
        return this;
    }

    public Date getAwakeningTime() {
        return this.awakeningTime;
    }

    public BaseAnalysisResultBean setAwakeningTime(Date awakeningTime) {
        this.awakeningTime = awakeningTime;
        return this;
    }

    public Integer getDeepSleep() {
        return this.deepSleep;
    }

    public BaseAnalysisResultBean setDeepSleep(Integer deepSleep) {
        this.deepSleep = deepSleep;
        return this;
    }

    public Integer getShallowSleep() {
        return this.shallowSleep;
    }

    public BaseAnalysisResultBean setShallowSleep(Integer shallowSleep) {
        this.shallowSleep = shallowSleep;
        return this;
    }

    public Integer getAwakening() {
        return this.awakening;
    }

    public BaseAnalysisResultBean setAwakening(Integer awakening) {
        this.awakening = awakening;
        return this;
    }

    public Integer getAwakeningCount() {
        return this.awakeningCount;
    }

    public BaseAnalysisResultBean setAwakeningCount(Integer awakeningCount) {
        this.awakeningCount = awakeningCount;
        return this;
    }

    public Date getAnalysisTime() {
        return this.analysisTime;
    }

    public BaseAnalysisResultBean setAnalysisTime(Date analysisTime) {
        this.analysisTime = analysisTime;
        return this;
    }

    public Date getResetSleepTime() {
        return this.resetSleepTime;
    }

    public BaseAnalysisResultBean setResetSleepTime(Date resetSleepTime) {
        this.resetSleepTime = resetSleepTime;
        return this;
    }

    public Date getResetAwakeningTime() {
        return this.resetAwakeningTime;
    }

    public BaseAnalysisResultBean setResetAwakeningTime(Date resetAwakeningTime) {
        this.resetAwakeningTime = resetAwakeningTime;
        return this;
    }

    public String getSleepStateDetail() {
        return this.sleepStateDetail;
    }

    public BaseAnalysisResultBean setSleepStateDetail(String sleepStateDetail) {
        this.sleepStateDetail = sleepStateDetail;
        return this;
    }

    public Integer getIsCompleted() {
        return this.isCompleted;
    }

    public BaseAnalysisResultBean setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

    public Date getCreated() {
        return this.created;
    }

    public BaseAnalysisResultBean setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Long getUpdated() {
        return this.updated;
    }

    public BaseAnalysisResultBean setUpdated(Long updated) {
        this.updated = updated;
        return this;
    }

    public String getxLabels() {
        return this.xLabels;
    }

    public BaseAnalysisResultBean setxLabels(String xLabels) {
        this.xLabels = xLabels;
        return this;
    }

    public String getyValues() {
        return this.yValues;
    }

    public BaseAnalysisResultBean setyValues(String yValues) {
        this.yValues = yValues;
        return this;
    }

    public boolean isNightSleep() {
        return this.nightSleep;
    }

    public BaseAnalysisResultBean setNightSleep(boolean nightSleep) {
        this.nightSleep = nightSleep;
        return this;
    }

//    public String getSleepDay() {
////        if (this.analysisTime != null) {
////            this.sleepDay = DateUtils.format(this.analysisTime, new String[]{"yyyy-MM-dd"});
////        }
////
////        return this.sleepDay;
//    }

    public BaseAnalysisResultBean setSleepDay(String sleepDay) {
        this.sleepDay = sleepDay;
        return this;
    }
}
