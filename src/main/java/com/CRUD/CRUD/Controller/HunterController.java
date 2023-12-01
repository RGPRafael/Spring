/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.Controller;

import com.CRUD.CRUD.Repository.HunterRepository;
import com.CRUD.CRUD.models.HunterDetails;
import com.CRUD.CRUD.models.Hunters;
import com.CRUD.CRUD.models.LocalizacaoAtual;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael
 */





/*
annotation is used to 
define a controller and to 
indicate that the return value of the 
methods should be be bound to the web response body.
*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hunters")
public class HunterController {
    
    
    /*
    usar DTOS pode ser mais pratico e seguro,ssugestao de melhoria
    */
    
    /* We use @Autowired to inject TutorialRepository bean to local variable. */
     @Autowired
    private HunterRepository hunterRepository;
     
    @PostMapping("/cadastro")
    @Transactional
    public void cadastro( @RequestBody HunterDetails hunterDetails ){
        try {
            LocalizacaoAtual localizacaoatuao = new LocalizacaoAtual();
            localizacaoatuao.setContinente(hunterDetails.getContinente());
            localizacaoatuao.setLocalizaçãoconhecida(hunterDetails.getLocalizaçãoconhecida());
            localizacaoatuao.setPais(hunterDetails.getPais());

            Hunters hunters = new Hunters(hunterDetails.getNome(), hunterDetails.getDescrição(), hunterDetails.getEstrelas(), 
                    hunterDetails.getProvasfeitas(), hunterDetails.getTemlicenca() , hunterDetails.getNem(), localizacaoatuao);
            Hunters save = hunterRepository.save( hunters ); 


            System.out.println( ResponseEntity.status(HttpStatus.CREATED)
                   .body("Hunter saved with ID: " + save.getId()).toString() ) ;
        
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save Hunter details.").toString());
        }
    }
    /*
    usar paginacao, passar parametro para o findall assim ele monta a query automcatco
    na hora de fazer a requisicao passar o parametro size senao spring vai passar vinte por padrao
     http: //localhost:8080/hunters/buscartodos?size=1
    */
    @GetMapping("/buscartodos")
    public List<Hunters> listar(Pageable pagina) {
        List<Hunters> findAll = hunterRepository.findAll(pagina).toList();
        
        return findAll;
    }
    
    
    
    @GetMapping("/buscartodosAtivos")
    public List<Hunters> listarAtivos(Pageable pagina) {
        List<Hunters> findAll = hunterRepository.findAllByAtivoTrue(pagina).toList();
        
        return findAll;
    }
    
    @DeleteMapping("/deleteAll")
    @Transactional
    public Integer deleteAll(){
        Integer huntersdelete = hunterRepository.findAll().size();
        hunterRepository.deleteAll();
        
        return huntersdelete;
        
    }
    
    @GetMapping("/bucarID/{id}")
    public Hunters bucarID(@PathVariable Long id) {
        Hunters hunter = hunterRepository.getById(id);
        
        return hunter;
    }
    
    /*exclusao no banco */
    
    @DeleteMapping("/deleteID/{id}")
    public void  deleteID(@PathVariable Long id) {
         //hunterRepository.deleteById(id);
         Hunters hunter = hunterRepository.getReferenceById(id);
         hunter.excluir();

    }
    
    
    @PutMapping("/atualizar/{id}")
    @Transactional
    public void atualizar(@RequestBody  HunterDetails hunterDetails ) {
            LocalizacaoAtual localizacaoatuao = new LocalizacaoAtual();
            localizacaoatuao.setContinente(hunterDetails.getContinente());
            localizacaoatuao.setLocalizaçãoconhecida(hunterDetails.getLocalizaçãoconhecida());
            localizacaoatuao.setPais(hunterDetails.getPais());

            Hunters hunters = new Hunters(hunterDetails.getNome(), hunterDetails.getDescrição(), hunterDetails.getEstrelas(), 
                    hunterDetails.getProvasfeitas(), hunterDetails.getTemlicenca() , hunterDetails.getNem(), localizacaoatuao);
           
            hunterRepository.getReferenceById(hunters.getId());
    }
    
    
    /*------------------------------------------------------------------------
    
    devolver codigos corretos seguindo padronização http
    logo usar o ResponseEntity
    
    */
    
     @DeleteMapping("/{id}")
    public ResponseEntity  delete(@PathVariable Long id) {
         //hunterRepository.deleteById(id);
         Hunters hunter = hunterRepository.getReferenceById(id);
         hunter.excluir();
         return ResponseEntity.noContent().build();

    }
    
    /*devolver a informacao atualizada */
    
    @PutMapping
    @Transactional
    public ResponseEntity Atualizar(@RequestBody  HunterDetails hunterDetails ) {
            LocalizacaoAtual localizacaoatuao = new LocalizacaoAtual();
            localizacaoatuao.setContinente(hunterDetails.getContinente());
            localizacaoatuao.setLocalizaçãoconhecida(hunterDetails.getLocalizaçãoconhecida());
            localizacaoatuao.setPais(hunterDetails.getPais());

            Hunters hunters = new Hunters(hunterDetails.getNome(), hunterDetails.getDescrição(), hunterDetails.getEstrelas(), 
                    hunterDetails.getProvasfeitas(), hunterDetails.getTemlicenca() , hunterDetails.getNem(), localizacaoatuao);
           
            Hunters referenceById = hunterRepository.getReferenceById(hunters.getId());
            return ResponseEntity.ok(referenceById);
    }
    
    
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar( @RequestBody HunterDetails hunterDetails ){
        try {
            LocalizacaoAtual localizacaoatuao = new LocalizacaoAtual();
            localizacaoatuao.setContinente(hunterDetails.getContinente());
            localizacaoatuao.setLocalizaçãoconhecida(hunterDetails.getLocalizaçãoconhecida());
            localizacaoatuao.setPais(hunterDetails.getPais());

            Hunters hunters = new Hunters(hunterDetails.getNome(), hunterDetails.getDescrição(), hunterDetails.getEstrelas(), 
                    hunterDetails.getProvasfeitas(), hunterDetails.getTemlicenca() , hunterDetails.getNem(), localizacaoatuao);
            Hunters save = hunterRepository.save( hunters ); 

            return ResponseEntity.status(HttpStatus.CREATED).body("Hunter salvo com ID: " + save.getId());
        
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hunter nao foi salvo.");
        }
       
    }
    
    @GetMapping("")
    public  ResponseEntity<Page<Hunters>> ListarAtivos(Pageable pagina) {
         Page<Hunters> findAllByAtivoTrue = hunterRepository.findAllByAtivoTrue(pagina);
         
        return ResponseEntity.ok(findAllByAtivoTrue);
        
    }
    
    @GetMapping("/{id}")
    public Hunters buscarID(@PathVariable Long id) {
        Hunters hunter = hunterRepository.getById(id);
        
        return hunter;
    }
    
    
    
}
