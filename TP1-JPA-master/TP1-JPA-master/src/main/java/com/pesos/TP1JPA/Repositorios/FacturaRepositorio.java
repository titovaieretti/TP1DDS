package com.pesos.TP1JPA.Repositorios;

import com.pesos.TP1JPA.Entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura,Long> {
}
