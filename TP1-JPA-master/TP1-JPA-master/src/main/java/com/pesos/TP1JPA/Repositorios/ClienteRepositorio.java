package com.pesos.TP1JPA.Repositorios;

import com.pesos.TP1JPA.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository <Cliente, Long> {
}
