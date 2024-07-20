
package com.leoacevedo.proyectofinal.service;

import com.leoacevedo.proyectofinal.model.Producto;
import com.leoacevedo.proyectofinal.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired 
    private IProductoRepository produRepo;
    
    @Override
    public void createProducto(Producto produc) {
        produRepo.save(produc);
    }

    @Override
    public List<Producto> getListProductos() {
        return produRepo.findAll();
    }

    @Override
    public Producto getProducto(Long id) {
        return produRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(Long id) {
        produRepo.deleteById(id);
    }

    @Override
    public void editProducto(Producto produc) {
        this.createProducto(produc);
    }

}
