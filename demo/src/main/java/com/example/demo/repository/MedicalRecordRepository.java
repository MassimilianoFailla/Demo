package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Medical_Records;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicalRecordRepository extends JpaRepository<Medical_Records, Integer>{
    
    Medical_Records findById(Long id);

    @Override
    default List<Medical_Records> findAll() {

        return null;
    }

}
