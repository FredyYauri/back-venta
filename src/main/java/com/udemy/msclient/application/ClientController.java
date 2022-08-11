package com.udemy.msclient.application;


import com.udemy.msclient.domain.model.request.SaveClientRequest;
import com.udemy.msclient.domain.model.response.GetClientResponse;
import com.udemy.msclient.domain.model.response.GetClientsResponse;
import com.udemy.msclient.domain.model.response.SaveClientResponse;
import com.udemy.msclient.domain.service.ClientService;
import com.udemy.msclient.infrastructure.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    public GetClientsResponse GetClients(){
        return clientService.GetClients();
    }

    @GetMapping("/{idClient}")
    public GetClientResponse GetClient(@PathVariable Long idClient){
        return clientService.GetClientByID(idClient);
    }

    @PostMapping
    public SaveClientResponse SaveClient(@RequestBody SaveClientRequest client){
        return  clientService.SaveClient(client);
    }
}
