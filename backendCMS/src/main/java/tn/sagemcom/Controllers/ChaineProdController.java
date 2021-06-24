package tn.sagemcom.Controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.sagemcom.Entities.Audit;
import tn.sagemcom.Entities.ChaineProd;
import tn.sagemcom.Entities.ResourceNotFoundException;
import tn.sagemcom.Entities.User;
import tn.sagemcom.Repositories.AuditRepository;
import tn.sagemcom.Repositories.ChaineProdRepository;
import tn.sagemcom.Repositories.UserRepository;

@Component
@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/chaineprod")
public class ChaineProdController {

    
    @Autowired
     private ChaineProdRepository chaineRepository;
    
  @Autowired
  private AuditRepository arep;
    
    @GetMapping("/list")
    public List<ChaineProd> getAllUsers() {
        return chaineRepository.findAll();
    }
    @GetMapping("/getch/{id}")
    public ResponseEntity<ChaineProd> getChaineProdById(@PathVariable(value = "id") Long chId)
        throws ResourceNotFoundException {
        ChaineProd ch = chaineRepository.findById(chId)
          .orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + chId));
        return ResponseEntity.ok().body(ch);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ChaineProd> UpdateUser(@PathVariable(value = "id") Long chId,
         @Valid @RequestBody ChaineProd chDetails) throws ResourceNotFoundException {
        ChaineProd ch = chaineRepository.findById(chId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + chId));
        Timestamp currentTime=new Timestamp(System.currentTimeMillis());
        Audit audit=new Audit("Mr Idriss",currentTime,"Update",ch);
       arep.save(audit);
        final ChaineProd updatedChaineProd = chaineRepository.save(ch);
        return ResponseEntity.ok(updatedChaineProd);
    }
    @PostMapping("/create")    
        public ChaineProd createchaine( @RequestBody ChaineProd ch) {
        Timestamp currentTime=new Timestamp(System.currentTimeMillis());
        Audit audit=new Audit("Mr Idriss",currentTime,"Create",ch);
       arep.save(audit);
        return chaineRepository.save(ch);
        
        
    }
    @DeleteMapping(value="/del/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long chId)
         throws ResourceNotFoundException {
        ChaineProd ch = chaineRepository.findById(chId)
       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + chId));
        Timestamp currentTime=new Timestamp(System.currentTimeMillis());
        Audit audit=new Audit("Mr Idriss",currentTime,"delete",ch);
       arep.save(audit);
        chaineRepository.delete(ch);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
