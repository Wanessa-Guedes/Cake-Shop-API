package com.api.cakeShop.Services;

import com.api.cakeShop.Controllers.Dto.PostOrdersDto;
import com.api.cakeShop.Middlewares.ErrorHandler400;
import com.api.cakeShop.Middlewares.ErrorHandler404;
import com.api.cakeShop.Models.Cakes;
import com.api.cakeShop.Models.Clients;
import com.api.cakeShop.Models.Orders;
import com.api.cakeShop.Models.QOrders;
import com.api.cakeShop.Repositories.CakesRepository;
import com.api.cakeShop.Repositories.ClientsRepository;
import com.api.cakeShop.Repositories.OrdersRepository;
import com.querydsl.core.BooleanBuilder;
import org.aspectj.weaver.ast.Or;
import org.assertj.core.internal.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ClientsRepository clientsRepository;

    @Autowired
    CakesRepository cakesRepository;

    public void PostOrder(PostOrdersDto req) throws ErrorHandler404, ErrorHandler400 {
        Clients client = clientsRepository.findById(req.getClientId());
        if(client == null){
            throw new ErrorHandler404("404", "Cliente não cadastrado");
        }
        Cakes cake = cakesRepository.findById(req.getCakeId());
        if(cake == null){
            throw new ErrorHandler404("404", "Bolo não cadastrado");
        }

        if(req.getQuantity() <= 0 || req.getQuantity() >= 5){
            throw new ErrorHandler400("400", "Quantidade inválida");
        }
        Orders order = new Orders();
        order.setQuantity(req.getQuantity());
        order.setTotalPrice(req.getTotalPrice());
        order.setCreatedAt(Timestamp.valueOf(LocalDate.now().atStartOfDay()));
        order.setClients(client);
        order.setCakes(cake);

        ordersRepository.save(order);

    }


    public Iterable<Orders> GetAllOrders(String date) throws ErrorHandler404 {
        if(date != null){
            QOrders qOrders = QOrders.orders;
            BooleanBuilder builder = new BooleanBuilder();
            date = date + " 00:00:00";
            Timestamp infoDate = Timestamp.valueOf(date);
            builder.and(qOrders.createdAt.eq(infoDate));
            Iterable<Orders> orders = ordersRepository.findAll(builder);
            if(!orders.iterator().hasNext()){
                throw new ErrorHandler404("404", "Não há pedidos na data informada");
            }
            return orders;
        } else {
            List<Orders> orders = ordersRepository.findAll();
            if(orders.size() == 0){
                throw new ErrorHandler404("404", "Não há pedidos");
            }
            return orders;
        }
    }

    public Orders GetOrdersById(long id) throws ErrorHandler404 {
        Orders order = ordersRepository.findById(id);
        if(order == null){
            throw new ErrorHandler404("404", "Pedido não cadastrado");
        }
        return order;
    }

    public void PatchDeliveryOrder(long id) throws ErrorHandler404 {
        Orders orders = ordersRepository.findById(id);
        if(orders == null) {
            throw new ErrorHandler404("404", "Pedido não existente");
        }
        orders.setDelivered(true);
        ordersRepository.save(orders);
    }
}
