package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;


@Entity
@Table(name = "Reserva" )
public class Reserva {

    private int code;
    private Objeto objeto;
    private User user;
    private Boolean reserved;

    public Reserva(int code, Objeto objeto, User user, Boolean reserved) {
        this.code = code;
        this.objeto = objeto;
        this.user = user;
        this.reserved = reserved;
    }

    @Id
    @GeneratedValue
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="Objeto_reservado", referencedColumnName="title", nullable=true)
    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="Cliente", referencedColumnName="cc", nullable=true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "Reserved", nullable = true)
    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }
}
