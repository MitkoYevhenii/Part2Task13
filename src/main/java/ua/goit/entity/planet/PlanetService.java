package ua.goit.entity.planet;

import lombok.Data;

import java.util.List;

@Data
public class PlanetService extends PlanetCrudService{

    public void savePlanet(Planet planet) {
        save(planet);
    }

    public Planet findPlanetById(long id) {
        return findById(id);
    }

    public List<Planet> readAllPlanet(){
        return readAll();
    }

    public void updatePlanet(Planet planet) {
        update(planet);
    }

    public void deletePlanet(Planet planet) {
        delete(planet);
    }
    public void deletePlanetById(long id) {
        deleteById(id);
    }
}
