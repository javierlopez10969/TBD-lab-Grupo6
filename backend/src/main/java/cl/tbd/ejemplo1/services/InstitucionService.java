package cl.tbd.ejemplo1.services;

import cl.tbd.ejemplo1.models.Institucion;
import cl.tbd.ejemplo1.repositories.InstitucionRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class InstitucionService {

    private final InstitucionRepository institucionRepository;
    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/instituciones")
    public List<Institucion> getAllInstitucion() {
        return institucionRepository.getAllInstitucion();
    }

    @GetMapping("/instituciones/count")
    public String countInstitucion(){
        int total = institucionRepository.countInstitucion();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/instituciones/a")
    @ResponseBody
    public Institucion createInstitucion(@RequestBody Institucion institucion){
        Institucion result = institucionRepository.createInstitucion(institucion);
        return result;
    }
    @GetMapping("/instituciones/{id}")
    public Institucion getInstitucion(@PathVariable int id){
        System.out.println("Institucion número : " + id);
        return institucionRepository.getInstitucion(id);
    }

    @GetMapping("/instituciones/d/{id}")
    public boolean deleteInstitucion(@PathVariable int id){
        return institucionRepository.deleteInstitucion(id);
    }
       
    @PostMapping("/instituciones/update")
    public boolean updateInstitucion(@RequestBody Institucion institucion){
         return institucionRepository.updateInstitucion(institucion);
    }
}
