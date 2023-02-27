package com.api.cakeShop.Services;

import com.api.cakeShop.Models.Clients;
import com.api.cakeShop.Repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    public void PostClient(Clients req){
        clientsRepository.save(req);
    }

}
