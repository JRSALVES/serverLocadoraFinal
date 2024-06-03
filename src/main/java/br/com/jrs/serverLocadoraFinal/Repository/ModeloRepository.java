package br.com.jrs.serverLocadoraFinal.Repository;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Modelo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends CrudRepository<Modelo, Long>{

    @Override
    List<Modelo> findAll();


    @Modifying
    @Query("DELETE FROM modelo WHERE id = :?")
    void deleteById(@Param("?")Integer id);
}
