package com.hopefund.crm.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum AppointmentStatus {
    APPOINTED("已预约"),
    FOLLOWING_UP("跟进中"),
    COMPLETED("完成");

    private final String status;

    AppointmentStatus(String status) {
        this.status = status;
    }

    private static final Map<String, AppointmentStatus> BY_STATUS = new HashMap<>();

    static{
        for(AppointmentStatus e: values()){
            BY_STATUS.put(e.status, e);
        }
    }
    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static AppointmentStatus forValue(String status) {
        return BY_STATUS.get(status);
    }

}
