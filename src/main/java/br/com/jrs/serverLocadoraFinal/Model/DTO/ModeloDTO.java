package br.com.jrs.serverLocadoraFinal.Model.DTO;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Fabricante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDTO {
    private Long id;

    private String nome;

    private Fabricante fabricante;
}
