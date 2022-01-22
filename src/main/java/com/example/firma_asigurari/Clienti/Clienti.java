package com.example.firma_asigurari.Clienti;

import com.example.firma_asigurari.Agenti.Agenti;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clienti")
public class Clienti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true,length = 45)
    private String nume;

    @Column(nullable = true,length = 45)
    private String prenume;

    @Column(nullable = true,length = 45)
    private String telefon;

    @Column(nullable = true,length = 45)
    private String adresa;

    @OneToMany(targetEntity = Agenti.class, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Agenti> agentiList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Agenti> getAgentiList() {
        return agentiList;
    }

    public void setAgentiList(List<Agenti> agentiList) {
        this.agentiList = agentiList;
    }
}
