package com.example.demo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Medical_Records")
class Medical_Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phase")
    private String phase;

    @Column(name = "pre_hospitalization")
    private Date pre_hospitalization;

    @Column(name = "ingresso")
    private Long ingresso;

    @Column(name = "decorso")
    private Long decorso;

    @Column(name = "trasferimento_interno")
    private Long trasferimento_interno;

    @Column(name = "dismissione")
    private Long dismissione;

    @Column(name = "post_dismissione")
    private Long post_dismissione;


    public Medical_Records() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}