package br.com.jrs.serverLocadoraFinal.Service;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Fabricante;
import br.com.jrs.serverLocadoraFinal.Repository.FabricanteRepository;
import br.com.jrs.serverLocadoraFinal.Repository.FabricanteRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    FabricanteRepository repository;

    @Autowired
    FabricanteRepositoryCustom fabricanteRepositoryCustom;

    public List<Fabricante> getAll(){
        return fabricanteRepositoryCustom.getAll();
    }

    public Optional<Fabricante> getById(Long id) {
        return fabricanteRepositoryCustom.getById(id);
    }

    public void insert(String nome){
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(nome);
        fabricanteRepositoryCustom.create(fabricante);
    }

    public void update(Fabricante fabricante){
        Fabricante fabricanteBanco = repository.findById(fabricante.getId()).orElseThrow(
                () -> new RuntimeException("Fabricante não encontrado!")
        );

        fabricanteBanco.setNome(fabricante.getNome());

        repository.save(fabricanteBanco);

    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
