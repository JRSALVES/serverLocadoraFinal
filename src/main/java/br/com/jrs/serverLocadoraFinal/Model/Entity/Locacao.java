package br.com.jrs.serverLocadoraFinal.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locacao {

    @Id
    private Long id;
    private Long idSeguradora;
    private Long idCarro;
    private Long idCliente;
    private Timestamp dataLocacao;
    private Timestamp dataDevolucao;
    private Timestamp dataDevolvida;
    private Double valorDesconto;
    private Double valor;
    private Double valorTotal;

    }
