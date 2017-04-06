package hairsalon.client.repository;

import hairsalon.client.Client;
import hairsalon.client.ClientAuthType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Boris on 06.04.2017.
 */
public interface IClientRepo {
    public Client registerClient(Client addClient);
    public Client getClientInfo(Client client);
    public Client loginClient(ClientAuthType updateClient);
    public String deliteClient(Client removeClient);
    public List<Client> getAllClientsInfo();
    public Client updateClientInfo(Client Client);
  
}
