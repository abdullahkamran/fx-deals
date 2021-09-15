package com.assignment.fxdeals.core.fxdeal;

import java.util.List;
import java.util.Optional;


import com.assignment.fxdeals.exception.FxDealsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FxDealService {

    private final FxDealRepository fxDealRepository;

    public FxDealService(FxDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    public FxDeal get(String id) {
        Optional<FxDeal> fxDeal = fxDealRepository.findById(id);
        if (fxDeal.isEmpty()) {
            log.warn("GET /api/v1/fx-deals/{id} returned 404, where id: {}", id);
            throw new FxDealsException("404", "FX Deal not found!");
        }
        return fxDeal.get();
    }

    public List<FxDeal> getAll() {
        return fxDealRepository.findAll();
    }

    public FxDeal create(FxDealDto fxDealDto) {

        if (fxDealDto.getId() != null
                && fxDealRepository.findById(fxDealDto.getId()).isPresent()
        ) {
            log.warn("POST /api/v1/fx-deals/{id} returned 409, where id: {}", fxDealDto.getId());
            throw new FxDealsException("409", "FX Deal with this Unique ID already exists!");
        }
        if (!fxDealDto.validate()) {
            log.warn("POST /api/v1/fx-deals/{id} returned 400");
            throw new FxDealsException("400", "FX Deal fields not valid!");
        }

        return fxDealRepository.save(fxDealDto.generateEntity());
    }

//    public FxDeal update(String id, FxDealDto fxDealDto) {
//
//        if (!fxDealDto.validate()) {
//            throw new FxDealsException("400", "FX Deal fields not valid!");
//        }
//
//        FxDeal fxDeal = get(id);
//        fxDeal.setFromCurrency(fxDealDto.getFromCurrency());
//        fxDeal.setToCurrency(fxDealDto.getToCurrency());
//        fxDeal.setTimestamp(fxDealDto.getTimestamp());
//        fxDeal.setAmount(fxDealDto.getAmount());
//
//        fxDealRepository.save(fxDeal);
//
//        return fxDeal;
//    }
//
//    public void delete(String id) {
//        fxDealRepository.delete(get(id));
//    }

}
