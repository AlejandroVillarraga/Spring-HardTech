package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Reserva;

public interface ReservaService {


    Reserva makeReserva(String title, String cc);

}
