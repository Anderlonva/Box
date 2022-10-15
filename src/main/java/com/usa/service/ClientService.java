package com.usa.service;

import com.usa.model.BoxModel;
import com.usa.model.ClientModel;
import com.usa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients(){
        return (List<ClientModel>) clientRepository.getAllClients();
    }

    public Optional<ClientModel> getClient(Integer id){
        return clientRepository.getClient(id);
    }

    public ClientModel saveClient(ClientModel clientModel){
        if (clientModel.getIdClient() == null){
            return  clientRepository.saveClient(clientModel);
        }else {
            Optional<ClientModel> optional= clientRepository.getClient(clientModel.getIdClient());
            if (optional.isEmpty()){
                return clientRepository.saveClient(clientModel);
            }else {
                return clientModel;
            }
        }
    }

    public boolean deleteClient(Integer id){
        Boolean aBoolean = getClient(id).map(c -> {
            clientRepository.deleteClient(c.getIdClient());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public ClientModel updateClient(ClientModel clientModel){
        if (clientModel.getIdClient() != null) {
            Optional<ClientModel> optional = clientRepository.getClient(clientModel.getIdClient());
            if (!optional.isEmpty()){
                if (clientModel.getEmail() != null) {
                    optional.get().setEmail(clientModel.getEmail());
                }
                if (clientModel.getPassword() != null) {
                    optional.get().setPassword(clientModel.getPassword());
                }
                if (clientModel.getName() != null) {
                    optional.get().setName(clientModel.getName());
                }
                if (clientModel.getAge() != null) {
                    optional.get().setAge(clientModel.getAge());
                }
                clientRepository.saveClient(optional.get());
                return optional.get();
            }else {
                return clientModel;
            }
        }else {
            return clientModel;
        }
    }
}
