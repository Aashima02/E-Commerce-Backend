package com.example.E_Commerce.Backend.EComm;

import com.example.E_Commerce.Backend.EComm.Tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user/v1")
public class ECommController {

    private final ECommService eCommService;

    @Autowired
    public ECommController(ECommService eCommService) {
        this.eCommService = eCommService;
    }

    @GetMapping("/cat")
    public List<CategoryMaster> getCategoryDetails()
    {
        return eCommService.displayCategoryDetails();
    }

    @GetMapping("/subcat")
    public List<SubCategoryMaster> getSubCategoryDetails()
    {
        return eCommService.displaySubCategoryDetails();
    }

    @GetMapping("/product")
    public List<ProductMaster> getProductDetails()
    {
        return eCommService.displayProductDetails();
    }

    @PostMapping("/cart")
    public CartMaster createCart(){
        return eCommService.createCart();
    }

    @PostMapping("/cart/{cartId}/add")
    public CartItemMaster addItemToCart(@PathVariable("cartId") Long cartId, @RequestParam("productId") Integer productId, @RequestParam("quantity") Integer quantity){
        return eCommService.addItemToCart(cartId,productId,quantity);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ProductMaster>> displayCartItems(@RequestParam("productId") Integer productId) {
        List<ProductMaster> products = eCommService.displayCartItems(productId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
