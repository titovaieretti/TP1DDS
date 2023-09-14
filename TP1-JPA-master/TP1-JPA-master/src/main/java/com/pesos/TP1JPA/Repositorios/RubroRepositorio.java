package com.pesos.TP1JPA.Repositorios;

import com.pesos.TP1JPA.Entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepositorio extends JpaRepository <Rubro, Long> {
}
