package com.udemy.msclient.domain.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientRequest {
    private Long idClient;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String email;
}
