package br.com.jrs.serverLocadoraFinal.Service;

import br.com.jrs.serverLocadoraFinal.Filter.ClienteFilter;
import br.com.jrs.serverLocadoraFinal.Model.DTO.ClienteDTO;
import br.com.jrs.serverLocadoraFinal.Model.Entity.Cliente;
import br.com.jrs.serverLocadoraFinal.Repository.ClienteRepository;
import br.com.jrs.serverLocadoraFinal.Repository.ClienteRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceCuston {

    @Autowired
    ClienteRepository repository;

    @Autowired
    ClienteRepositoryCustom repositoryCustom;

    public List<ClienteDTO> findAllCliente(ClienteFilter filtro) {
        return repositoryCustom.findAllClientes(filtro);
    }


    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }


    public void update(Cliente cliente) {
        Cliente cliente1 = repository.findById(cliente.getId()).orElseThrow(() ->
                new RuntimeException("Cliente não existe"));

        cliente1.setNome(cliente.getNome());
        cliente1.setId(cliente.getId());
        cliente1.setRg(cliente.getRg());
        cliente1.setCpf(cliente.getCpf());
        cliente1.setCnh(cliente.getCnh());
        cliente1.setCnhVencimento(cliente.getCnhVencimento());
        cliente1.setEmail(cliente.getEmail());
        cliente1.setTelefone(cliente.getTelefone());
        cliente1.setIdEndereco(cliente.getIdEndereco());

        repository.save(cliente1);
    }

    public void deleteById(Integer id) {
        repository.deleteById(Long.valueOf(id));
    }

}

