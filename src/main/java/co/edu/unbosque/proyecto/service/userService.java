package co.edu.unbosque.proyecto.service;

import co.edu.unbosque.proyecto.Pojo.UserPojo;
import co.edu.unbosque.proyecto.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.unbosque.proyecto.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional

public class userService {

    @Autowired
    UserRepository userRepository;

    public List<UserPojo> list(){

        return userRepository.findAll();
    }

    public  User obtainId(Integer id){

        return  userRepository.buscarPorId(id);
    }
    public User editarUser(UserPojo user,Integer id){
        return  userRepository.editar(user, id);
    }

    public User deleteUser(Integer id){
        return  userRepository.eliminar(id);
    }

    public User registerUser(User user){

        User newUser= new User(user.getId(),user.getNombre(),user.getTelefono(),user.getDireccion(),user.getCorreo(),user.getContraseña(),user.getPrioridad(),user.getEstado(),user.getIntentos());
        userRepository.registerUser(newUser);
        return newUser;
    }

    public String loginUser(UserPojo userPojo){
        return userRepository.loginUser(userPojo);
    }
}
