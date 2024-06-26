package com.latihan;

import com.latihan.barang.BarangEnt;
import com.latihan.barang.BarangRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servis {
    @Autowired
    private BarangRep barangRep;

    public String kodeBarang() {
        Integer maxKodeBarang = barangRep.findMaxKodeBarang();
        return "BRG" + (maxKodeBarang + 1);
    }


    public BarangEnt saveBarang(BarangEnt barangEnt) {
        if (barangEnt.getKodeBarang() == null || barangEnt.getKodeBarang().isEmpty()) {
            barangEnt.setKodeBarang(kodeBarang());
        }
        return barangRep.save(barangEnt);
    }
}
