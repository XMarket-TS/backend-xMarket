package com.bo.xMarket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * http://localhost:8080/mi_ruta/
 *
 * http://localhost:8080/mi_ruta/dos
 * HOLA MUNDO
 * Esta clase no tiene HighCohesion, porque mezcla lógica de presetación API con Acceso a Datos.
 * Esta clase no tiene Loose Coupling. Por ende esta fuertemente acoplada.
 *
 */

@RestController
public class holamundo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return "HOLA MUNDO";
    }

    @RequestMapping(value = "/dos", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloTwo() {
        return "DOS HOLA";
    }



}
