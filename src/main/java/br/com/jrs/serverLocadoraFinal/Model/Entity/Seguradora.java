package br.com.jrs.serverLocadoraFinal.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguradora {

    @Id
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private Double valor;
    private String telefone;
    private Long idEndereco;
}
