package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="entrance")
public class Entrance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "diagnoses")
    private String diagnoses;

    @Column(name = "journal")
    private String journal;

    @Column(name = "note")
    private String note;

    @Column(name = "availment") //Utilizzo
    private String availment;

    public Entrance() {
    }

    public Entrance(Long id, String diagnoses, String journal, String note, String availment) {
        this.id = id;
        this.diagnoses = diagnoses;
        this.journal = journal;
        this.note = note;
        this.availment = availment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAvailment() {
        return availment;
    }

    public void setAvailment(String availment) {
        this.availment = availment;
    }

    @Override
    public String toString() {
        return "Entrance [availment=" + availment + ", diagnoses=" + diagnoses + ", id=" + id + ", journal=" + journal
                + ", note=" + note + "]";
    }

}