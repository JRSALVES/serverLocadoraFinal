package br.com.jrs.serverLocadoraFinal.Repository;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Seguradora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguradoraRepository extends CrudRepository<Seguradora, Long> {
}
