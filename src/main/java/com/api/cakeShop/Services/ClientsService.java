package com.api.cakeShop.Services;

import com.api.cakeShop.Controllers.Dto.ClientOrdersDto;
import com.api.cakeShop.Middlewares.ErrorHandler404;
import com.api.cakeShop.Models.Clients;
import com.api.cakeShop.Models.Orders;
import com.api.cakeShop.Repositories.ClientsRepository;
import com.api.cakeShop.Repositories.OrdersRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    @Autowired
    OrdersRepository ordersRepository;

    public void PostClient(Clients req){
        clientsRepository.save(req);
    }

    public List<ClientOrdersDto> GetClientOrders(long id) throws ErrorHandler404 {
        Clients client = clientsRepository.findById(id);
        if(client == null){
            throw new ErrorHandler404("404", "Não há clientes cadastrados");
        }

        List<Orders> orders = ordersRepository.findAllByClientsId(id);
        List<ClientOrdersDto> clientOrdersDtos = new ArrayList<>();

        orders.forEach(order -> {
            ClientOrdersDto clientOrder = new ClientOrdersDto();
            clientOrder.setOrderId(order.getId());
            clientOrder.setQuantity(order.getQuantity());
            clientOrder.setCreatedAt(order.getCreatedAt());
            clientOrder.setTotalPrice(order.getTotalPrice());
            clientOrder.setCakeName(order.getCakes().getName());
            clientOrdersDtos.add(clientOrder);
        });

        return clientOrdersDtos;

    }

}
