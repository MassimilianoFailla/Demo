package com.example.demo.services;

import com.example.demo.dto.MedicalRecordDTO;
import com.example.demo.entity.Medical_Records;

import org.springframework.stereotype.Service;

@Service
public interface MedicalRecordService {

    MedicalRecordDTO findMedicalRecords(Long id);

    public void insMedRec(Medical_Records mediRec);

    Iterable<MedicalRecordDTO> findAll();
}
