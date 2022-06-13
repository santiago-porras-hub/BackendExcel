package co.edu.unbosque.proyecto.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import co.edu.unbosque.proyecto.Pojo.MessagePojo;
import co.edu.unbosque.proyecto.Pojo.UserPojo;
import co.edu.unbosque.proyecto.models.User;
import co.edu.unbosque.proyecto.service.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.mail.javamail.JavaMailSender;
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

    @GetMapping("/id")
    public  User getId(@RequestParam Integer id){
        System.out.println(id);
        return userService.obtainId(id);
    }

    @PutMapping("/editUser")
    public User editUser(@RequestBody UserPojo userPojo,Integer id){
        return userService.editarUser(userPojo,id);
    }

    @PutMapping("/deleteUser")
    public User  deleteUser(@RequestParam Integer id){
        return userService.deleteUser(id);
    }



    @PostMapping("/createUser")
    public MessagePojo createUser(@RequestBody UserPojo userPojo){
        MessagePojo userPojo1= new MessagePojo();
        User user= new User(userPojo.getId(),userPojo.getNombre(),userPojo.getTelefono(),userPojo.getDireccion(),userPojo.getCorreo(),userPojo.getContraseña(),"U","A",0);
        userService.registerUser(user);
        if(user.getId()==0){
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
