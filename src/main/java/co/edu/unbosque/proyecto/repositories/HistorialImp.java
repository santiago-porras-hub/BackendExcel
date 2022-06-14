package co.edu.unbosque.proyecto.repositories;


import co.edu.unbosque.proyecto.Pojo.HistorialPojo;
import co.edu.unbosque.proyecto.models.Historial;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class HistorialImp implements HistorialRepository {

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public void registerHist(Historial historial) {

        entityManager.merge(historial);
    }


}
