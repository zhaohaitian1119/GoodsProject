package com.zht.goods.service;

import com.zht.goods.pojo.Goods;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-04 17:03
 */
public interface GoodsService {
    List<Goods> sel(int dis);
    Goods selById(Long id);
    int updGoods(Goods goods);
}
