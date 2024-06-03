package br.com.jrs.serverLocadoraFinal.Repository;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FabricanteRepositoryCustom {

    @Autowired
    JdbcClient jdbcClient;

        RowMapper<Fabricante> fabricanteRowMapper = (rs, rowNum) -> {
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getLong("id"));
            fabricante.setNome(rs.getString("nome"));

            return fabricante;
        };

    public List<Fabricante> getAll() {
        return jdbcClient
                .sql("SELECT * FROM fabricante")
                .query(fabricanteRowMapper)
                .list();
    }

    public Optional<Fabricante> getById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM fabricante WHERE id =:id")
                .param("id", id)
                .query(fabricanteRowMapper)
                .optional();
    }

    public Integer create(Fabricante fabricante) {
        return jdbcClient
                .sql("INSERT INTO fabricante (id, nome) VALUES (:id, :nome)")
                .param("id", fabricante.getId())
                .param("nome", fabricante.getNome())
                .update();
    }

    public Integer update(Fabricante fabricante) {
        return jdbcClient
                .sql("UPDATE fabricante SET nome = :nome WHERE id = :id")
                .param("id", fabricante.getId())
                .param("nome", fabricante.getNome())
                .update();
    }

    public Integer delete(Long id){
        return delete(id);

    }
}

