package com.udemy.msclient.domain.service;


import com.udemy.msclient.common.Constants;
import com.udemy.msclient.domain.model.request.GetClientRequest;
import com.udemy.msclient.domain.model.request.GetClientsRequest;
import com.udemy.msclient.domain.model.request.SaveClientRequest;
import com.udemy.msclient.domain.model.request.UpdateClientRequest;
import com.udemy.msclient.domain.model.response.GetClientResponse;
import com.udemy.msclient.domain.model.response.GetClientsResponse;
import com.udemy.msclient.domain.model.response.SaveClientResponse;
import com.udemy.msclient.domain.model.response.UpdateClientResponse;
import com.udemy.msclient.infrastructure.entity.Client;
import com.udemy.msclient.infrastructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public GetClientsResponse GetClients() {
        GetClientsResponse response = new GetClientsResponse();
        List<Client> clients = ((List<Client>) clientRepository.findAll()).stream().filter(client -> client.getStatus().equals("1")).collect(Collectors.toList());
        if (clients != null && !clients.isEmpty()) {
            response.setResponseStatus(Constants.SUCCESS_CODE);
            response.setMessageStatus(Constants.SUCCESS_MESSAGE);
            response.setClients(clients);
        }else {
            response.setResponseStatus(Constants.NO_DATA_CODE);
            response.setMessageStatus(Constants.NO_DATA_MESSAGE);
        }
        return response;
    }

    @Override
    public SaveClientResponse SaveClient(SaveClientRequest client) {
        SaveClientResponse response = new SaveClientResponse();
        try {
            Client request =new Client();
            request.setName(client.getName());
            request.setLastName(client.getLastName());
            request.setPhone(client.getPhone());
            request.setAddress(client.getAddress());
            request.setEmail(client.getEmail());
            Date fecha = new Date();
            request.setCreateAt(fecha);
            request.setStatus(Constants.ONE_STRING);
            response.setResponseStatus(Constants.SUCCESS_CODE);
            response.setMessageStatus(Constants.SUCCESS_MESSAGE);
            response.setClient(clientRepository.save(request));
        }catch (Exception e){
            response.setResponseStatus(Constants.ERROR_CODE);
            response.setMessageStatus(Constants.ERROR_MESSAGE + e.getMessage());
        }
        return response;
    }

    @Override
    public GetClientResponse GetClientByID(Long  idClient){
        GetClientResponse clientResponse = new GetClientResponse();
        try{
            Client client = clientRepository.findById(idClient).orElse(null);
            if (client != null) {
                clientResponse.setResponseStatus(Constants.SUCCESS_CODE);
                clientResponse.setMessageStatus(Constants.SUCCESS_MESSAGE);
                clientResponse.setClient(client);
            }else {
                clientResponse.setResponseStatus(Constants.NO_DATA_CODE);
                clientResponse.setMessageStatus(Constants.NO_DATA_MESSAGE);
            }
        }catch (Exception e){
            clientResponse.setResponseStatus(Constants.ERROR_CODE);
            clientResponse.setMessageStatus(Constants.ERROR_MESSAGE + e.getMessage());
        }
        return clientResponse;
    }

    @Override
    public UpdateClientResponse UpdateClient( UpdateClientRequest clientRequest) {
        UpdateClientResponse response = new UpdateClientResponse();
        try {
            Client request =new Client();
            request.setIdClient(clientRequest.getIdClient());
            request.setName(clientRequest.getName());
            request.setLastName(clientRequest.getLastName());
            request.setPhone(clientRequest.getPhone());
            request.setAddress(clientRequest.getAddress());
            request.setEmail(clientRequest.getEmail());
            request.setStatus(Constants.ONE_STRING);
            response.setClient(clientRepository.save(request));
            response.setResponseStatus(Constants.SUCCESS_CODE);
            response.setMessageStatus(Constants.SUCCESS_MESSAGE);
        }catch (Exception e){
            response.setResponseStatus(Constants.ERROR_CODE);
            response.setMessageStatus(Constants.ERROR_MESSAGE + e.getMessage());
        }
        return response;
    }
}
