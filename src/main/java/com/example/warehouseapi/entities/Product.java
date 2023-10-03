package com.example.warehouseapi.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


public class Product {
    private final String id;
    private String name;
    private Category category;
    private int rating;
    private final LocalDate createdAt;
    private LocalDate updatedAt;

    public Product(ProductRecord product) {
        this.id = product.id();
        this.name = product.name();
        this.rating = product.rating();
        this.createdAt = product.createdAt();
        this.updatedAt = product.updatedAt();
        this.category = product.category();
    }

    public Product(String name, Category category, int rating, LocalDate createdAt, LocalDate updatedAt) {
        this.id = String.valueOf(UUID.randomUUID());
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(String name, Category category, int rating) {
        this.id = String.valueOf(UUID.randomUUID());
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Product other = (Product) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public ProductRecord toRecord() {
        return new ProductRecord(id, name, category, rating, createdAt, updatedAt);
    }
}
