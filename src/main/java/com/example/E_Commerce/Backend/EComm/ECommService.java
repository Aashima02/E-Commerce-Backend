package com.example.E_Commerce.Backend.EComm;

import com.example.E_Commerce.Backend.EComm.Repositories.*;
import com.example.E_Commerce.Backend.EComm.Tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ECommService {

    private final CategoryRepository categoryRepository;
    private final SubCatRepository subCatRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public ECommService(CategoryRepository categoryRepository, SubCatRepository subCatRepository,
                        ProductRepository productRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.categoryRepository = categoryRepository;
        this.subCatRepository = subCatRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public List<CategoryMaster> displayCategoryDetails() {
        return categoryRepository.findAll();
    }

    public List<SubCategoryMaster> displaySubCategoryDetails(){
        return subCatRepository.findAll();
    }

    public List<ProductMaster> displayProductDetails(){
        return productRepository.findAll();
    }

    public CartMaster createCart(){
        CartMaster cart = new CartMaster();
        return cartRepository.save(cart);
    }

    public CartItemMaster addItemToCart(Long cartId, Integer productId, Integer quantity){
        CartMaster cart  = cartRepository.findById(cartId).orElseThrow(() -> new IllegalStateException("Cart NotFound"));
        ProductMaster product = productRepository.findById(productId).orElseThrow(()-> new IllegalStateException("Product Not Found"));

        CartItemMaster cartItemMaster = new CartItemMaster();
        cartItemMaster.setCart(cart);
        cartItemMaster.setProduct(product);
        cartItemMaster.setQuantity(quantity);

        return cartItemRepository.save(cartItemMaster);

    }



    public List<ProductMaster> displayCartItems(Integer productId) {
        Optional<ProductMaster> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            return Collections.singletonList(productOpt.get());
        } else {
            throw new IllegalStateException("Product not found");
        }
    }


    }


