package com.ufps.pqrsbe.repository;

import com.ufps.pqrsbe.entity.TiposPQRS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPQRSRepo extends JpaRepository<TiposPQRS, Integer> {
    TiposPQRS findByTipo (String tipo);
}
