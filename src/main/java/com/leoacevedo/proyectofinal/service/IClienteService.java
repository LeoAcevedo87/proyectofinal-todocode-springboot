
package com.leoacevedo.proyectofinal.service;

import com.leoacevedo.proyectofinal.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    public void createCliente(Cliente cli);
    
    public List<Cliente> getListClientes();
    
    public Cliente getCliente(Long id);
    
    public void deleteCliente(Long id);
    
    public void editCliente(Long idCliente, Cliente cli);
    
    public List<Cliente> buscarNombreApellido(String texto);
    
     public Cliente buscarDni(String dni);
    
}
