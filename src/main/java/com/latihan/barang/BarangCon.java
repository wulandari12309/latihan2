package com.latihan.barang;

import com.latihan.Servis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class BarangCon {
    @Autowired
    private BarangRep barangRep;

    @Autowired
    private Servis servis;

    @PostMapping("/barang")
    public ResponseEntity<?> tambah(@RequestBody BarangEnt barangEnt) {
        barangEnt.setTanggal(new Date());
        BarangEnt saveBarang = barangRep.save(barangEnt);
        return ResponseEntity.ok(saveBarang);
    }

    @GetMapping("/barang")
    public ResponseEntity<List<BarangEnt>> all() {
        List<BarangEnt> allBarang = barangRep.findAll();
        return ResponseEntity.ok(allBarang);
    }

    @PutMapping("/barang/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BarangEnt barangEnt) {
        Optional<BarangEnt> byNamaBarang = barangRep.findByNama(barangEnt.getNama());
        if (byNamaBarang.isPresent()) {
            BarangEnt getNamaBarang = byNamaBarang.get();
            getNamaBarang.setNama(barangEnt.getNama());
            BarangEnt updateBarang = barangRep.save(getNamaBarang);
            return ResponseEntity.ok(updateBarang);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("gagal update barang");
        }
    }

    @DeleteMapping("/barang/{id}")
    public ResponseEntity<?> hapus(@PathVariable Long id) {
        barangRep.deleteById(id);
        return ResponseEntity.ok("gagal hapus barang");
    }

    @GetMapping("/kode-barang")
    public ResponseEntity<?> generateKode() {
        String kodeBarang = servis.kodeBarang();
        return ResponseEntity.ok(kodeBarang);
    }
}
