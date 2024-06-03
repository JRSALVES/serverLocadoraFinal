package br.com.jrs.serverLocadoraFinal.Controller;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Fabricante;
import br.com.jrs.serverLocadoraFinal.Service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/fabricante")
public class FabricanteController {

    @Autowired
    FabricanteService service;

    @GetMapping
    public ResponseEntity<List<Fabricante>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Fabricante>> getById(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Fabricante fabricante){
        try{
            service.insert(fabricante.getNome());

            return ResponseEntity.status(HttpStatus.CREATED).body("Fabricante inserido com sucesso!");

        }catch(Exception ex){
            return ResponseEntity.internalServerError().body("Erro ao inserir Fabricante!");
        }
    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody Fabricante fabricante){
        try{
            service.update(fabricante);

            return ResponseEntity.ok().body("Fabricante atualizado com sucesso!");

        }catch(Exception ex){
            return ResponseEntity.internalServerError().body("Erro ao atualizar Fabricante: " +ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id){
        try{
            service.deleteById(id);

            return ResponseEntity.ok().body("Fabricante deletado com sucesso!");

        }catch(Exception ex){
            return ResponseEntity.internalServerError().body("Erro ao deletar Fabricante: " + ex.getMessage());
        }
    }
}
