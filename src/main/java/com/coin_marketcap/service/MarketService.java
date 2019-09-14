package com.coin_marketcap.service;
import com.coin_marketcap.entity.Market;
import org.springframework.data.domain.Page;

public interface MarketService {

    Market getDetail (String name);

    Market register (Market market);

    Page<Market> getList(int page, int limit);
}
