package cl.tbd.ejemplo1.services;

import cl.tbd.ejemplo1.models.Tarea;
import cl.tbd.ejemplo1.repositories.TareaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TareaService {

    private final TareaRepository tareaRepository;
    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    @GetMapping("/tarea")
    public List<Tarea> getAllTarea() {
        return tareaRepository.getAllTarea();
    }

    @GetMapping("/tarea/count")
    public String countTarea(){
        int total = tareaRepository.countTarea();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/tarea/a")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        Tarea result = tareaRepository.createTarea(tarea);
        return result;
    }
}
