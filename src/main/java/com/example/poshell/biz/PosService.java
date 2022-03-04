package com.example.poshell.biz;

import com.example.poshell.model.Cart;
import com.example.poshell.model.Product;

import java.util.List;

public interface PosService {
    public Cart getCart();

    public Cart newCart();

    public boolean checkout();

    public boolean add(String productId, int amount);

    public boolean change(String productId, int amount);

    public boolean remove(String productId);

    public List<Product> products();
}
