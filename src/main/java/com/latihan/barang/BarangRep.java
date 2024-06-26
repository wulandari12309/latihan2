package com.latihan.barang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BarangRep extends JpaRepository<BarangEnt, Long> {
    @Query("SELECT COALESCE(MAX(CAST(SUBSTRING(b.kodeBarang, 4)AS int)), 0) FROM BarangEnt b WHERE b.kodeBarang LIKE 'BRG%'")
    Integer findMaxKodeBarang();

    Optional <BarangEnt> findByNama(String nama);
}
