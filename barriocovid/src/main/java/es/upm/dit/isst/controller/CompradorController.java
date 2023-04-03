package es.upm.dit.isst.controller;

import org.slf4j.Logger;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.model.Comprador;
import es.upm.dit.isst.repository.CompradorRepository;
import es.upm.dit.isst.model.Vendedor;
import es.upm.dit.isst.repository.VendedorRepository;

@RestController

public class CompradorController {
// Inyección de dependencia del repositorio de Comprador
    private final CompradorRepository compradorRepository;
// Logger para registrar eventos
    public static final Logger log = LoggerFactory.getLogger(CompradorController.class);
 // Constructor que recibe el repositorio de Comprador como parámetro
    public CompradorController(CompradorRepository t) {

        this.compradorRepository = t;
    }
// Inyección de dependencia del repositorio de Vendedor
    @Autowired
    private VendedorRepository vendedorRepository;
    
        @PostMapping("/{idVendedor}/{idProducto}")
        public ResponseEntity<String> comprarProducto(@PathVariable String idVendedor, @PathVariable String idProducto) {
    
            // Buscar el vendedor por ID
            Optional<Vendedor> optionalVendedor = vendedorRepository.findById(idVendedor);
    
    
                // Obtener el catálogo del vendedor
                String[] catalogo = optionalVendedor.get().isCatalogo();
    
                // Comprobar si el producto existe en el catálogo
                boolean productoEncontrado = false;
                for (String producto : catalogo) {
                    if (producto.equals(idProducto)) {
                        productoEncontrado = true;
                        break;
                    }
                }
    
                // Si el producto existe en el catálogo, devolver un mensaje de éxito
                if (productoEncontrado) {
                    String mensaje = " El producto " + idProducto + " ha sido añadidio correctamente al carrito";
                    return new ResponseEntity<>(mensaje, HttpStatus.OK);
                }
    
                // Si el producto no existe en el catálogo, devolver un mensaje de error
                else {
                    String mensaje = "El producto " + idProducto + " no se encuentra en stock";
                    return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
                }
    
            
    
        }
   
}