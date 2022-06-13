package co.edu.unbosque.proyecto.repositories;

import co.edu.unbosque.proyecto.Pojo.HistorialPojo;
import co.edu.unbosque.proyecto.models.Historial;

public interface HistorialRepository {

    void registerHist(HistorialPojo historialPojo, Integer id);


}
