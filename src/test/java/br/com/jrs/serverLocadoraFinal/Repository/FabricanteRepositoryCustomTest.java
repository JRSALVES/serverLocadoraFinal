package br.com.jrs.serverLocadoraFinal.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FabricanteRepositoryCustomTest {

    @Autowired
    FabricanteRepositoryCustom fabricanteRepositoryCustom;

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(() -> fabricanteRepositoryCustom.getAll());

    }
}