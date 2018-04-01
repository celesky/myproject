package com.generic.entity;

import com.generic.base.BaseAnalysisResultBean;

import java.util.Objects;

public class SleepAnalysisResultBeanEntity extends BaseAnalysisResultBean {
    private static final long serialVersionUID = -5568326316580943699L;


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof SleepAnalysisResultBeanEntity)) {
            return false;
        } else {
            SleepAnalysisResultBeanEntity resultDto = (SleepAnalysisResultBeanEntity) o;
            return this.isNightSleep() == resultDto.isNightSleep() && Objects.equals(this.getUserId(), resultDto.getUserId()) && Objects.equals(this.getDeviceId(), resultDto.getDeviceId()) && Objects.equals(this.getSleepTime(), resultDto.getSleepTime()) && Objects.equals(this.getAwakeningTime(), resultDto.getAwakeningTime()) && Objects.equals(this.getDeepSleep(), resultDto.getDeepSleep()) && Objects.equals(this.getShallowSleep(), resultDto.getShallowSleep()) && Objects.equals(this.getAwakening(), resultDto.getAwakening()) && Objects.equals(this.getAwakeningCount(), resultDto.getAwakeningCount()) && Objects.equals(this.getAnalysisTime(), resultDto.getAnalysisTime()) && Objects.equals(this.getResetSleepTime(), resultDto.getResetSleepTime()) && Objects.equals(this.getResetAwakeningTime(), resultDto.getResetAwakeningTime()) && Objects.equals(this.getSleepStateDetail(), resultDto.getSleepStateDetail()) && Objects.equals(this.getSleepDay(), resultDto.getSleepDay());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getUserId(), this.getDeviceId(), this.getSleepTime(), this.getAwakeningTime(), this.getDeepSleep(), this.getShallowSleep(), this.getAwakening(), this.getAwakeningCount(), this.getAnalysisTime(), this.getResetSleepTime(), this.getResetAwakeningTime(), this.getSleepStateDetail(), this.isNightSleep(), this.getSleepDay()});
    }
}
