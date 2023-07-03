package dev.ifrs.model;

import jakarta.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Representa um café que esteja disponível na cafeteria de cat cafés.
 */
@Entity
public class Coffee extends PanacheEntity { // Essa classe extende PanacheEntity, que fornece operações CRUD básicas
    private String name; // Nome do café
    private String description; // Descrição do café
    private double price; // Preço do café

    // Constructors
    public Coffee(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Coffee() {
    }

    // Getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Métodos hashcosde and Equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coffee other = (Coffee) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }

    // toString
    @Override
    public String toString() {
        return "Coffee [name=" + name + ", description=" + description + ", price=" + price + "]";
    }

}
