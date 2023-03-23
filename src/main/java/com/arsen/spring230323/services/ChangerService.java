package com.arsen.spring230323.services;

import com.arsen.spring230323.dto.CurrencyModel;
import com.arsen.spring230323.dto.CurrencyRatesModel;
import com.arsen.spring230323.enums.CurrencyType;
import com.arsen.spring230323.repositories.ChangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChangerService {
    private final ChangerRepository changerRepository;
    private final CurrencyRatesService currencyRatesService;

    @Autowired
    public ChangerService(ChangerRepository changerRepository, CurrencyRatesService currencyRatesService) {
        this.changerRepository = changerRepository;
        this.currencyRatesService = currencyRatesService;
    }

    public BigDecimal change(String currency, BigDecimal amount) throws Exception {
        CurrencyType currencyType = CurrencyType.valueOf(currency.toUpperCase());
        CurrencyRatesModel model = currencyRatesService.getModelFromApi();
        for (CurrencyModel currencyModel : model.getCurrencyModelList()) {
            if (currencyModel.getIsoCode().equals(currencyType))
                return currencyModel.getValue().multiply(amount).setScale(2, RoundingMode.FLOOR);
        }
        return new BigDecimal(0);
    }

    public List<String> getCurrencies() throws Exception {
        List<String> list = new ArrayList<>();
        CurrencyRatesModel model = currencyRatesService.getModelFromApi();
        for(CurrencyModel currencyModel : model.getCurrencyModelList()) {
            list.add(currencyModel.getIsoCode() + " " + currencyModel.getValue() + "\n");
        }

        return list;
    }

}
