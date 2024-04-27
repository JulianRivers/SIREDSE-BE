package com.ufps.pqrsbe.repository;

import com.ufps.pqrsbe.entity.EstadosPQRS;
import com.ufps.pqrsbe.entity.PQRS;
import com.ufps.pqrsbe.entity.TiposPQRS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PQRSRepo extends JpaRepository<PQRS, Integer> {

    List<PQRS> findByTipoPqrs (TiposPQRS tiposPqrs);
    List<PQRS> findByEstadoRadicado (EstadosPQRS estadosPQRS);

}
