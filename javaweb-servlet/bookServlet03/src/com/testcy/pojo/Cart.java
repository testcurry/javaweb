package com.testcy.pojo;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象模型
 */
public class Cart {
    //使用get方法中的局部变量代替
  /*  private Integer totalCount;
    private BigDecimal totalPrice;*/
//    private Integer totalCount;
    private Map<Integer, CartItem> items = new LinkedHashMap<>();
    //list集合遍历时效率太低，此处换成map集合
//    private List<CartItem> items = new ArrayList<>();

    /**
     * 添加购物车
     *
     * @param item
     */
    public void addItem(CartItem item) {
        CartItem cartItem = items.get(item.getId());
        if (cartItem == null) {
            items.put(item.getId(), item);
        } else {
            //该商品项数量累加
            cartItem.setCount(cartItem.getCount() + 1);
            //该商品项的总金额更新
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }

    }

    /**
     * 删除商品项
     *
     * @param id 商品id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {

        items.clear();
    }

    /**
     * 修改购物车中的商品的数量
     *
     * @param id    修改的对应商品的id
     * @param count 修改之后的商品数量
     */
    public void updateItemCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }

    }

    public Integer getTotalCount() {
        //第一种遍历方式，iteration迭代器遍历
        Integer totalCount = 0;
        Iterator<Map.Entry<Integer, CartItem>> iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, CartItem> item = iterator.next();
            totalCount += item.getValue().getCount();
        }
        //第二种遍历方式，增强for循环
//        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
//            this.totalCount+=entry.getValue().getCount();
//
//        }
        //第三种遍历方式，直接遍历map的值
//        for (CartItem cartItem : items.values()) {
//
//        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        Iterator<Map.Entry<Integer, CartItem>> iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, CartItem> item = iterator.next();
            totalPrice = totalPrice.add(item.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
