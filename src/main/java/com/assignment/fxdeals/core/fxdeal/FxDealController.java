package com.assignment.fxdeals.core.fxdeal;

import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1/fx-deals")
public class FxDealController {

    private final FxDealService fxDealService;

    public FxDealController(FxDealService fxDealService) {
        this.fxDealService = fxDealService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<FxDealDto>>> getAll() {
        log.info("GET /api/v1/fx-deals called");
        Map<String, List<FxDealDto>> response = new HashMap<>();
        List<FxDeal> fxDeals;
        List<FxDealDto> responseBody = new LinkedList<>();

        fxDeals = fxDealService.getAll();

        for(FxDeal fxDeal : fxDeals){
            responseBody.add(fxDeal.generateFxDealDto());
        }
        response.put("responseBody", responseBody);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FxDealDto> get(@PathVariable("id") String id) {
        log.info("GET /api/v1/fx-deals/{id} called with id: {}", id);
        FxDeal fxDealOptional = fxDealService.get(id);
        return ResponseEntity.ok(fxDealOptional.generateFxDealDto());
    }

    @PostMapping
    public ResponseEntity<FxDealDto> create(@RequestBody FxDealDto newFxDealDto) {
        log.info("POST /api/v1/fx-deals called");
        FxDeal fxDeal = fxDealService.create(newFxDealDto);
        return ResponseEntity.ok(fxDeal.generateFxDealDto());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<FxDealDto> update(@PathVariable("id") String id,
//                                             @RequestBody FxDealDto fxDealDto) {
//
//        FxDeal fxDealOptional = fxDealService.update(id, fxDealDto);
//        return ResponseEntity.ok(fxDealOptional.generateFxDealDto());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<FxDealDto> delete(@PathVariable("id") String id) {
//
//        fxDealService.delete(id);
//        return ResponseEntity.ok().build();
//    }

}
