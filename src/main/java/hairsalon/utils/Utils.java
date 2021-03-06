package hairsalon.utils;

import hairsalon.client.Client;
import hairsalon.master.Master;
import org.springframework.stereotype.Service;

/**
 * Created by Boris on 06.04.2017.
 */
@Service
public class Utils implements IUtils {
    @Override
    public Boolean isLoginInfoExist(Object obj) {
        if (obj instanceof Master){
            Master master = (Master) obj;
            if (master.getEmail().equals("") || master.getEmail() == null || master.getPassword().equals("") || master.getPassword() == null){
                return true;// Wrong login or password
            }
        }else if (obj instanceof Client){
            Client client = (Client) obj;
        }
        return false;
    }
}
