package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Objeto;

import java.util.List;

public interface ObjetoService {

    List<Objeto> getAllObjetos();

    Objeto getObjetoByName(String title);

    Objeto makeAReservation(String title);
}
