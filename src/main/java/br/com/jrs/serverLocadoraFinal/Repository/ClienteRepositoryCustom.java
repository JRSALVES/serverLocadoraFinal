package br.com.jrs.serverLocadoraFinal.Repository;

import br.com.jrs.serverLocadoraFinal.Filter.ClienteFilter;
import br.com.jrs.serverLocadoraFinal.Model.DTO.ClienteDTO;
import br.com.jrs.serverLocadoraFinal.Model.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ClienteRepositoryCustom {

    @Autowired
    private JdbcClient jdbcClient;

    private final RowMapper<ClienteDTO> clienteDTORowMapper = (rs, rowNum) -> {
//
//        Fabricante fabricante = new Fabricante();
//        fabricante.setId(rs.getLong("fabricante_id"));
//        fabricante.setNome(rs.getString("fabricante_nome"));
//
//        ModeloDTO modeloDTO = new ModeloDTO();
//        modeloDTO.setId(rs.getLong("modelo_id"));
//        modeloDTO.setNome(rs.getString("modelo_nome"));
//        modeloDTO.setFabricante(fabricante);
//
//
//        CarroDTO carroDTO = new CarroDTO();
//        carroDTO.setId(rs.getLong("carro_id"));
//        carroDTO.setPlaca(rs.getString("placa"));
//        carroDTO.setCor(rs.getString("cor"));
//        carroDTO.setDisponivel(rs.getBoolean("disponivel"));
//        carroDTO.setAno(rs.getLong("ano"));
//        carroDTO.setModelo(modeloDTO);


        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(rs.getLong("id"));
        clienteDTO.setNome(rs.getString("nome"));
        clienteDTO.setRg(rs.getString("rg"));
        clienteDTO.setCpf(rs.getString("cpf"));
        clienteDTO.setCnh(rs.getString("cnh"));
        clienteDTO.setCnhVencimento(rs.getTimestamp("cnh_vencimento"));
        clienteDTO.setEmail(rs.getString("email"));
        clienteDTO.setTelefone(rs.getString("telefone"));
        clienteDTO.setEnderecoId(rs.getLong("endereco_id"));

//        List<CarroDTO> carros = new ArrayList<>();
//        carros.add(carroDTO);
//        clienteDTO.setCarros(carros);

        return clienteDTO;
    };

    public List<ClienteDTO> findAllClientes(ClienteFilter filter) {
        StringJoiner where = new StringJoiner(" AND ");

        Map<String, Object> params = new HashMap<>();

        if (filter.getIdCliente() != null) {
            where.add("cl.cliente_id = :idCliente");
            params.put("idCliente", filter.getIdCliente());
        }

        if (filter.getNome() != null) {
            where.add("cl.nome = :nome");
            params.put("nome", filter.getNome());
        }

        if (filter.getRg() != null) {
            where.add("cl.rg = :rg");
            params.put("rg", filter.getRg());
        }

        if (filter.getCpf() != null) {
            where.add("cl.ano = :ano");
            params.put("ano", filter.getCpf());
        }

        if (filter.getEmail() != null) {
            where.add("cl.email = :email");
            params.put("email", filter.getEmail());
        }

        if (filter.getCnh() != null) {
            where.add("cl.cnh = :cnh");
            params.put("cnh", filter.getCnh());
        }

        if (filter.getCnhVencimento() != null) {
            where.add("cl.cnh_vencimento = :cnhVencimento");
            params.put("cnhVencimento", filter.getCnhVencimento());
        }

        if (filter.getTelefone() != null) {
            where.add("cl.telefone = :telefone");
            params.put("telefone", filter.getTelefone());
        }

        if (filter.getEnderecoId() != null) {
            where.add("cl.endereco_id = :endercoId");
            params.put("endercoId", filter.getEnderecoId());
        }


        String sql = """
                SELECT cl.id as id, cl.nome, cl.rg, cl.cpf, cl.cnh, cl.cnh_vencimento, cl.email, cl.telefone, cl.endereco_id                     
                FROM cliente cl
            """;

        return jdbcClient.sql(sql)
                .params(params)
                .query(clienteDTORowMapper)
                .list();
    }



public boolean checarExistenciaClientePorID(Integer idCliente) {
        return jdbcClient
                .sql("SELECT EXISTS(SELECT 1 FROM cliente WHERE id = :idCliente)")
                .param("idCliente", idCliente)
                .query(Boolean.class)
                .single();
    }

    public Integer insert(Cliente cliente) {
        String querySql = "INSERT INTO public.cliente (nome,rg,cpf,cnh,cnh_vencimento, email telefone, endereco_id) " +
                " VALUES (:nome,:rg,:cpf,:cnh,:cnhVencimento, email, telefone, enderecoId);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql(querySql)
                .param("nome", cliente.getNome())
                .param("rg", cliente.getRg())
                .param("cpf", cliente.getCpf())
                .param("cnh", cliente.getCnh())
                .param("cnhVemcimento", cliente.getCnhVencimento())
                .param("email", cliente.getEmail())
                .param("telefone", cliente.getTelefone())
                .param("enderecoId", cliente.getIdEndereco())
                .update(keyHolder, "id");

        return keyHolder.getKeyAs(Integer.class);
    }

    public Integer update(Cliente cliente) {
        String querySql = """
                UPDATE public.cliente
                	SET nome=:nome,rg=:rg,cpf=:cpf,cnh=:cnh,cnh_vencimento=:cnhVencimento, email=:email, telefone=:telefone, endereco_id=:enderecoId
                	WHERE id=:idCliente;
                """;

        return jdbcClient.sql(querySql)
                .param("nome", cliente.getNome())
                .param("rg", cliente.getRg())
                .param("cpf", cliente.getCpf())
                .param("cnh", cliente.getCnh())
                .param("cnhVemcimento", cliente.getCnhVencimento())
                .param("email", cliente.getEmail())
                .param("telefone", cliente.getTelefone())
                .param("enderecoId", cliente.getIdEndereco())
                .update();
    }

    public Integer deletarCarro(Integer idCliente) {
        String querySql = "DELETE FROM public.cliente WHERE id=:idCliente;";

        return jdbcClient.sql(querySql)
                .param("idCliente", idCliente)
                .update();
    }

}
