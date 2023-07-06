package com.hopefund.crm.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClientType {
    POTENTIAL("潜在客户"),
    REAL("现实客户");

    private String type;

    ClientType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
