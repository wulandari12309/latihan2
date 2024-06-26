package com.latihan;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "kategori")
public class KategoriEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private Date tanggal;

    public KategoriEnt () {}

    public KategoriEnt(Long id, String nama, Date tanggal) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
