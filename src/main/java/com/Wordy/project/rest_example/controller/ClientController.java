package com.Wordy.project.rest_example.controller;

import com.Wordy.project.rest_example.Query1;
import com.Wordy.project.rest_example.model.Client;
import com.Wordy.project.rest_example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
// говорит спрингу, что данный класс является REST контроллером. Т.е. в данном классе будет логика обработки клиентских запросов
public class ClientController {

    private final ClientService clientService;

    @Autowired //говорит спрингу, что в этом месте нужно внедрить зависимость
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

//    @PostMapping(value = "/clients") //обрабатывает POST запросы на адресс /clients
//    public ResponseEntity<?> create(@RequestBody Client client) {
//        clientService.create(client);
//        return new ResponseEntity<>(HttpStatus.CREATED); //ResponseEntity — специальный класс для возврата ответов.
//        // С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
//    }

//    @GetMapping(value = "/clients")  //Get запросы по адресу /clients
//    public ResponseEntity<List<Client>> read() {
//        final List<Client> clients = clientService.readAll();
//
//        return clients != null && !clients.isEmpty()
//                ? new ResponseEntity<>(clients, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/clients/{id}")
//    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) {
//        final Client client = clientService.read(id);
//
//        return client != null
//                ? new ResponseEntity<>(client, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping(value = "/clients/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client client) {
//        final boolean updated = clientService.update(client, id);
//
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
// }

    @GetMapping(value = "/hui/{hui}")
    public String huui(@PathVariable(name = "hui") String query) {

        String query1 = "SELECT * FROM users";
        return Query1.queryAll(query1);


    }

//    @DeleteMapping(value = "/clients/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
//        final boolean deleted = clientService.delete(id);
//
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

//}
