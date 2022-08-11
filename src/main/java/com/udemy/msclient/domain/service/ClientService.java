package com.udemy.msclient.domain.service;

import com.udemy.msclient.domain.model.request.GetClientRequest;
import com.udemy.msclient.domain.model.request.GetClientsRequest;
import com.udemy.msclient.domain.model.request.SaveClientRequest;
import com.udemy.msclient.domain.model.response.GetClientResponse;
import com.udemy.msclient.domain.model.response.GetClientsResponse;
import com.udemy.msclient.domain.model.response.SaveClientResponse;

public interface ClientService {
    GetClientsResponse GetClients();
    SaveClientResponse SaveClient(SaveClientRequest client);
    GetClientResponse GetClientByID(Long idClient);
}
