package co.edu.unbosque.proyecto.service;

import co.edu.unbosque.proyecto.Pojo.HistorialPojo;
import co.edu.unbosque.proyecto.models.Historial;
import co.edu.unbosque.proyecto.models.Prioridad;
import co.edu.unbosque.proyecto.models.Usuario;
import co.edu.unbosque.proyecto.repositories.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class historialService {

    @Autowired
    HistorialRepository historialRepository;
    @Autowired
    userService userService;

    public Historial registerHistorial(Historial historial,Integer id){
        Usuario usuario= userService.obtainId(id);
        Historial newHistorial= new Historial(historial.getIdAuditoria(),historial.getDescripcion(),historial.getEstado(),historial.getFecha());
        newHistorial.setUsuario(usuario);
        historialRepository.registerHist(newHistorial);
        return newHistorial;
    }



}
