
package com.leoacevedo.proyectofinal.repository;

import com.leoacevedo.proyectofinal.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

}
