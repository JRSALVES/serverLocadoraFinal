package br.com.jrs.serverLocadoraFinal.Controller;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Carro;
import br.com.jrs.serverLocadoraFinal.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> getAll() {
        List<Carro> carros = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getById(@PathVariable Long id) {
        Optional<Carro> carro = service.getById(id);
        return carro.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Carro carro) {
        try {
            service.insert(carro); // Corrigido para passar um objeto Carro
            return ResponseEntity.status(HttpStatus.CREATED).body("Carro inserido com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao inserir Carro!");
        }
    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody Carro carro) {
        try {
            service.update(carro);
            return ResponseEntity.ok().body("Carro atualizado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao atualizar Carro!");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            service.deleteById(id); // Removido o casting desnecessário
            return ResponseEntity.ok().body("Carro deletado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao deletar Carro!");
        }
    }
}
