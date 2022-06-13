package co.edu.unbosque.proyecto.repositories;

import co.edu.unbosque.proyecto.Pojo.UserPojo;
import co.edu.unbosque.proyecto.models.Prioridad;
import co.edu.unbosque.proyecto.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImp implements UserRepository{

    @PersistenceContext
    EntityManager entityManager;
    co.edu.unbosque.proyecto.service.userService userService;

    @Override
    public void registerUser(Usuario usuario) {
        System.out.println(usuario.getId());
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getCorreo());
        System.out.println(usuario.getEstado());
        System.out.println(usuario.getPrioridad().getDescripcion());
        String query = "Insert into Usuario values("+  usuario.getId()+",'"+ usuario.getNombre()+"','"+ usuario.getTelefono()+"','"+ usuario.getDireccion()+"','"+ usuario.getCorreo()+"','"+ usuario.getContraseña()+"','"+ usuario.getPrioridad().getIdPrioridad()+"','"+ usuario.getEstado()+"',"+ usuario.getIntentos()+")";
        System.out.println(query);
        entityManager.createNativeQuery(query).executeUpdate();
    }

    @Override
    public String loginUser(UserPojo userPojo) {

        Usuario usuario = buscarPorId(userPojo.getId());

        if(usuario.getPrioridad().equals("A") && usuario.getContraseña().equals(userPojo.getContraseña())) {
            return "Ingresado admin";
        }else if(usuario.getPrioridad().equals("U") && usuario.getContraseña().equals(userPojo.getContraseña())){
            return "Ingresado usuario";
        }else{
            return "Credenciales incorrectas";
        }
    }

    @Override
    public List<UserPojo> findAll() {
        List<UserPojo>listpojos=new ArrayList<>();

        String query = " FROM Usuario where estado='A'";
        List<Usuario> usuarios = entityManager.createQuery(query).getResultList();
        for (Usuario usuario:usuarios) {
            listpojos.add(new UserPojo(usuario.getId(),usuario.getNombre(),usuario.getTelefono(),usuario.getDireccion(), usuario.getCorreo(),usuario.getContraseña(),usuario.getEstado(),usuario.getIntentos()));
        }
        return listpojos;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        String query = "FROM Usuario where id = " + id;
        List<Usuario> usuarios = entityManager.createQuery(query).getResultList();
        System.out.println("Tamanio = "+ usuarios.size());
        return usuarios.get(0);
    }

    @Override
    public Usuario editar(UserPojo userPojo, Integer id) {
        String query = "FROM Usuario where id = " + userPojo.getId();
        System.out.println(userPojo.getPrioridad());
        List<Usuario> usuarios = entityManager.createQuery(query).getResultList();

        Usuario usuario = usuarios.get(0);
        usuario.setNombre(userPojo.getNombre());
        usuario.setTelefono(userPojo.getTelefono());
        usuario.setDireccion(userPojo.getDireccion());
        usuario.setCorreo(userPojo.getCorreo());
        entityManager.merge(usuario);

        return usuario;
    }
    public Usuario eliminar(Integer id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        usuario.setEstado("I");
        entityManager.merge(usuario);
        return usuario;
    }

    @Override
    public Prioridad buscarPorIdHist(Integer id) {
        String query = "FROM Prioridad where id_prioridad = " + id;
        List<Prioridad> users = entityManager.createQuery(query).getResultList();
        System.out.println("Tamanio = "+users.size());
        return users.get(0);
    }
}
