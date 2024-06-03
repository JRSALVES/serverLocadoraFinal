package br.com.jrs.serverLocadoraFinal.Filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.sql.Timestamp;
import java.util.Map;

@Data
@NoArgsConstructor
@FieldNameConstants
public class ClienteFilter {

    private Integer idCliente;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private Timestamp cnhVencimento;
    private String email;
    private String telefone;
    private Long enderecoId;

    public ClienteFilter(Map<String, String> parametros) {
        parametros.forEach((chave, valor) -> {
            switch (chave) {
                case Fields.idCliente:
                    idCliente = Integer.valueOf(valor);
                    break;
                case ClienteFilter.Fields.nome:
                    nome = valor;
                    break;
                case ClienteFilter.Fields.rg:
                    rg = valor;
                    break;
                case ClienteFilter.Fields.cpf:
                    cpf = valor;
                    break;
                case Fields.email:
                    email = valor;
                    break;
                case ClienteFilter.Fields.cnh:
                    cnh = valor;
                    break;
                case Fields.cnhVencimento:
                    cnhVencimento = Timestamp.valueOf(valor);
                    break;
                case Fields.telefone:
                    telefone = valor;
                    break;
                case Fields.enderecoId:
                    enderecoId = Long.valueOf(valor);
                    break;
            }
        });
    }
}
