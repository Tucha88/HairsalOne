package hairsalon.services;

import hairsalon.client.Client;
import hairsalon.client.ClientAuthType;
import hairsalon.client.repository.IClientRepo;
import hairsalon.master.Master;
import hairsalon.master.MasterAuthType;
import hairsalon.master.repository.IMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Boris on 05.04.2017.
 */
@Controller
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IClientRepo clientRepo;
    @Autowired
    private IMasterRepo masterRepo;
    @PostMapping("/master")
    public ResponseEntity<Master> loginMaster(@RequestBody MasterAuthType authType) {
        if (authType.getEmail().equals("") || authType.getEmail() == null || authType.getPassword().equals("") || authType.getPassword() == null){
            return new ResponseEntity<Master>(HttpStatus.NOT_ACCEPTABLE);// Wrong login or password
        }
        Master master = masterRepo.loginMaster(authType);
        if (master == null) {
            return new ResponseEntity<Master>(HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<Master>(master, HttpStatus.OK);
    }
    @PostMapping("/client")
    public ResponseEntity<Client> liginClient(@RequestBody ClientAuthType authType){
        if (authType.getClientEmail().equals("") || authType.getClientEmail() == null || authType.getClientPassword().
                equals("") || authType.getClientPassword() == null){
            return new ResponseEntity<Client>(HttpStatus.NOT_ACCEPTABLE);// Wrong login or password
        }
        Client client = clientRepo.loginClient(authType);
        if (client == null) {
            return new ResponseEntity<Client>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
}
