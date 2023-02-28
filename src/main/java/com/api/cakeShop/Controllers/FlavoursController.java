package com.api.cakeShop.Controllers;

import com.api.cakeShop.Controllers.Dto.PostFlavourDto;
import com.api.cakeShop.Middlewares.ErrorHandler409;
import com.api.cakeShop.Services.FlavoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flavours")
public class FlavoursController {

    @Autowired
    FlavoursService flavoursService;

    @PostMapping
    public ResponseEntity<?> PostFlavour(@RequestBody PostFlavourDto req) throws ErrorHandler409 {
        flavoursService.PostFlavour(req);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
