package com.hopefund.crm.DTO;

public record IdStringDTO(Long id, String value){
    public IdStringDTO(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}
