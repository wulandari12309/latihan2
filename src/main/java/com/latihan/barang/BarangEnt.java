package com.latihan.barang;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "barang")
public class BarangEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private String kodeBarang;
    private Integer stokBarang;
    private Integer kategoriBarang;
    private Integer hargaModal;
    private Integer hargaJual;
    private Date tanggal;

    @PrePersist
    public void KodeBarangAuto() {
        if (kodeBarang == null || kodeBarang.isEmpty()) {
            kodeBarang = generateKodeBarang();
        }
    }

    private String generateKodeBarang() {
        return "KB" + System.currentTimeMillis();
    }

    public BarangEnt(){};

    public BarangEnt(Long id, String nama, String kodeBarang, Integer stokBarang, Integer kategoriBarang, Integer hargaModal, Integer hargaJual, Date tanggal) {
        this.id = id;
        this.nama = nama;
        this.kodeBarang = kodeBarang;
        this.stokBarang = stokBarang;
        this.kategoriBarang = kategoriBarang;
        this.hargaModal = hargaModal;
        this.hargaJual = hargaJual;
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

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public Integer getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(Integer stokBarang) {
        this.stokBarang = stokBarang;
    }

    public Integer getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(Integer kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }

    public Integer getHargaModal() {
        return hargaModal;
    }

    public void setHargaModal(Integer hargaModal) {
        this.hargaModal = hargaModal;
    }

    public Integer getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Integer hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
