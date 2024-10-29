package tn.esprit.eventsproject.testentities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.eventsproject.entities.Logistics;

import static org.junit.jupiter.api.Assertions.*;


public class TestLogistics {
    private Logistics logistics;

    @BeforeEach
    public void setUp() {
        // Créer une nouvelle instance de Logistics avant chaque test
        logistics = new Logistics();
    }

    @Test
    public void testLogisticsCreation() {
        // Vérifie que les attributs de Logistics peuvent être définis et récupérés
        logistics.setIdLog(1);
        logistics.setDescription("Sound System");
        logistics.setReserve(true);
        logistics.setPrixUnit(200.0f);
        logistics.setQuantite(5);

        assertEquals(1, logistics.getIdLog());
        assertEquals("Sound System", logistics.getDescription());
        assertTrue(logistics.isReserve());
        assertEquals(200.0f, logistics.getPrixUnit());
        assertEquals(5, logistics.getQuantite());
    }

    @Test
    public void testUpdateQuantite() {

        logistics.setQuantite(10);
        assertEquals(10, logistics.getQuantite());

        logistics.setQuantite(15);
        assertEquals(15, logistics.getQuantite());
    }

    @Test
    public void testUpdatePrixUnit() {

        logistics.setPrixUnit(150.0f);
        assertEquals(150.0f, logistics.getPrixUnit());

        logistics.setPrixUnit(175.0f);
        assertEquals(175.0f, logistics.getPrixUnit());
    }
}
