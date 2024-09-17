package ua.goit.entity.client;

import lombok.Data;

import java.util.List;

@Data
public class ClientService extends ClientCrudService {

    // Метод для создания нового клиента
    public void createClient(Client client) {
        save(client);  // Вызов метода сохранения из ClientCrudService
    }

    // Метод для получения клиента по его ID
    public Client readClient(Long clientId) {
        return findById(clientId);  // Вызов метода поиска по ID
    }

    // Метод для получения списка всех клиентов
    public List<Client> readAllClients() {
        return readAll();  // Вызов метода для получения всех клиентов
    }

    // Метод для обновления информации о клиенте
    public void updateClient(Client client) {
        update(client);  // Вызов метода обновления из ClientCrudService
    }

    // Метод для удаления клиента
    public void deleteClient(Client client) {
        delete(client);  // Вызов метода удаления из ClientCrudService
    }

    public void deleteClientById(long id) {
        deleteById(id);
    }
}

