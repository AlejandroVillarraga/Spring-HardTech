package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Objeto")
public class Objeto {

    String title;
    String description;
    String actors;
    String director;
    String price;
    int units_available;
    String image;
    Boolean reserved;
    String trailer;

    public Objeto(String title, String description, String actors, String director,
                  String price, int units_available, String image, Boolean reserved, String trailer) {
        this.title = title;
        this.description = description;
        this.actors = actors;
        this.director = director;
        this.price = price;
        this.units_available = units_available;
        this.image = image;
        this.reserved = reserved;
        this.trailer = trailer;
    }

    public Objeto() {
    }


    @Column(name = "trailer", nullable = true)
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "reserved", nullable = true)
    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    @Id
    @Column(name = "title", nullable = true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "actors", nullable = true)
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Column(name = "director", nullable = true)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name = "price", nullable = true)
    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    @Column(name = "units_available", nullable = true)
    public int getUnits_available() {
        return units_available;
    }

    public void setUnits_available(int units_available) {
        this.units_available = units_available;
    }
}
