package es.upm.dit.isst.repository;
import es.upm.dit.isst.model.Comprador;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CompradorRepository extends CrudRepository<Comprador, String> {

    List<Comprador> findByEmail(String email);

}
