package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    public Category(){

    }

    @Id
    @GeneratedValue
    private int id;

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min=2, max=20)
    private String name;

    @OneToMany
    @JoinColumn(name="category_id")
    private List<Cheese> cheeses = new ArrayList<>();


}

