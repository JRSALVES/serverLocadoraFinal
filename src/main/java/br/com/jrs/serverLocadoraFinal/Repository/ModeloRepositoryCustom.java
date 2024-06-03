package br.com.jrs.serverLocadoraFinal.Repository;

import br.com.jrs.serverLocadoraFinal.Model.DTO.ModeloDTO;
import br.com.jrs.serverLocadoraFinal.Model.Entity.Fabricante;
import br.com.jrs.serverLocadoraFinal.Model.Entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ModeloRepositoryCustom {

    @Autowired
    JdbcClient jdbcClient;

    /**
     * Mapeando modelo
     */
    RowMapper<ModeloDTO> modeloDTORowMapper = (rs, rowNum) -> {
        ModeloDTO modeloDTO = new ModeloDTO();
        modeloDTO.setId(rs.getLong("id"));
        modeloDTO.setNome(rs.getString("nome"));

        Fabricante fabricante = new Fabricante();
        fabricante.setId(rs.getLong("fabricante_id"));
        fabricante.setNome(rs.getString("nome"));
        modeloDTO.setFabricante(fabricante);

        return modeloDTO;
    };

    public List<ModeloDTO> getAll() {
        return jdbcClient
                .sql("SELECT * FROM modelo")
                .query(modeloDTORowMapper)
                .list();
    }

    public Optional<ModeloDTO> getById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM modelo WHERE id =:id")
                .param("id", id)
                .query(modeloDTORowMapper)
                .optional();
    }

    public Integer create(Modelo modelo) {
        return jdbcClient
                .sql("INSERT INTO fabricante (id, nome, fabricante_id) VALUES (:id, :nome, :fabricante_id)")
                .param("id", modelo.getId())
                .param("nome", modelo.getNome())
                .param("fabricante_id", modelo.getIdFabricante())
                .update();
    }

    public Integer update(Modelo modelo) {
        return jdbcClient
                .sql("UPDATE fabricante SET nome = :nome, fabricante_id = :fabricante_id WHERE id = :id")
                .param("id", modelo.getId())
                .param("nome", modelo.getNome())
                .param("fabricante_id", modelo.getIdFabricante())
                .update();
    }

    public Integer delete(Long id) {
        return jdbcClient
                .sql("DELETE FROM modelo WHERE id = :id")
                .param("id", id)
                .update();
    }
}

