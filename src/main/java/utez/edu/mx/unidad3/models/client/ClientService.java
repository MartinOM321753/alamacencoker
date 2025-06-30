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
    public APIResponse findById() {
        return null;
    }

    @Transactional(readOnly = true)
    public APIResponse save() {
        return null;
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
