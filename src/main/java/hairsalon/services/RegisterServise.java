package hairsalon.services;

import hairsalon.client.Client;
import hairsalon.client.repository.IClientRepo;
import hairsalon.master.Master;
import hairsalon.master.repository.IMasterRepo;
import hairsalon.utils.IUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Boris on 06.04.2017.
 */
@Controller
@CrossOrigin
@RequestMapping("/register")
public class RegisterServise {
    @Autowired
    private IClientRepo clientRepo;
    @Autowired
    private IUtils utils;
    @Autowired
    private IMasterRepo masterRepo;
    @PostMapping("/master")
    public ResponseEntity<Master> registerMaster(@RequestBody Master master) {
        if (utils.isLoginInfoExist(master)){
            return new ResponseEntity<Master>(HttpStatus.NOT_ACCEPTABLE);// Wrong login or password
        }
        Master master1 = masterRepo.registerMaster(master);
        if (master1 == null) {
            return new ResponseEntity<Master>(HttpStatus.BAD_REQUEST); // Found same login
        }

        return new ResponseEntity<Master>(master1, HttpStatus.OK);
    }

    @PostMapping("client")
    public ResponseEntity<Client> registerClient(@RequestBody Client client){
        if (utils.isLoginInfoExist(client)){
            return new ResponseEntity<Client>(HttpStatus.NOT_ACCEPTABLE);// Wrong login or password
        }
        Client clientNew = clientRepo.registerClient(client);
        if (clientNew == null) {
            return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST); // Found same login
        }

        return new ResponseEntity<Client>(clientNew, HttpStatus.OK);
    }

}
