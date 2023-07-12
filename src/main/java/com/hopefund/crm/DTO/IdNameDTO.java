package com.hopefund.crm.DTO;

public record IdNameDTO(Long id, String name){
    public IdNameDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
