package ua.goit.entity.ticket;

import jakarta.persistence.*;
import lombok.Data;
import ua.goit.entity.client.Client;
import ua.goit.entity.planet.Planet;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "to_planet_id", nullable = false)
    private Planet toPlanetId;
}
