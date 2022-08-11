package com.udemy.msclient.domain.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveClientRequest {
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String email;
}
