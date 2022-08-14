package com.udemy.msclient.application;


import com.udemy.msclient.domain.model.request.SaveClientRequest;
import com.udemy.msclient.domain.model.request.UpdateClientRequest;
import com.udemy.msclient.domain.model.response.GetClientResponse;
import com.udemy.msclient.domain.model.response.GetClientsResponse;
import com.udemy.msclient.domain.model.response.SaveClientResponse;
import com.udemy.msclient.domain.model.response.UpdateClientResponse;
import com.udemy.msclient.domain.service.ClientService;
import com.udemy.msclient.infrastructure.entity.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    public GetClientsResponse GetClients(){

        log.info("GetClient");
        return clientService.GetClients();
    }

    @GetMapping("/{idClient}")
    public GetClientResponse GetClient(@PathVariable Long idClient){
        log.info("GetClient por id");
        return clientService.GetClientByID(idClient);
    }

    @PostMapping
    public SaveClientResponse SaveClient(@RequestBody SaveClientRequest client){
        return  clientService.SaveClient(client);
    }

    @PutMapping
    public UpdateClientResponse UpdateClient(@RequestBody UpdateClientRequest clientRequest){
        log.info("update CLient");
        return clientService.UpdateClient(clientRequest);
    }
}
