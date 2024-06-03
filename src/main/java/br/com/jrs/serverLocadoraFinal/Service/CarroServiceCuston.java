package br.com.jrs.serverLocadoraFinal.Service;

import br.com.jrs.serverLocadoraFinal.Filter.CarroFilter;
import br.com.jrs.serverLocadoraFinal.Model.DTO.CarroDTO;
import br.com.jrs.serverLocadoraFinal.Repository.CarroRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceCuston {

    @Autowired
    CarroRepositoryCustom repositoryCuston;

    public List<CarroDTO> findAllCarro (CarroFilter filtro){
        return repositoryCuston.findAllCarro(filtro);
    }
}
