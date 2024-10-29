package tn.esprit.eventsproject.testentities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Logistics;
import tn.esprit.eventsproject.entities.Participant;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestEvent {
    private Event event;

    @BeforeEach
    public void setUp() {

        event = new Event();
    }

    @Test
    public void testEventCreation() {

        event.setIdEvent(1);
        event.setDescription("Concert");
        event.setDateDebut(LocalDate.of(2024, 5, 1));
        event.setDateFin(LocalDate.of(2024, 5, 2));
        event.setCout(150.0f);

        assertEquals(1, event.getIdEvent());
        assertEquals("Concert", event.getDescription());
        assertEquals(LocalDate.of(2024, 5, 1), event.getDateDebut());
        assertEquals(LocalDate.of(2024, 5, 2), event.getDateFin());
        assertEquals(150.0f, event.getCout());
    }

    @Test
    public void testParticipantsAssociation() {

        Participant participant = new Participant();
        Set<Participant> participants = new HashSet<>();
        participants.add(participant);
        event.setParticipants(participants);

        assertTrue(event.getParticipants().contains(participant));
    }

    @Test
    public void testLogisticsAssociation() {

        Logistics logistics = new Logistics();
        Set<Logistics> logisticsSet = new HashSet<>();
        logisticsSet.add(logistics);
        event.setLogistics(logisticsSet);

        assertTrue(event.getLogistics().contains(logistics));
    }
}
