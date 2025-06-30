package utez.edu.mx.unidad3.models.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.unidad3.utlis.APIResponse;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClienRepository clientRepository;


    @Transactional(readOnly = true)
    public APIResponse findAll() {

        List<Client> list = clientRepository.findAll();
        return new APIResponse("",list,false, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public APIResponse findById(Long id) {
        try {
            Client found = clientRepository.findById(id).orElse(null);
            if (found == null){
                return new APIResponse("No se encontro al cliente solicitado",true, HttpStatus.NOT_FOUND);
            }

            return new APIResponse("Operacion exitosa",found,false, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new APIResponse("Error al buscar el cliente solicitado",false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public APIResponse save(Client client) {

        try {
            Client saved = clientRepository.save(client);

            if (saved == null){
                return new APIResponse("No se guardo el cliente",true, HttpStatus.NOT_FOUND);
            }

            return new APIResponse("Operacion exitosa",false, HttpStatus.CREATED);
        }catch (Exception ex){
            ex.printStackTrace();
            return new APIResponse("Error al guardar el cliente",false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @Transactional(readOnly = true)
    public APIResponse update() {
        return null;
    }
    @Transactional(readOnly = true)
    public APIResponse remove() {
        return null;
    }
}
