package es.upm.dit.isst.repository;
import es.upm.dit.isst.model.Vendedor;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VendedorRepository extends CrudRepository<Vendedor, String> {
//Lo que hace el List, es generar una lista de vendedores, a partir de su email.
    List<Vendedor> findByNumId(String id);

}