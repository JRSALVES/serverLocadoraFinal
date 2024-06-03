package br.com.jrs.serverLocadoraFinal.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {

    @Id
    private Long id;
    private String nome;
    private Long idFabricante;
}
