package tn.esprit.eventsproject.testentities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Participant;
import tn.esprit.eventsproject.entities.Tache;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
public class TestParticipant {
    private Participant participant;

    @BeforeEach
    public void setUp() {
        participant = new Participant();
    }

    @Test
    public void testParticipantCreation() {
        participant.setIdPart(1);
        participant.setNom("Riahi");
        participant.setPrenom("Chedli");
        participant.setTache(Tache.ORGANISATEUR.ORGANISATEUR);

        assertEquals(1, participant.getIdPart());
        assertEquals("Riahi", participant.getNom());
        assertEquals("Chedli", participant.getPrenom());
        assertEquals(Tache.ORGANISATEUR, participant.getTache());
    }

    @Test
    public void testEventsAssociation() {
        Event event = new Event();
        Set<Event> events = new HashSet<>();
        events.add(event);
        participant.setEvents(events);

        assertTrue(participant.getEvents().contains(event));
    }
}
