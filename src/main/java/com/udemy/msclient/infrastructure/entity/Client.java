package com.udemy.msclient.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date createAt;
    private String status;
    private static final long serialVersionUID = 1L;
}
