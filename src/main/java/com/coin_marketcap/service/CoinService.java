package com.coin_marketcap.service;

import com.coin_marketcap.entity.Coin;
import org.springframework.data.domain.Page;

public interface CoinService {
    Coin getDetail (String name);
    Page<Coin> getList(int page, int limit);

    Coin register(Coin coin);
}
