package com.company.farmfresh.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name ="Categories")
public class Category {
    @Id
    private int catId;
    @NotNull
    @Size(max =20)
    private String catName;
//    @OneToMany
//    private List<items> list;

    public Category() {
    }

    public Category(int catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                '}';
    }
}
