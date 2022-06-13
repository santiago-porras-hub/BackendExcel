package co.edu.unbosque.proyecto.controller;


import co.edu.unbosque.proyecto.Pojo.HistorialPojo;
import co.edu.unbosque.proyecto.Pojo.MessagePojo;
import co.edu.unbosque.proyecto.Pojo.UserPojo;
import co.edu.unbosque.proyecto.models.Historial;
import co.edu.unbosque.proyecto.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "https://localhost:4200")
public class HistorialController {

    @Autowired
    co.edu.unbosque.proyecto.service.historialService historialService;

    @PostMapping("/createHistorial")
    public Historial createHistorial(@RequestBody HistorialPojo historialPojo,Integer id){
        Historial historial= new Historial(historialPojo.getId(),historialPojo.getDescripcion(),historialPojo.getEstado(),new Date());
        historialService.registerHistorial(historial,historialPojo.getUsuario_id());
      return historial;
    }





}
