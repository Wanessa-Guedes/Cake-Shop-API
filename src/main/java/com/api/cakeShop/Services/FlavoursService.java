package com.api.cakeShop.Services;

import com.api.cakeShop.Controllers.Dto.PostFlavourDto;
import com.api.cakeShop.Middlewares.ErrorHandler404;
import com.api.cakeShop.Middlewares.ErrorHandler409;
import com.api.cakeShop.Models.Flavours;
import com.api.cakeShop.Repositories.FlavoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlavoursService {

    @Autowired
    FlavoursRepository flavoursRepository;

    public void PostFlavour(PostFlavourDto req) throws ErrorHandler409 {
        Flavours flavour = flavoursRepository.findByName(req.getName());
        if(flavour != null){
            throw new ErrorHandler409("409", "Sabor já cadastrado");
        }
        Flavours newFlavour = new Flavours();
        newFlavour.setName(req.getName());
        flavoursRepository.save(newFlavour);
    }
}
