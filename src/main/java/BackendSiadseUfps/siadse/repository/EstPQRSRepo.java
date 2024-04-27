package com.ufps.pqrsbe.repository;

import com.ufps.pqrsbe.entity.EstadosPQRS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstPQRSRepo extends JpaRepository<EstadosPQRS, Integer> {
    EstadosPQRS findByEstado (String estado);
}