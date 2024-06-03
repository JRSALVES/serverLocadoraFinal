package br.com.jrs.serverLocadoraFinal.Repository;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
