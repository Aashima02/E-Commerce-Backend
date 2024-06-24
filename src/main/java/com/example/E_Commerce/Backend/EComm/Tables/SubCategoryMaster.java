package com.example.E_Commerce.Backend.EComm.Tables;


import jakarta.persistence.*;

@Entity
@Table
public class SubCategoryMaster {

    @Id
    @SequenceGenerator(
            name = "subCategory_sequence",
            sequenceName = "subCategory_sequence"
    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "subCategory_sequence"
//    )

    private Integer subCategoryId;
    private Long categoryId;
    private String subCategoryName;

    public SubCategoryMaster() {
    }

    public SubCategoryMaster(Integer subCategoryId, Long categoryId, String subCategoryName) {
        this.subCategoryId = subCategoryId;
        this.categoryId = categoryId;
        this.subCategoryName = subCategoryName;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    @Override
    public String toString() {
        return "SubCategoryMaster{" +
                "subCategoryId=" + subCategoryId +
                ", categoryId=" + categoryId +
                ", subCategoryName='" + subCategoryName + '\'' +
                '}';
    }
}
