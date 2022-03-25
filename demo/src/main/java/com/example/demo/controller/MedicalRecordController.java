package com.example.demo.controller;
    
import java.util.List;
import javax.validation.Valid;
import com.example.demo.dto.MedicalRecordDTO;
import com.example.demo.entity.Medical_Records;
import com.example.demo.repository.MedicalRecordRepository;
import com.example.demo.services.MedicalRecordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/medicalRecord")  
public class MedicalRecordController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

        @Autowired
        MedicalRecordRepository medicalRepository;
    
        @Autowired
        MedicalRecordService medicalRecordService;

        @GetMapping
        public ResponseEntity<List<Medical_Records>> getAll() {
            try {
                List<Medical_Records> items = new ArrayList<Medical_Records>();
    
                medicalRepository.findAll().forEach(items::add);
    
                if (items.isEmpty())
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    
                return new ResponseEntity<>(items, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
        @GetMapping(value = "{id}", produces = "application/json")
        public ResponseEntity<MedicalRecordDTO> getById(@PathVariable("id") Long id) {
    
            logger.info("Visualizzazione medical Record con id -> %d", + id);
    
            MedicalRecordDTO medRecDTO = medicalRecordService.findMedicalRecords(id);
    
            return new ResponseEntity<MedicalRecordDTO>(medRecDTO, new HttpHeaders(), HttpStatus.OK);
    
        }
    
        @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> create(@Valid @RequestBody Medical_Records medRec) {
            
            logger.info("Salvo il medical Record con id " + medRec.getId());

            MedicalRecordDTO medRecDTO = medicalRecordService.findMedicalRecords(medRec.getId());
            logger.info("MEDICAL RECORD DTO: ", medRecDTO);
            if (medRecDTO != null) {
                String MsgErr = String.format("Medical Record con id -> " + medRec.getId() + " presente! - Impossibile inserire!",
                medRec.getId());
                logger.warn(MsgErr);
            }
    
            logger.info("hai salvato il Medical Record\n\n\n" + "-> " + medRec);
    
            medicalRecordService.insMedRec(medRec);
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode responseNode = mapper.createObjectNode();
            responseNode.put("code", HttpStatus.OK.toString());
            responseNode.put("message", String.format("Inserimento nuovo medical Record con id -> " + medRec.getId() + "eseguito con successo"));
            return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.CREATED);

        }
    
    //     @PutMapping("{id}")
    //     public ResponseEntity<entityClassName> update(@PathVariable("id") entityIdType id, @RequestBody entityClassName item) {
    //         Optional<entityClassName> existingItemOptional = repository.findById(id);
    //         if (existingItemOptional.isPresent()) {
    //             entityClassName existingItem = existingItemOptional.get();
    //             //existingItem.setSomeField(item.getSomeField());
    //             return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //         }
    //     }
    
    //     @DeleteMapping("{id}")
    //     public ResponseEntity<HttpStatus> delete(@PathVariable("id") entityIdType id) {
    //         try {
    //             repository.deleteById(id);
    //             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //         } catch (Exception e) {
    //             return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    //         }
    //     }
    // }



}
