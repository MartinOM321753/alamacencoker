package utez.edu.mx.unidad3.models.cede;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.unidad3.utlis.APIResponse;
import utez.edu.mx.unidad3.utlis.CleveGenerator;

import java.sql.SQLException;
import java.util.List;

@Service
public class CedeService {
    @Autowired
    private CedeRepository cedeRepository;

    @Transactional(readOnly = true)
    public APIResponse findAll() {
        List<Cede> list = cedeRepository.findAll();
        return new APIResponse("Operacion exitosa", list ,false, HttpStatus.OK);

    }

    @Transactional(rollbackFor = Exception.class)
    public APIResponse save(Cede cede) {
        try {

            cede.setClave("pending...");
            Cede saved = cedeRepository.save(cede);
            saved.setClave(CleveGenerator.generateCedeClave(saved.getId()));
            cedeRepository.save(saved);

            if (saved == null){
                return new APIResponse("No se guardo el cede",true, HttpStatus.NOT_FOUND);
            }
            return new APIResponse("Operacion exitosa",false, HttpStatus.CREATED);
        }catch (Exception ex){
            ex.printStackTrace();
            return new APIResponse("Error al guardar el cede",false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Transactional(readOnly = true)
    public APIResponse findById(Long id) {
        try {
            Cede found = cedeRepository.findById(id).orElse(null);
            if (found == null){
                return new APIResponse("No se encontro al cede solicitado",true, HttpStatus.NOT_FOUND);
            }
            return new APIResponse("Operacion exitosa",found,false, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new APIResponse("Error al buscar la cede solicitada",false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public APIResponse update(Cede cede) {
        try {
            if (cedeRepository.findById(cede.getId()).isEmpty()){
                return new APIResponse("No se encontro al cede solicitado",true, HttpStatus.NOT_FOUND);
            }
            cedeRepository.save(cede);
            return new APIResponse("Operacion exitosa",false, HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
            return new APIResponse("Error al actualizar el cede solicitado",false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public APIResponse remove(Cede cede) {
        try {
            if (cedeRepository.findById(cede.getId()).isEmpty()){
                return new APIResponse("No se encontro al cede solicitado",true, HttpStatus.NOT_FOUND);
            }
            cedeRepository.save(cede);
            return new APIResponse("Operacion exitosa",false, HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
            return new APIResponse("Error al eliminar el cede solicitado",false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
