package com.latihan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class KategoriCon {
    @Autowired
    private KategoriRep kategoriRep;

    @PostMapping("/kategori")
    public ResponseEntity<?> tambah(@RequestBody KategoriEnt kategoriEnt) {
        kategoriEnt.setTanggal(new Date());
        KategoriEnt saveKate = kategoriRep.save(kategoriEnt);
        return ResponseEntity.ok(saveKate);
    }

    @GetMapping("/kategori")
    public ResponseEntity<List<KategoriEnt>> all() {
        List<KategoriEnt> allKate = kategoriRep.findAll();
        return ResponseEntity.ok(allKate);
    }

    @PutMapping("/kategori/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody KategoriEnt kategoriEnt) {
        Optional<KategoriEnt> byIdKate = kategoriRep.findById(id);
        if (byIdKate.isPresent()) {
            KategoriEnt updateKate = byIdKate.get();
            updateKate.setNama(kategoriEnt.getNama());
            KategoriEnt saveUpdate = kategoriRep.save(updateKate);
            return ResponseEntity.ok(saveUpdate);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("gagal update");
        }
    }

    @DeleteMapping("/kategori/{id}")
    public ResponseEntity<?> hapus(@PathVariable Long id) {
        kategoriRep.deleteById(id);
        return ResponseEntity.ok("terhapus");
    }
}
