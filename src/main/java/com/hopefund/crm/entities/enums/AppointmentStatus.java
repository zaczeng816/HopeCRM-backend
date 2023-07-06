package com.hopefund.crm.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AppointmentStatus {
    APPOINTED("已预约"),
    FOLLOWING_UP("跟进中"),
    COMPLETED("完成");

    private String status;

    AppointmentStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
