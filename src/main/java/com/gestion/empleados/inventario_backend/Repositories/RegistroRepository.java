package com.gestion.empleados.inventario_backend.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.inventario_backend.models.Registro;

@Repository

public interface RegistroRepository extends JpaRepository <Registro, Long>{
    
}
