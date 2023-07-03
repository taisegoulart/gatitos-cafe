package dev.ifrs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.*;

@Entity
/**
 * Representa um gato que está no cat café.
 */
public class Cat extends PanacheEntity { // Essa classe extende PanacheEntity, que fornece operações CRUD básicas
    private String name; // Nome do gato
    private int age; // Idade do gato
    private String sex; // Sexo do gato
    private String breed; // Raça do gato
    private String bio; // Uma pequena biografia ou descrição do gato
    private boolean forAdoption; // Indica se o gato está para adoção

    // Constructors

    public Cat() {
    }

    public Cat(String name, int age, String sex, String breed, String bio, boolean forAdoption) {

        this.name = name;
        this.age = age;
        this.sex = sex;
        this.breed = breed;
        this.bio = bio;
        this.forAdoption = forAdoption;
    }

    // Getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isForAdoption() {
        return forAdoption;
    }

    public void setForAdoption(boolean forAdoption) {
        this.forAdoption = forAdoption;
    }

    // Métodos Hash code e equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + ((bio == null) ? 0 : bio.hashCode());
        result = prime * result + (forAdoption ? 1231 : 1237);
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
        Cat other = (Cat) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        if (sex == null) {
            if (other.sex != null)
                return false;
        } else if (!sex.equals(other.sex))
            return false;
        if (breed == null) {
            if (other.breed != null)
                return false;
        } else if (!breed.equals(other.breed))
            return false;
        if (bio == null) {
            if (other.bio != null)
                return false;
        } else if (!bio.equals(other.bio))
            return false;
        if (forAdoption != other.forAdoption)
            return false;
        return true;
    }

    // Método toString
    @Override
    public String toString() {
        return "Cat [name=" + name + ", age=" + age + ", sex=" + sex + ", breed=" + breed + ", bio=" + bio
                + ", forAdoption=" + forAdoption + "]";
    }

}
