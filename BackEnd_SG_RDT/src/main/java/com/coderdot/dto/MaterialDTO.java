package com.coderdot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MaterialDTO {
    private String code;
    private String marque;
    private String model;
    private String numeroDeMarche;
    private String numeroDeSerie;
    private Date dateDacquisition ;
    private Date dateDeMiseEnService;
}
