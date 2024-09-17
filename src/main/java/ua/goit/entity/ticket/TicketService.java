package ua.goit.entity.ticket;

import lombok.Data;

import java.util.List;

@Data
public class TicketService extends TicketCrudService {
    public void saveTicked(Ticket ticket) {
        save(ticket);
    }

    public Ticket findTicketById(long id) {
        return findById(id);
    }

    public List<Ticket> readAllTicket() {
        return readAll();
    }

    public void updateTicket(Ticket ticket) {
        update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        delete(ticket);
    }

    public void deleteTicketById(long id) {
        deleteById(id);
    }
}
