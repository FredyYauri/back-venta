package com.udemy.msclient.domain.model.response;

import com.udemy.msclient.infrastructure.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetClientsResponse {
    private String responseStatus;
    private String messageStatus;
    private List<Client> clients;
}
