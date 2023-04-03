package es.upm.dit.isst.repository;
import es.upm.dit.isst.model.Pedido;
import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, String> {

    List<Pedido> findByNumId(String id);

}