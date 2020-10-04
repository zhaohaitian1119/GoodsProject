package com.zht.goods.service.impl;

import com.zht.goods.mapper.GoodsMapper;
import com.zht.goods.pojo.Goods;
import com.zht.goods.pojo.GoodsExample;
import com.zht.goods.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-04 17:04
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> sel(int dis) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsdistrictEqualTo(dis);
        List<Goods> goods = goodsMapper.selectByExample(example);
        return goods;
    }

    @Override
    public Goods selById(Long id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return goods;
    }

    @Override
    public int updGoods(Goods goods) {
        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        return i;
    }
}
