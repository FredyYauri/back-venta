package com.udemy.msclient.domain.model.response;

import com.udemy.msclient.infrastructure.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientResponse {
    private String responseStatus;
    private String messageStatus;
    private Client client;
}
