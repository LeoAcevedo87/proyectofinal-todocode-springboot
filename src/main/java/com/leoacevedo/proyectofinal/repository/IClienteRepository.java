
package com.leoacevedo.proyectofinal.repository;

import com.leoacevedo.proyectofinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    
    public Cliente findByDni(String dni);
}
