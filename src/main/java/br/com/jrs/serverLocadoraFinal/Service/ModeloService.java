package br.com.jrs.serverLocadoraFinal.Service;

import br.com.jrs.serverLocadoraFinal.Model.DTO.ModeloDTO;
import br.com.jrs.serverLocadoraFinal.Model.Entity.Modelo;
import br.com.jrs.serverLocadoraFinal.Repository.ModeloRepository;
import br.com.jrs.serverLocadoraFinal.Repository.ModeloRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository repository;

    @Autowired
    ModeloRepositoryCustom modeloRepositoryCustom;

    public List<ModeloDTO> getAll() {
        return modeloRepositoryCustom.getAll();
    }

    public Optional<ModeloDTO> getById(Long id) {
        return modeloRepositoryCustom.getById(id);
    }

    public Modelo insert(Modelo modelo) {
        return repository.save(modelo);
    }


    public void update(Modelo modelo) {
        Modelo modeloBanco = repository.findById(modelo.getId()).orElseThrow(
                () -> new RuntimeException("Modelo não encontrado!")
        );

        modeloBanco.setNome(modelo.getNome());
        modeloBanco.setIdFabricante(modelo.getIdFabricante());

        repository.save(modeloBanco);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
