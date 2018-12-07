package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ObjetoRepository  extends JpaRepository<Objeto, String> {

/*
    @Query("UPDATE o from objeto o SET o.units_available = (o.units_available -1) WHERE o.title = ?1")
    public void makeAReservation(String title);
*/


}
