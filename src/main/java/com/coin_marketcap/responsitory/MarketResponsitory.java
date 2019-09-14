package com.coin_marketcap.responsitory;

import com.coin_marketcap.entity.Coin;
import com.coin_marketcap.entity.Market;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MarketResponsitory  extends JpaRepository<Market, String> {
    Page<Market> findByStatusAndCreatedAtGreaterThanEqual(int status, long createdAt, Pageable pageable);

    @Query("select a from Market as a where a.status = :status and a.createdAt >= :createdAt")
    Page<Market> findAllActiveMarket(@Param("status") int status, @Param("createdAt") long createdAt, Pageable page);
    List<Market> findAllByNameAndStatus(String name, int status);


}
