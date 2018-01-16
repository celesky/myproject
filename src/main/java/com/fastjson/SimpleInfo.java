package com.fastjson;

import java.util.Calendar;

/**
 * Created by pan on 2018/1/3.
 */
public class SimpleInfo {
    public Calendar fromTime;
    public Calendar arrivalDateTime;

    public Calendar getFromTime() {
        return fromTime;
    }

    public SimpleInfo setFromTime(Calendar fromTime) {
        this.fromTime = fromTime;
        return this;
    }

    public Calendar getArrivalDateTime() {
        return arrivalDateTime;
    }

    public SimpleInfo setArrivalDateTime(Calendar arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
        return this;
    }
}
