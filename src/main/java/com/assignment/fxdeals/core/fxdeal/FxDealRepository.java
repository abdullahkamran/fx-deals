package com.assignment.fxdeals.core.fxdeal;

import com.assignment.fxdeals.core.fxdeal.FxDeal;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FxDealRepository extends JpaRepository<FxDeal, String> {

}
