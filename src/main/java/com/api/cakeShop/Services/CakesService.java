package com.api.cakeShop.Services;

import com.api.cakeShop.Controllers.Dto.CakesDto;
import com.api.cakeShop.Middlewares.ErrorHandler400;
import com.api.cakeShop.Middlewares.ErrorHandler404;
import com.api.cakeShop.Middlewares.ErrorHandler409;
import com.api.cakeShop.Models.Cakes;
import com.api.cakeShop.Models.Flavours;
import com.api.cakeShop.Repositories.CakesRepository;
import com.api.cakeShop.Repositories.FlavoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CakesService {

    @Autowired
    CakesRepository cakesRepository;

    @Autowired
    FlavoursRepository flavoursRepository;

    public void PostCakes(CakesDto req) throws ErrorHandler400, ErrorHandler409, ErrorHandler404 {
        if(req.getName().length() < 2){
            throw new ErrorHandler400("400", "Nome do bolo deve conter no mínimo 2 caracteres");
        }

        Cakes cake = cakesRepository.findByName(req.getName());
        if(cake != null){
            throw new ErrorHandler409("409", "Nome de bolo já cadastrado");
        }

        if(req.getPrice() <= 0){
            throw new ErrorHandler400("400", "Preço deve ser maior do que zero");
        }

        Flavours flavour = flavoursRepository.findById(req.getFlavourId());
        if(flavour == null){
            throw new ErrorHandler404("404", "Sabor de bolo não cadastrado");
        }

        Cakes newCake = new Cakes();

        newCake.setName(req.getName());
        newCake.setDescription(req.getDescription());
        newCake.setPrice(req.getPrice());
        newCake.setFlavours(flavour);

        cakesRepository.save(newCake);

    }


}
