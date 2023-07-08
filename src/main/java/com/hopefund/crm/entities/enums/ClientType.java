package com.hopefund.crm.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ClientType {
    POTENTIAL("潜在客户"),
    REAL("现实客户");

    private final String type;

    ClientType(String type) {
        this.type = type;
    }

    private static final Map<String, ClientType> BY_TYPE = new HashMap<>();

    static{
        for(ClientType e: values()){
            BY_TYPE.put(e.type, e);
        }
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static ClientType forValue(String type) {
        return BY_TYPE.get(type);
    }
}
