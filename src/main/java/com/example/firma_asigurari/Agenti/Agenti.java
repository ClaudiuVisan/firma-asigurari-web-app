package com.example.firma_asigurari.Agenti;


import com.example.firma_asigurari.Asigurari.Asigurari;
import com.example.firma_asigurari.Clienti.Clienti;

import javax.persistence.*;

@Entity
@Table(name="agenti")
public class Agenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true,length = 45)
    private String nume;

    @Column(nullable = true,length = 45)
    private String prenume;

    @Column(nullable = true,length = 45)
    private String companie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idasigurare")
    private Asigurari asigurare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idclient")
    private Clienti client;

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

    public String getCompanie() {
        return companie;
    }

    public void setCompanie(String companie) {
        this.companie = companie;
    }

    public Asigurari getAsigurare() {
        return asigurare;
    }

    public void setAsigurare(Asigurari asigurare) {
        this.asigurare = asigurare;
    }

    public Clienti getClient() {
        return client;
    }

    public void setClient(Clienti client) {
        this.client = client;
    }
}
