package com.api.cakeShop.Controllers;

import com.api.cakeShop.Models.Clients;
import com.api.cakeShop.Services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    @PostMapping
    public ResponseEntity<?> PostClients( @Valid @RequestBody Clients req){
        clientsService.PostClient(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
