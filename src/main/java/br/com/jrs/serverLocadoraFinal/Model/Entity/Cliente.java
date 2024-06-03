package br.com.jrs.serverLocadoraFinal.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private Timestamp cnhVencimento;
    private String email;
    private String telefone;
    private Long idEndereco;
}
