package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.repositories.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetoServicePersistence implements ObjetoService {

    @Autowired
    ObjetoRepository objrepo;

    @Override
    public List<Objeto> getAllObjetos() {
        return objrepo.findAll();
    }

    @Override
    public Objeto getObjetoByName(String title) {
        return objrepo.findOne(title);
    }

    @Override
    public Objeto makeAReservation(String title) {
        Objeto o = objrepo.getOne(title);
        System.out.println(o.getUnits_available()+" ESTOOOOOOOOOOOOOOOOOOOOO");
        o.setUnits_available(o.getUnits_available()-1);
        System.out.println(o.getUnits_available()+" ESTOOOOOOOOOOOOOOOOOOOOO");
        objrepo.delete(title);
        objrepo.save(o);
        return o;
    }
}
