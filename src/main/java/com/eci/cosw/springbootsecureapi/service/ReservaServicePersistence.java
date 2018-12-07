package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Reserva;
import com.eci.cosw.springbootsecureapi.repositories.ObjetoRepository;
import com.eci.cosw.springbootsecureapi.repositories.ReservasRepository;
import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServicePersistence implements ReservaService {

    @Autowired
    ReservasRepository reservasRepository;

    @Autowired
    ObjetoRepository objetoRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Reserva makeReserva(String title, String cc) {
        Reserva r = new Reserva(1,objetoRepository.findOne("Spiderman"),userRepository.findOne("1"),true);
        return r;
    }
}
