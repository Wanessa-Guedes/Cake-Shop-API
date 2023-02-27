package com.api.cakeShop.Controllers;

import com.api.cakeShop.Controllers.Dto.CakesDto;
import com.api.cakeShop.Middlewares.ErrorHandler400;
import com.api.cakeShop.Middlewares.ErrorHandler409;
import com.api.cakeShop.Models.Cakes;
import com.api.cakeShop.Services.CakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cakes")
public class CakesController {

    @Autowired
    CakesService cakesService;

    @PostMapping
    public ResponseEntity<?> PostCakes(@RequestBody CakesDto req) throws ErrorHandler400, ErrorHandler409 {
        cakesService.PostCakes(req);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
