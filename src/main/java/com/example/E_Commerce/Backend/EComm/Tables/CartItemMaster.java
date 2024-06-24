package com.example.E_Commerce.Backend.EComm.Tables;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class CartItemMaster {

    @Id
    @SequenceGenerator(
            name = "cartitem_sequence",
            sequenceName = "cartitem_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "cartitem_sequence"
    )
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnore
    private CartMaster cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private ProductMaster product;

    private Integer quantity;

    public CartItemMaster() {
    }

    public CartItemMaster(Long cartItemId, CartMaster cart, ProductMaster product, Integer quantity) {
        this.cartItemId = cartItemId;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public CartMaster getCart() {
        return cart;
    }

    public void setCart(CartMaster cart) {
        this.cart = cart;
    }

    public ProductMaster getProduct() {
        return product;
    }

    public void setProduct(ProductMaster product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItemMaster{" +
                "cartItemId=" + cartItemId +
                ", cart=" + cart +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
