package com.hopefund.crm.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ClientStatus {
    JOINED("进入客服"),
    INTERESTED("有意向"),
    APPOINTED("已约"),
    FOLLOWING_UP("跟进中"),
    DEAL_CLOSED("已成交");

    private final String status;

    ClientStatus(String status) {
        this.status = status;
    }

    private static final Map<String, ClientStatus> BY_STATUS = new HashMap<>();

    static {
        for (ClientStatus e: values()) {
            BY_STATUS.put(e.status, e);
        }
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static ClientStatus forValue(String status) {
        return BY_STATUS.get(status);
    }
}
