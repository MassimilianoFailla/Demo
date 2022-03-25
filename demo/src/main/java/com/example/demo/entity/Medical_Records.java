package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Medical_Records")
public class Medical_Records implements Serializable {

    private static final long serialVersionUID = 291353626011036772L;

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

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private Users users;

    public Medical_Records() {
    }

    public Medical_Records(Long id, String phase, Date pre_hospitalization, Long ingresso, Long decorso,
            Long trasferimento_interno, Long dismissione, Long post_dismissione, Users users) {
        this.id = id;
        this.phase = phase;
        this.pre_hospitalization = pre_hospitalization;
        this.ingresso = ingresso;
        this.decorso = decorso;
        this.trasferimento_interno = trasferimento_interno;
        this.dismissione = dismissione;
        this.post_dismissione = post_dismissione;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Date getPre_hospitalization() {
        return pre_hospitalization;
    }

    public void setPre_hospitalization(Date pre_hospitalization) {
        this.pre_hospitalization = pre_hospitalization;
    }

    public Long getIngresso() {
        return ingresso;
    }

    public void setIngresso(Long ingresso) {
        this.ingresso = ingresso;
    }

    public Long getDecorso() {
        return decorso;
    }

    public void setDecorso(Long decorso) {
        this.decorso = decorso;
    }

    public Long getTrasferimento_interno() {
        return trasferimento_interno;
    }

    public void setTrasferimento_interno(Long trasferimento_interno) {
        this.trasferimento_interno = trasferimento_interno;
    }

    public Long getDismissione() {
        return dismissione;
    }

    public void setDismissione(Long dismissione) {
        this.dismissione = dismissione;
    }

    public Long getPost_dismissione() {
        return post_dismissione;
    }

    public void setPost_dismissione(Long post_dismissione) {
        this.post_dismissione = post_dismissione;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Medical_Records [decorso=" + decorso + ", dismissione=" + dismissione + ", id=" + id + ", ingresso="
                + ingresso + ", phase=" + phase + ", post_dismissione=" + post_dismissione + ", pre_hospitalization="
                + pre_hospitalization + ", trasferimento_interno=" + trasferimento_interno + ", users=" + users + "]";
    }

}