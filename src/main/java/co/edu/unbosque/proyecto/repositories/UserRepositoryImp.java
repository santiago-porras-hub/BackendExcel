package co.edu.unbosque.proyecto.repositories;

import co.edu.unbosque.proyecto.Pojo.UserPojo;
import co.edu.unbosque.proyecto.models.User;
import co.edu.unbosque.proyecto.service.userService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImp implements UserRepository{

    @PersistenceContext
    EntityManager entityManager;
    co.edu.unbosque.proyecto.service.userService userService;

    @Override
    public void registerUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public String loginUser(UserPojo userPojo) {

        User user = buscarPorId(userPojo.getId());

        if(user.getPrioridad().equals("A") && user.getContraseña().equals(userPojo.getContraseña())) {
            return "Ingresado admin";
        }else if(user.getPrioridad().equals("U") && user.getContraseña().equals(userPojo.getContraseña())){
            return "Ingresado usuario";
        }else{
            return "Credenciales incorrectas";
        }
    }

    @Override
    public List<UserPojo> findAll() {
        String query = " FROM User where estado='A'";
        List<UserPojo> users = entityManager.createQuery(query).getResultList();
        return users;
    }

    @Override
    public User buscarPorId(Integer id) {
        String query = "FROM User where id = " + id;
        List<User> users = entityManager.createQuery(query).getResultList();
        System.out.println("Tamanio = "+users.size());
        return users.get(0);
    }

    @Override
    public User editar(UserPojo userPojo, Integer id) {
        String query = "FROM User where id = " + userPojo.getId();
        System.out.println(userPojo.getPrioridad());
        List<User> users = entityManager.createQuery(query).getResultList();

        User user= users.get(0);
        user.setNombre(userPojo.getNombre());
        user.setTelefono(userPojo.getTelefono());
        user.setDireccion(userPojo.getDireccion());
        user.setCorreo(userPojo.getCorreo());
        entityManager.merge(user);

        return user;
    }
    public User eliminar(Integer id) {
        User user = entityManager.find(User.class, id);
        user.setEstado("I");
        entityManager.merge(user);
        return user;
    }
}
