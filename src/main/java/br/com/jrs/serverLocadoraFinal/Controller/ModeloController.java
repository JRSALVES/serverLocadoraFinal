package br.com.jrs.serverLocadoraFinal.Controller;

import br.com.jrs.serverLocadoraFinal.Model.DTO.ModeloDTO;
import br.com.jrs.serverLocadoraFinal.Model.Entity.Modelo;
import br.com.jrs.serverLocadoraFinal.Service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService service;

    @GetMapping
    public ResponseEntity<List<ModeloDTO>> getAll() {
        List<ModeloDTO> modelos = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> getById(@PathVariable Long id) {
        Optional<ModeloDTO> modelo = service.getById(id);
        return modelo.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Modelo modelo) {
        try {
            service.insert(modelo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Modelo inserido com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao inserir Modelo: " + ex.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody Modelo modelo) {

        try {
            service.update(modelo);

            return ResponseEntity.ok().body("Modelo atualizado com sucesso!");

        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao atualizar Modelo: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            service.deleteById(Math.toIntExact(id));
            return ResponseEntity.ok().body("Modelo deletado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao deletar Modelo: " + ex.getMessage());
        }
    }
}
