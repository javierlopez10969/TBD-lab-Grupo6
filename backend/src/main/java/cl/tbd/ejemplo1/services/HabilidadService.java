package cl.tbd.ejemplo1.services;

import cl.tbd.ejemplo1.models.Habilidad;
import cl.tbd.ejemplo1.repositories.HabilidadRepository;

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
public class HabilidadService {

    private final HabilidadRepository habilidadRepository;
    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    @GetMapping("/habilidades")
    public List<Habilidad> getAllHabilidad() {
        return habilidadRepository.getAllHabilidad();
    }

    @GetMapping("/habilidades/count")
    public String countHabilidad(){
        int total = habilidadRepository.countHabilidad();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/habilidades/a")
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        Habilidad result = habilidadRepository.createHabilidad(habilidad);
        return result;
    }

    @GetMapping("/habilidades/d/{id}")
    public boolean deleteHabilidad(@PathVariable int id){
        return habilidadRepository.deleteHabilidad(id);
    }

    @PostMapping("/habilidades/update")
    public boolean updateHabilidad(@RequestBody Habilidad habilidad){
         return habilidadRepository.updateHabilidad(habilidad);
    }

    @GetMapping("/habilidades/{id}")
    public Habilidad getHabilidad(@PathVariable int id){
        return habilidadRepository.getHabilidad(id);
    }
  
    @GetMapping("/habilidades/tarea/{id}")
    public List<Habilidad>  getHabilidadTarea(@PathVariable int id){
        return habilidadRepository.getHabilidadTarea(id);
    }

    @GetMapping("/habilidades/emergencia/{id}")
    public List<Habilidad>  getHabilidadEmergencia(@PathVariable int id){
        return habilidadRepository.getHabilidadEmergencia(id);
    }

    @GetMapping("/habilidades/usuario/{id}")
    public List<Habilidad>  getHabilidadUsuario(@PathVariable int id){
        return habilidadRepository.getHabilidadUsuario(id);
    }
    
  
}
