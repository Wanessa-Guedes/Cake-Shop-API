package com.api.cakeShop.Controllers;

import com.api.cakeShop.Controllers.Dto.ClientOrdersDto;
import com.api.cakeShop.Middlewares.ErrorHandler404;
import com.api.cakeShop.Models.Clients;
import com.api.cakeShop.Services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/{id}/order")
    public ResponseEntity<List<ClientOrdersDto>> GetClientOrder(@PathVariable(value = "id")
                                                                    long id) throws ErrorHandler404 {
            List<ClientOrdersDto> clientOrders = clientsService.GetClientOrders(id);

            return ResponseEntity.status(HttpStatus.OK).body(clientOrders);
    }

}
