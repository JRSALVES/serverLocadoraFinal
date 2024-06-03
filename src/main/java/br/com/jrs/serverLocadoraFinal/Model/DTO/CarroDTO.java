package br.com.jrs.serverLocadoraFinal.Model.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {
    private Long id;

    private ModeloDTO modelo;

    private String placa;

    private String cor;

    private boolean disponivel;

    private Long ano;
}
