package co.edu.unbosque.proyecto.service;

import co.edu.unbosque.proyecto.Pojo.HistorialPojo;
import co.edu.unbosque.proyecto.models.Historial;
import co.edu.unbosque.proyecto.models.User;
import co.edu.unbosque.proyecto.repositories.HistorialRepository;
import co.edu.unbosque.proyecto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class historialService {

    @Autowired
    HistorialRepository historialRepository;

    public Historial registerHistorial(Historial historial,Integer id){

        HistorialPojo historialPojo= new HistorialPojo();


        Historial newHistorial= new Historial(historial.getId(),historial.getDescripcion(),historial.getEstado(),historial.getFecha());
        historialRepository.registerHist(historialPojo,id);

        return newHistorial;
    }



}
