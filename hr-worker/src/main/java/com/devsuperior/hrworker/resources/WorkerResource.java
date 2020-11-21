package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repo;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repo.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) throws InterruptedException {

        // Com isso o microservice deve retornar o getPaymentAlternative configurado no @HystrixCommand(fallbackMethod = "getPaymentAlternative")

        // Para simulara um error de timeout com 5 segundos
        // Por padrão o tempo do Ribbon é 1 segundo
        // O Ribbon nem era o tempo de 5 segundos, assim que o seu tempo padrão é excedido ele já retorna o getPaymentAlternative
        Thread.sleep(5000L);

        // Para simulara um erro qualquer
        throw new RuntimeException("Criar uma excption aqui só para simulara um error");

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker obj = repo.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
