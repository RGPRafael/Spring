/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.Controller;

import com.CRUD.CRUD.Repository.UsuarioRepository;
import com.CRUD.CRUD.Service.EmailServiceImpl;
import com.CRUD.CRUD.Service.SenhaTemporariaService;
import com.CRUD.CRUD.models.MudarSenha;
import com.CRUD.CRUD.models.Usuario;
import com.evasion.exception.UsernameNotFoundException;
import jakarta.transaction.Transactional;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    
     @Autowired
    private UsuarioRepository usuarioRepository;
     
     @Autowired
    private EmailServiceImpl emailservice;
     
      @Autowired
    private SenhaTemporariaService senhatemporariaservice;
     
     
    @PostMapping("")
    @Transactional
    public void cadastro( @RequestBody Usuario usuario ){
        try {
             Usuario save = usuarioRepository.save( usuario ); 
             System.out.println( ResponseEntity.status(HttpStatus.CREATED)
                   .body("Usuario saved with ID: " + save.getId()).toString() ) ;
        
        } catch (Exception e) { // Log the exception or handle it as needed
            // Log the exception or handle it as needed
            System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save Usuario details.").toString());
        } 
    }
    
    @PostMapping("/Entrar")
    @Transactional
    public ResponseEntity<String> Entrar( @RequestBody Usuario usuario ) throws UsernameNotFoundException{
        try {
            
            
            Usuario usersave = usuarioRepository.findByEmailAndSenha(usuario.getEmail(),usuario.getSenha()); 
            if( usersave != null){
                return ResponseEntity.ok("true");
            }
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"success\": false, \"message\": user not find , wrong password or email\".\"}");

            }
        } catch (Exception e) { 
            // Log the exception or handle it as need
             System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to find Usuario.").toString());
             throw new UsernameNotFoundException(usuario.getEmail());
            
        }

    }
    
    @GetMapping("/EsqueceuSenha")
    @Transactional
    public ResponseEntity<String> EsqueceuSenha(@RequestParam  String email){
        
        Usuario foundEmail = usuarioRepository.findByEmail(email);
        if(foundEmail != null){
            Boolean sendSimpleMail = emailservice.sendSimpleMail(email);
            if(sendSimpleMail){
                // Return success response
                return ResponseEntity.ok("{\"success\": true}");
            }
        }
        
        // Return failure response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"success\": false, \"message\": \"Failed to send email.\"}");
    
        
    }
    @PutMapping("/RedefinirSenha")
    @Transactional
    public void RedefinirSenha( @RequestBody String senha ,  @RequestParam String email) throws UsernameNotFoundException{
        
        Usuario user = usuarioRepository.findByEmail(email);
        if(user != null ){
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuarioRepository.save( usuario ); 
            
        }
        else{
            System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to find Usuario.").toString());
             throw new UsernameNotFoundException(email);
        }
       
       
    }
    
    
    //@GetMapping("/VerificarSenhaProvisoria")
    @GetMapping("/verificar")
    @Transactional
    public ResponseEntity<String> VerificarSenhaProvisoria(@RequestParam  String senha, @RequestParam String  email) throws UsernameNotFoundException, ParseException{
        
        String checarSenhaProvisoria = senhatemporariaservice.checarSenhaProvisoria(email, senha);
        if( "OK".equals(checarSenhaProvisoria)){
                return ResponseEntity.ok("true");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("false");
        
       
       
    }
    
    @PutMapping("/atualizarSenha")
    @Transactional
    public  ResponseEntity<String> MudarSenha(@RequestBody MudarSenha mudarsenha){
        
        String email = mudarsenha.getEmail();
        String senhanova = mudarsenha.getSenhanova();
        String senha = mudarsenha.getSenha();
        
        Usuario user = usuarioRepository.findByEmail(email);
        
        
        if( senha.equals(senhanova) && user != null){
            
            
            Usuario usuario = new Usuario();
            usuario.setId(user.getId());
            usuario.setEmail(email);
            usuario.setSenha(senha);
            
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("{\"success\": true}");
            
        }
        return  ResponseEntity.badRequest().body("senhas nao sao iguais");
        
        
    }
}


/*****************************************************************************
https://stackoverflow.com/questions/36663048/spring-boot-autowiring-repository-always-null
* https://www.baeldung.com/spring-email
* https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/
* https://pabasararathnayake.medium.com/spring-boot-application-to-send-emails-using-smtp-protocol-c2616d7edf92
* https://www.reddit.com/r/gsuite/comments/11zlrnj/deleted_by_user/


*/