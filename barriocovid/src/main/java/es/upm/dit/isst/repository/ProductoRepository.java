package es.upm.dit.isst.repository;
import es.upm.dit.isst.model.Producto;
import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, String> {

    List<Producto> findByNombre(String nombre);

}