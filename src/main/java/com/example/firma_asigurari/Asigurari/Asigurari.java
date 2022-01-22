package com.example.firma_asigurari.Asigurari;

import com.example.firma_asigurari.Agenti.Agenti;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="asigurari")
public class Asigurari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true,length = 45)
    private String tipasigurare;

    @Column(nullable = true,length = 45)
    private String durata;

    @Column(nullable = true)
    private Float pret;

    @Column(nullable = true)
    private Date datainceput;

    @Column(nullable = true)
    private Date dataexpirare;

    @OneToMany(targetEntity = Agenti.class, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Agenti> agentiList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipasigurare() {
        return tipasigurare;
    }

    public void setTipasigurare(String tipasigurare) {
        this.tipasigurare = tipasigurare;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public Float getPret() {
        return pret;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }

    public Date getDatainceput() {
        return datainceput;
    }

    public void setDatainceput(Date datainceput) {
        this.datainceput = datainceput;
    }

    public Date getDataexpirare() {
        return dataexpirare;
    }

    public void setDataexpirare(Date dataexpirare) {
        this.dataexpirare = dataexpirare;
    }

    public List<Agenti> getAgentiList() {
        return agentiList;
    }

    public void setAgentiList(List<Agenti> agentiList) {
        this.agentiList = agentiList;
    }
}
