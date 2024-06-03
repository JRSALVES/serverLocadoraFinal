package br.com.jrs.serverLocadoraFinal.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteDTO {
    private Long id;

    private String nome;

    private Long idFabricante;
}