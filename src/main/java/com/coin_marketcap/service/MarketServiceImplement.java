package com.coin_marketcap.service;


import com.coin_marketcap.entity.Coin;
import com.coin_marketcap.entity.Market;
import com.coin_marketcap.responsitory.MarketResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class MarketServiceImplement implements MarketService {

    @Autowired
    private MarketResponsitory marketResponsitory;


    public List<Market> search(String name){
        return marketResponsitory.findAllByNameAndStatus(name, 1);
    }
    @Override
    public Page<Market> getList(int page, int limit) {
        return marketResponsitory.findAllActiveMarket(1, 1568084234001L,
                PageRequest.of(page - 1, limit, Sort.by("createdAt").descending()));


    }


    @Override
    public Market getDetail(String name) {
        return marketResponsitory.findById(name).orElse(null);
    }



    @Override
    public Market register(Market market) {
        // thuc hien ma~ hoa password khi can
        market.setId(Calendar.getInstance().getTimeInMillis());
        market.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        market.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        market.setStatus(1);
        return marketResponsitory.save(market);
    }



}
