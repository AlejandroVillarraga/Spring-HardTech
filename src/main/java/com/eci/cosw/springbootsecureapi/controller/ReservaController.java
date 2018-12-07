package com.eci.cosw.springbootsecureapi.controller;


import com.eci.cosw.springbootsecureapi.service.ObjetoService;
import com.eci.cosw.springbootsecureapi.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "reserva" )
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

}
