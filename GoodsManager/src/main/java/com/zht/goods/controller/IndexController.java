package com.zht.goods.controller;

import com.zht.goods.pojo.Goods;
import com.zht.goods.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-04 16:56
 */
@Controller
public class IndexController {

    @Resource
    GoodsService goodsService;

    @RequestMapping("/")
    public String s(){
        return "index";
    }

    @RequestMapping("/sel")
    public String sel(HttpServletRequest request, Model model){
        String district = request.getParameter("goodsdistrict");
        int dis = 0;
        if(district != "" || !district.equals("0")){
            dis = Integer.parseInt(district);
        }
        List<Goods> goods = goodsService.sel(dis);
        model.addAttribute("goods",goods);
        return "sel";
    }

    @RequestMapping("/selById/{id}")
    public String selById(@PathVariable Long id,Model model){
        Goods goods = goodsService.selById(id);
        model.addAttribute("goodsById",goods);
        return "upd";
    }

    @RequestMapping("/upd")
    public String upd(Goods goods){
        goodsService.updGoods(goods);
        return "redirect:/";
    }
}
