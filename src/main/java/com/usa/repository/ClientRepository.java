package com.usa.repository;

import com.usa.model.ClientModel;
import com.usa.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAllClients(){
        return (List<ClientModel>) clientCrudRepository.findAll();
    }

    public Optional<ClientModel> getClient(Integer id){
        return clientCrudRepository.findById(id);
    }

    public ClientModel saveClient(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }

    public boolean deleteClient(Integer id){
        clientCrudRepository.deleteById(id);
        return true;
    }

    public ClientModel updateClient(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }
}
