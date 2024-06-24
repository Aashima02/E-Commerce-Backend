package com.example.E_Commerce.Backend.EComm.Tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class CartMaster {

    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "cart_sequence"
    )
    private Long cartId;

    @OneToMany(mappedBy = "cart")
   // @JsonManagedReference
    @JsonIgnoreProperties("cart")
    private List<CartItemMaster> items = new ArrayList<>();

    public CartMaster() {
    }

    public CartMaster(Long cartId, List<CartItemMaster> items) {
        this.cartId = cartId;
        this.items = items;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItemMaster> getItems() {
        return items;
    }

    public void setItems(List<CartItemMaster> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CartMaster{" +
                "cartId=" + cartId +
                ", items=" + items +
                '}';
    }
}
