package cl.tbd.ejemplo1.repositories;
import java.util.List;
import cl.tbd.ejemplo1.models.Voluntario;
import cl.tbd.ejemplo1.models.Vol_habilidad;

public interface VoluntarioRepository {
    public int countVoluntario();
    public List<Voluntario> getAllVoluntarios();
    public List<Voluntario> getCercanos(Double latitud,Double longitud,int N);
    public Voluntario createVoluntario(Voluntario voluntario);
    public boolean deleteVoluntario(int id);
    public Voluntario getVoluntario(int id);
    public boolean updateVoluntario(Voluntario nuevoVoluntario);
    public Voluntario getUserByToken(String token);
    public Voluntario logIn(Voluntario user);
    public String logOut(Voluntario user);
    public List<Vol_habilidad> miHabilidad(int id);
}