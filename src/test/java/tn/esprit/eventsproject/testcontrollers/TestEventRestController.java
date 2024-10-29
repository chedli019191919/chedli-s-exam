package tn.esprit.eventsproject.testcontrollers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.eventsproject.controllers.EventRestController;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Logistics;
import tn.esprit.eventsproject.entities.Participant;
import tn.esprit.eventsproject.services.IEventServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestEventRestController {
    @InjectMocks
    private EventRestController eventRestController;

    @Mock
    private IEventServices eventServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddParticipant() {
        // Arrange
        Participant participant = new Participant();
        when(eventServices.addParticipant(participant)).thenReturn(participant);

        // Act
        Participant result = eventRestController.addParticipant(participant);

        // Assert
        assertEquals(participant, result);
        verify(eventServices).addParticipant(participant);
    }

    @Test
    public void testAddEvent() {
        // Arrange
        Event event = new Event();
        when(eventServices.addAffectEvenParticipant(event)).thenReturn(event);

        // Act
        Event result = eventRestController.addEvent(event);

        // Assert
        assertEquals(event, result);
        verify(eventServices).addAffectEvenParticipant(event);
    }

    @Test
    public void testAddEventPart() {
        // Arrange
        Event event = new Event();
        int participantId = 1;
        when(eventServices.addAffectEvenParticipant(event, participantId)).thenReturn(event);

        // Act
        Event result = eventRestController.addEventPart(event, participantId);

        // Assert
        assertEquals(event, result);
        verify(eventServices).addAffectEvenParticipant(event, participantId);
    }

    @Test
    public void testAddAffectLog() {
        // Arrange
        Logistics logistics = new Logistics();
        String description = "Sample Event";
        when(eventServices.addAffectLog(logistics, description)).thenReturn(logistics);

        // Act
        Logistics result = eventRestController.addAffectLog(logistics, description);

        // Assert
        assertEquals(logistics, result);
        verify(eventServices).addAffectLog(logistics, description);
    }

    @Test
    public void testGetLogistiquesDates() {
        // Arrange
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 31);
        List<Logistics> logisticsList = new ArrayList<>();
        when(eventServices.getLogisticsDates(startDate, endDate)).thenReturn(logisticsList);

        // Act
        List<Logistics> result = eventRestController.getLogistiquesDates(startDate, endDate);

        // Assert
        assertEquals(logisticsList, result);
        verify(eventServices).getLogisticsDates(startDate, endDate);
    }
}
