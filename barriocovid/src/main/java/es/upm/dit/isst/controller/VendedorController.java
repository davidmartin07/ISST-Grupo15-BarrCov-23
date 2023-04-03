package es.upm.dit.isst.controller;

import java.sql.Blob;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.upm.dit.isst.model.Vendedor;
import es.upm.dit.isst.model.Producto;
public class VendedorController {
    @PostMapping("/vendedor/subirProductos") // Indica que este método responde a peticiones POST a la ruta /vendedor/subirProductos
public String subirProductos(@RequestParam("id") String id, // Recibe el id del vendedor como parámetro en la petición
                             @RequestParam("nombre") String nombre, // Recibe el nombre del producto como parámetro en la petición
                             @RequestParam("descripcion") String descripcion, // Recibe la descripción del producto como parámetro en la petición
                             @RequestParam("precio") double precio, // Recibe el precio del producto como parámetro en la petición
                             @RequestParam("stock") int stock, // Recibe el stock del producto como parámetro en la petición
                             @RequestParam("foto") Blob foto,
                             HttpSession session) { // Recibe la sesión HTTP actual como parámetro

// Para los productos tambien hay una foto pero no sabemos como añadrila.

    // Obtener el objeto Vendedor asociado a esta sesión
    Vendedor vendedor = (Vendedor) session.getAttribute("vendedor");

    // Verificar que el vendedor es válido y su ID coincide con el proporcionado en la petición
    if (vendedor != null && vendedor.getId().equals(id)) {

        // Crear el producto a partir de los parámetros recibidos
        Producto producto = new Producto(nombre, stock, precio, foto, descripcion);

        // Agregar el producto al catálogo del vendedor
        String[] catalogo = vendedor.isCatalogo();
        String[] nuevoCatalogo = Arrays.copyOf(catalogo, catalogo.length + 1); // Crear una copia del catálogo con una longitud mayor
        nuevoCatalogo[nuevoCatalogo.length - 1] = producto.getNombre(); // Añadir el nuevo producto al final del catálogo
        vendedor.setCatalogo(nuevoCatalogo); // Establecer el nuevo catálogo en el objeto Vendedor

        // Guardar el objeto Vendedor actualizado en la sesión
        session.setAttribute("vendedor", vendedor);

        // Retornar la vista del catálogo actualizado del vendedor
        return "vendedor/catalogo";
    } else {
        // Si el vendedor no es válido o el ID no coincide, redirigir a la página de inicio de sesión
        return "redirect:/login";
    }
}
}
