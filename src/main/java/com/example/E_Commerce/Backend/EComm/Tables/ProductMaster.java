package com.example.E_Commerce.Backend.EComm.Tables;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class ProductMaster {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence"
    )
//    @GeneratedValue(
//            strategy = GenerationType.AUTO,
//            generator = "product_sequence"
//    )

    private Integer productId;
    private String productName;
    private Integer quantity;

    @OneToMany(mappedBy = "product")
    private Set<CartItemMaster> items;

    public ProductMaster() {
    }

    public ProductMaster(Integer productId, String productName, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.items = items;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<CartItemMaster> getItems() {
        return items;
    }

    public void setItems(Set<CartItemMaster> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ProductMaster{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", items=" + items +
                '}';
    }
}
