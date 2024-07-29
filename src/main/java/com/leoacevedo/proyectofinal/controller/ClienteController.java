
package com.leoacevedo.proyectofinal.controller;

import com.leoacevedo.proyectofinal.model.Cliente;
import com.leoacevedo.proyectofinal.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService cliService;
            
    //C        
    @PostMapping("/clientes/crear")
    public void crearCliente(@RequestBody Cliente cli){
        cliService.createCliente(cli);
    }
    
    //R
    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable Long id_cliente){
        return cliService.getCliente(id_cliente);
    }
    
    //U
    
    @PutMapping("/editar/{id_cliente}")
    public void editarCliente(@PathVariable("id_cliente") Long idCliente, @RequestBody Cliente cliente) {
        cliService.editCliente(idCliente, cliente);
    }
    
    //D
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable Long id_cliente){
        cliService.deleteCliente(id_cliente);
    }
    
    //List
    @GetMapping("/clientes")    
    public List<Cliente> listarClientes(){
        return cliService.getListClientes();
    }
    
    //extra: buscar clientes por nombre o apellido, segun texto ingresado
    @GetMapping("/clientes/buscar_nombre_apllido/{texto_cliente}")    
    public List<Cliente> buscarNombreApellido(@PathVariable String texto_cliente) {
        return cliService.buscarNombreApellido(texto_cliente);
    }
    
    //extra: buscar clientes por dni
    @GetMapping("/clientes/buscar_dni/{dni_cliente}")    
    public Cliente buscarDni(@PathVariable String dni_cliente) {
        return cliService.buscarDni(dni_cliente);
    }
}
