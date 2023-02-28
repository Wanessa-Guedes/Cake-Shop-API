package com.api.cakeShop.Controllers;

import com.api.cakeShop.Controllers.Dto.PostOrdersDto;
import com.api.cakeShop.Middlewares.ErrorHandler400;
import com.api.cakeShop.Middlewares.ErrorHandler404;
import com.api.cakeShop.Models.Orders;
import com.api.cakeShop.Services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @PostMapping
    public ResponseEntity<?> PostOrder(@RequestBody PostOrdersDto req) throws ErrorHandler404, ErrorHandler400 {
        ordersService.PostOrder(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Orders>> GetOrders(@RequestParam(value = "date", required = false)
                                                          String date) throws ErrorHandler404 {
        Iterable<Orders> orders = ordersService.GetAllOrders(date);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
}
