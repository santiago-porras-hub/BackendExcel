package co.edu.unbosque.proyecto.service;

import co.edu.unbosque.proyecto.Pojo.UserPojo;
import co.edu.unbosque.proyecto.models.Prioridad;
import co.edu.unbosque.proyecto.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.unbosque.proyecto.repositories.UserRepository;

import java.util.List;


@Service
@Transactional

public class userService {

    @Autowired
    UserRepository userRepository;

    public List<UserPojo> list(){

        return userRepository.findAll();
    }

    public Usuario obtainId(Integer id){

        return  userRepository.buscarPorId(id);
    }
    public Usuario editarUser(UserPojo user, Integer id){
        return  userRepository.editar(user, id);
    }

    public Usuario deleteUser(Integer id){
        return  userRepository.eliminar(id);
    }

    public Usuario registerUser(Usuario usuario){

        Usuario newUsuario = new Usuario(usuario.getId(), usuario.getNombre(), usuario.getTelefono(), usuario.getDireccion(), usuario.getCorreo(), usuario.getContraseña(), usuario.getPrioridad(), usuario.getEstado(), usuario.getIntentos());
        userRepository.registerUser(newUsuario);
        return newUsuario;
    }

    public String loginUser(UserPojo userPojo){
        return userRepository.loginUser(userPojo);
    }

    public  Prioridad obtainIdHist(Integer id){
        return  userRepository.buscarPorIdHist(id);
    }
}
