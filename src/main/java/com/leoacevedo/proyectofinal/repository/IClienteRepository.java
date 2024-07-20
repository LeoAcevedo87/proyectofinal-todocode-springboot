
package com.leoacevedo.proyectofinal.repository;

import com.leoacevedo.proyectofinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
