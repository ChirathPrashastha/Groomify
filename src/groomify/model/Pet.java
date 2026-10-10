/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

/**
 *
 * @author Chirath
 */
public class Pet {
    private int petId;
    private String name;
    private String species;
    private String breed;
    private String coatType;
    private int ownerId;

    public Pet(int petId, String name, String species, String breed, String coatType, int ownerId) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.coatType = coatType;
        this.ownerId = ownerId;
    }

    public Pet(String name, String species, String breed, String coatType, int ownerId) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.coatType = coatType;
        this.ownerId = ownerId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCoatType() {
        return coatType;
    }

    public void setCoatType(String coatType) {
        this.coatType = coatType;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    
}
