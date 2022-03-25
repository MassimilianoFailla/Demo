package com.example.demo.dto;

import java.util.Date;
import lombok.Data;

@Data
public class MedicalRecordDTO {

    private Long id;
    private String phase;
    private Date pre_hospitalization;
    private Long ingresso, decorso, trasferimento_interno, dismissione, post_dismissione;

    private UserDTO userDTO = new UserDTO();

    
}