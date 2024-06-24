package com.example.E_Commerce.Backend.EComm.Tables;

import jakarta.persistence.*;

@Entity
@Table
public class CategoryMaster {

    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence"
    )
//    @GeneratedValue(
//            strategy = GenerationType.AUTO,
//            generator = "category_sequence"
//    )

    private Long categoryId;
    private String categoryName;

    public CategoryMaster(){
    }

    public CategoryMaster(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryMaster{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

