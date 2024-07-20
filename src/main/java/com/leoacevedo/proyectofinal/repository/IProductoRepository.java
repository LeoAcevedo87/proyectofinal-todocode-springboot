
package com.leoacevedo.proyectofinal.repository;

import com.leoacevedo.proyectofinal.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{

}
