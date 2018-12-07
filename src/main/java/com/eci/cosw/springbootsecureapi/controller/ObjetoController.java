package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.service.ObjetoService;
import com.eci.cosw.springbootsecureapi.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "objeto" )
public class ObjetoController {

    @Autowired
    private ObjetoService objetoService;

    @Autowired
    private ReservaService reservaService;


    @CrossOrigin
    @RequestMapping( value = "/getAll", method = RequestMethod.GET )
    public List<Objeto> getObjetos() {
        return objetoService.getAllObjetos();
    }

    @CrossOrigin
    @RequestMapping(value = "/makeAReservation", method = RequestMethod.POST)
    public ResponseEntity<?> makeAReservation(@RequestBody String title) {
        System.out.println("ENTROOOOOOOOOOOOOOOOOOO AQUIIIIIIIIIIIIIii");
        reservaService.makeReserva("Spiderman", "1");
        return new ResponseEntity<>(objetoService.makeAReservation(title), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping( value = "/{title}", method = RequestMethod.GET )
    public Objeto getObjetoByTitle(@PathVariable String title) {
        return objetoService.getObjetoByName(title);
    }

}
