package br.com.jrs.serverLocadoraFinal.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ModeloServiceTest {

    @Autowired
    ModeloService modeloService;

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(() -> modeloService.getAll());
    }

    @Test
    void getById() {
        Assertions.assertDoesNotThrow(() -> modeloService.getAll());
    }

    @Test
    void insert() {
        Assertions.assertDoesNotThrow(() -> modeloService.getAll());
    }

    @Test
    void update() {
        Assertions.assertDoesNotThrow(() -> modeloService.getAll());
    }

    @Test
    void deleteById() {
        Assertions.assertDoesNotThrow(() -> modeloService.getAll());
    }
}