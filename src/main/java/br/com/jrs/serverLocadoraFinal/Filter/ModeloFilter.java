package br.com.jrs.serverLocadoraFinal.Filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.Map;

@Data
@NoArgsConstructor
@FieldNameConstants
public class ModeloFilter {

    private String nome;

    private Integer idFabricante;

    public ModeloFilter(Map<String, String> parametros) {
        parametros.forEach((chave, valor) -> {
            switch (chave) {
                case ModeloFilter.Fields.nome:
                    nome = valor;
                    break;
                case ModeloFilter.Fields.idFabricante:
                    idFabricante = Integer.valueOf(valor);
                    break;
            }
        });
    }
}