package com.example.poshell.biz;

import com.example.poshell.db.PosDB;
import com.example.poshell.model.Cart;
import com.example.poshell.model.Item;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PosServiceImp implements PosService {

    private PosDB posDB;

    @Autowired
    public void setPosDB(PosDB posDB) {
        this.posDB = posDB;
    }

    @Override
    public boolean checkout() {
        return posDB.getCart() != null;
    }

    @Override
    public Cart getCart() {
        return posDB.getCart();
    }

    @Override
    public Cart newCart() {
        return posDB.saveCart(new Cart());
    }

    @Override
    public boolean add(String productId, int amount) {
        Product product = posDB.getProduct(productId);
        if (product == null)
            return false;

        Cart cart = this.getCart();

        if (cart == null) {
            return false;
        }

        Item item = cart.getItem(productId);
        if (item == null) {
            if (amount <= 0) {
                return false;
            }
            cart.addItem(new Item(product, amount));
        } else {
            if (item.getAmount() + amount <= 0) {
                return cart.removeItem(productId);
            }
            item.setAmount(item.getAmount() + amount);
        }
        return true;
    }

    @Override
    public boolean change(String productId, int amount) {
        Cart cart = this.getCart();
        Item item = cart.getItem(productId);
        if (item == null) {
            return false;
        }
        item.setAmount(amount);
        return true;
    }

    @Override
    public boolean remove(String productId) {
        Cart cart = this.getCart();
        return cart.removeItem(productId);
    }

    @Override
    public List<Product> products() {
        return posDB.getProducts();
    }
}
