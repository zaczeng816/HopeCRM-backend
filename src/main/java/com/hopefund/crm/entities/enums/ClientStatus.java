package com.hopefund.crm.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClientStatus {
    JOINED("进入客服"),
    INTERESTED("有意向"),
    APPOINTED("已约"),
    FOLLOWING_UP("跟进中"),
    DEAL_CLOSED("已成交");

    private String status;

    ClientStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
