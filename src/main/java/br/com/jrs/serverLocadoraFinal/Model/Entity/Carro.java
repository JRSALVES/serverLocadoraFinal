package br.com.jrs.serverLocadoraFinal.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    @Id
    private Long id;
    private Long idFabricante;
    private Long idModelo;
    private Long ano;
    private String cor;
    private String placa;
    private Double valorlocacao;
    private Boolean disponivel;

}


