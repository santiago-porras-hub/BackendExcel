package co.edu.unbosque.proyecto.repositories;

import co.edu.unbosque.proyecto.Pojo.UserPojo;
import co.edu.unbosque.proyecto.models.Prioridad;
import co.edu.unbosque.proyecto.models.Usuario;

import java.util.List;

public interface UserRepository {

   void registerUser(Usuario usuario);
   String loginUser(UserPojo user);
   List<UserPojo> findAll();
   Usuario buscarPorId(Integer id);
   Usuario editar(UserPojo userPojo, Integer id);
   Usuario eliminar(Integer id);
   Prioridad buscarPorIdHist(Integer id);
}
