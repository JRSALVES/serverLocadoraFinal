package br.com.jrs.serverLocadoraFinal.Model.DTO;

import br.com.jrs.serverLocadoraFinal.Model.Entity.Carro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private Timestamp cnhVencimento;
    private String email;
    private String telefone;
    private Long enderecoId;
    private List<CarroDTO> carros;
}
