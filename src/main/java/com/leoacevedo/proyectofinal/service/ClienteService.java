package com.leoacevedo.proyectofinal.service;

import com.leoacevedo.proyectofinal.model.Cliente;
import com.leoacevedo.proyectofinal.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void createCliente(Cliente cli) { //<C>
        clienteRepo.save(cli);
    }

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepo.findById(id).orElse(null); //<R>
    }

    @Override
    public void editCliente(Long idCliente, Cliente cliente) {
        Cliente clienteExistente = clienteRepo.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        //Cliente clienteExistente = clienteRepo.findById(idCliente).orElse(null); PODRIA SER ASI TAMBIEN
        
        // Actualiza los campos necesarios del cliente existente
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setDni(cliente.getDni());
        
        //Guarda el cliente editado
        clienteRepo.save(clienteExistente);
    }

    @Override
    public void deleteCliente(Long id) { //<D>
        clienteRepo.deleteById(id);
    }

    @Override
    public List<Cliente> getListClientes() {
        return clienteRepo.findAll();
    }
}
