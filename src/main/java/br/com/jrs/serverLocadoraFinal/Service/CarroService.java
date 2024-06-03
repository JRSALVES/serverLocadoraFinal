package br.com.jrs.serverLocadoraFinal.Service;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Carro;
import br.com.jrs.serverLocadoraFinal.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

//    @Autowired
//    CarroRepositoryCuston carroRepositoryCuston;

    public List<Carro> getAll() {
        return repository.findAll();
    }

    public Optional<Carro> getById(Long id) {
        return repository.findById(id);
    }

    public void insert(Carro carro) {
        try {
            repository.save(carro);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao inserir Carro: " + ex.getMessage());
        }
    }

    public void  update(Carro carro){
        Carro carro1 = repository.findById(carro.getId()).orElseThrow(() ->
                new RuntimeException("Fabricante não encontrado!"));

        carro1.setIdFabricante(carro.getIdFabricante());
        carro1.setIdModelo(carro.getIdModelo());
        carro1.setCor(carro.getCor());
        carro1.setPlaca(carro.getPlaca());
        carro1.setDisponivel(carro.getDisponivel());
        carro1.setAno(carro.getAno());
        carro1.setValorlocacao(carro.getValorlocacao());

        repository.save(carro1);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    public Optional<Carro> findById(Carro carro) {
        return repository.findById(carro.getId());
    }

}

