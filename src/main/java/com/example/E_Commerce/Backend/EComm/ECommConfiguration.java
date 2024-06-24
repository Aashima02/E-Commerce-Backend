package com.example.E_Commerce.Backend.EComm;

import com.example.E_Commerce.Backend.EComm.Repositories.CategoryRepository;
import com.example.E_Commerce.Backend.EComm.Repositories.ProductRepository;
import com.example.E_Commerce.Backend.EComm.Repositories.SubCatRepository;
import com.example.E_Commerce.Backend.EComm.Tables.CategoryMaster;
import com.example.E_Commerce.Backend.EComm.Tables.ProductMaster;
import com.example.E_Commerce.Backend.EComm.Tables.SubCategoryMaster;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ECommConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository,
                                        SubCatRepository subCatRepository,
                                        ProductRepository productRepository){
        return args -> {
            CategoryMaster Electronics = new CategoryMaster(1L, "Electronics");
            CategoryMaster Sports = new CategoryMaster(2L, "Sports & Fitness");

            SubCategoryMaster Televisions = new SubCategoryMaster(111,1L,"Televisions");
            SubCategoryMaster Headphones = new SubCategoryMaster(112,1L,"Headphones");
            SubCategoryMaster Cameras = new SubCategoryMaster(113, 1L, "Cameras");
            SubCategoryMaster Cardio = new SubCategoryMaster(221, 2L, "Cardio Equipment");
            SubCategoryMaster Cycling = new SubCategoryMaster(222, 2L, "Cycling");
            SubCategoryMaster Running = new SubCategoryMaster(223, 2L, "Running");

            ProductMaster Samsung = new ProductMaster(11001,"Samsung",31);
            ProductMaster LG = new ProductMaster(11002,"LG",28);
            ProductMaster BOAT = new ProductMaster(12001,"BOAT",47);
            ProductMaster Redmi = new ProductMaster(12002,"Redmi",45);
            ProductMaster SanDisk = new ProductMaster(13001,"SanDisk",17);
            ProductMaster Sony = new ProductMaster(13002,"Sony",33);

            ProductMaster FITKIT = new ProductMaster(21001,"FITKIT",31);
            ProductMaster ShapeWell = new ProductMaster(21002,"ShapeWell",28);
            ProductMaster Leader = new ProductMaster(22001,"Leader",47);
            ProductMaster UrbanTerrain = new ProductMaster(22002,"Urban Terrain",45);
            ProductMaster Adidas = new ProductMaster(23001,"Adidas",17);
            ProductMaster Nike = new ProductMaster(23002,"Nike",33);



            categoryRepository.saveAll(List.of(Electronics, Sports));
            subCatRepository.saveAll(List.of(Televisions,Headphones,Cameras,
                    Cardio,Cycling,Running));

            productRepository.saveAll(List.of(Samsung,LG,BOAT,Redmi,SanDisk,Sony,
                                              FITKIT,ShapeWell,Leader,UrbanTerrain,Adidas,Nike));

        };

    }



}
