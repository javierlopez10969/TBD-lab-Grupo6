package cl.tbd.ejemplo1.repositories;
import java.util.List;
import cl.tbd.ejemplo1.models.Vol_habilidad;

public interface Vol_habilidadRepository {
    public int countVol_habilidad();
    public List<Vol_habilidad> getAllVol_habilidad();
    public Vol_habilidad createVol_habilidad(Vol_habilidad vol_habilidad);
    public boolean deleteVol_habilidad(int id);
    public boolean updateVol_habilidad(Vol_habilidad nuevoVol_habilidad);
    public Vol_habilidad getVol_habilidad(int id);
}