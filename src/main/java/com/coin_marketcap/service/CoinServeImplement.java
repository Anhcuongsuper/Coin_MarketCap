package com.coin_marketcap.service;
import com.coin_marketcap.entity.Coin;
import com.coin_marketcap.responsitory.CoinResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CoinServeImplement implements CoinService {

    @Autowired
    private CoinResponsitory coinResponsitory;


    public List<Coin> search(long marketId, String name){
        return coinResponsitory.findAllByNameAndStatus(marketId, name );
    }
    @Override
    public Page<Coin> getList(int page, int limit){
        return coinResponsitory.findAllActiveCoin(1, 1568084234001L,
                PageRequest.of(page -1, limit, Sort.by("createdAt").descending()));


    }


    @Override
    public Coin getDetail(String name) {
        return coinResponsitory.findById(name).orElse(null);
    }



    @Override
    public Coin register(Coin coin) {
        coin.setId(Calendar.getInstance().getTimeInMillis());
        coin.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        coin.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        coin.setStatus(1);
        return coinResponsitory.save(coin);
    }



}
