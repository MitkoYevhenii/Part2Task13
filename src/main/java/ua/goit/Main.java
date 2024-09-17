package ua.goit;


import ua.goit.entity.client.Client;
import ua.goit.entity.client.ClientService;
import ua.goit.entity.planet.PlanetService;
import ua.goit.storage.FlywayService;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        PlanetService planetService = new PlanetService();

        FlywayService.initDataBase();

        // Create Clients
        Client client1 = new Client();
        client1.setName("John Doe");
        clientService.createClient(client1);

        Client client2 = new Client();
        client2.setName("Jane Smith");
        clientService.createClient(client2);
    }
}

