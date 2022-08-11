package com.udemy.msclient.infrastructure.repository;


import com.udemy.msclient.infrastructure.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository  extends CrudRepository<Client, Long> {
    Client findByName(String name);
}
