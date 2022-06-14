package co.edu.unbosque.proyecto.controller;


import co.edu.unbosque.proyecto.Pojo.MessagePojo;
import co.edu.unbosque.proyecto.Pojo.UserPojo;
import co.edu.unbosque.proyecto.models.Usuario;
import co.edu.unbosque.proyecto.service.emailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "https://localhost:4200")
public class userController {

    @Autowired
    private emailService emailService;
    @Autowired
    co.edu.unbosque.proyecto.service.userService userService;

    @GetMapping("/listUser")
    public List<UserPojo> listUser(){
        return userService.list();
    }

    @GetMapping("/obtenerid")
    public UserPojo getId(@RequestParam Integer id){
        System.out.println(id);

        UserPojo userPojo= new UserPojo();
        Usuario usuario= userService.obtainId(id);
        userPojo.setNombre(usuario.getNombre());
        userPojo.setId(usuario.getId());
        userPojo.setCorreo(usuario.getCorreo());
        userPojo.setDireccion(usuario.getDireccion());
        userPojo.setTelefono(usuario.getTelefono());
        userPojo.setContraseña(usuario.getContraseña());
        userPojo.setCorreo(usuario.getCorreo());
        return userPojo;
    }

    @PutMapping("/editUser")
    public Usuario editUser(@RequestBody UserPojo userPojo, Integer id){
        return userService.editarUser(userPojo,id);
    }

    @PutMapping("/deleteUser")
    public Usuario deleteUser(@RequestParam Integer id){
        return userService.deleteUser(id);
    }



    @PostMapping("/createUser")
    public MessagePojo createUser(@RequestBody UserPojo userPojo){
        MessagePojo userPojo1= new MessagePojo();
       System.out.println(userPojo.getId());
       System.out.println(userPojo.getEstado());
        Usuario usuario = new Usuario(userPojo.getId(),userPojo.getNombre(),userPojo.getTelefono(),userPojo.getDireccion(),userPojo.getCorreo(),userPojo.getContraseña(),userService.obtainIdHist(2),"A",0);

        userService.registerUser(usuario);
        if(usuario.getId()==0){
            userPojo1.setMessage("no registrado");
        }
        userPojo1.setMessage("registrado");
        return userPojo1;
    }


    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody UserPojo emailPojo){
        try{
            emailService.sendEmail(emailPojo.getCorreo(), "Bienvenido  a la empresa"+"\n", "Su contraseña es : "+emailPojo.getContraseña()+"\n"+"Su ID es:"+emailPojo.getId(), "gestiondev.ueb@gmail.com");
            return "Correo enviado";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @PostMapping("/login")
    public MessagePojo login(@RequestBody UserPojo userPojo){
        String nUser=userService.loginUser(userPojo);
        MessagePojo userPojo1= new MessagePojo();
        userPojo1.setMessage(nUser);
        return userPojo1;
    }



}
