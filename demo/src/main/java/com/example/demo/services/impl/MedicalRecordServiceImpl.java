package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.dto.MedicalRecordDTO;
import com.example.demo.entity.Medical_Records;
import com.example.demo.repository.MedicalRecordRepository;
import com.example.demo.services.MedicalRecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    MedicalRecordRepository medRecRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public MedicalRecordDTO findMedicalRecords(Long id) {
        
        Medical_Records medRec = medRecRepo.findById(id);
        MedicalRecordDTO medRecDTO = null;

        if(medRec != null){
            medRecDTO = modelMapper.map(medRec, MedicalRecordDTO.class);
        }
        return medRecDTO;
    }

    @Override
    public void insMedRec(Medical_Records mediRec) {

        medRecRepo.save(mediRec);
    }

    @Override
    public Iterable<MedicalRecordDTO> findAll() {
       
        List<Medical_Records> medRecList = medRecRepo.findAll();
        List<MedicalRecordDTO> medRecDTOList = new ArrayList<MedicalRecordDTO>();

        for(int i = 0; i <medRecList.size(); i++){
            Medical_Records medRec = medRecList.get(i);
            medRecDTOList.add(modelMapper.map(medRec, MedicalRecordDTO.class));
        }
        return medRecDTOList;
    }

}