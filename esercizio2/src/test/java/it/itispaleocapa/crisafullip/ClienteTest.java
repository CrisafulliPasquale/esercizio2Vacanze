package it.itispaleocapa.crisafullip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;



public class ClienteTest {
    private Cliente cliente;
    private ContenitoreClienti contClienti;
    private Volo volo;
    private ContenitoreVoli contVoli;
    private Prenotazione prenotazione;

    @BeforeEach
    public void setUp() {
        contClienti = new ContenitoreClienti();
        contVoli = new ContenitoreVoli();

        // Primi test
        cliente = new Cliente("Crisafulli", "Pasquale", "Italia", "Milazzo", "2005-08-25", "COD1");
        contClienti.aggiungiCliente(cliente);
        
        // Terzi test
        volo = new Volo("VOL1", "Bergamo", "New York", "2023-07-12", "08:00", "20:00", 150, 250.0);
        contVoli.aggiungiVolo(volo);

        // Quarti test
        Volo volo1 = new Volo("VOL1", "Bergamo", "Napoli", "2023-09-12", "08:00", "10:00", 150, 250.0);
        Volo volo2 = new Volo("VOL2", "Milano", "Bari", "2023-09-12", "09:00", "11:00", 200, 300.0);
        contVoli.aggiungiVolo(volo1);
        contVoli.aggiungiVolo(volo2);

        // Quinti test
        prenotazione = new Prenotazione("COD1", "VOL1");
    }

    // Primu test
    @Test
    public void testCostruttore() {
        assertEquals("Crisafulli", cliente.getCognome());
        assertEquals("Pasquale", cliente.getNome());
        assertEquals("Italia", cliente.getnazioneNascita());
        assertEquals("Milazzo", cliente.getcittaNascita());
        assertEquals("2005-08-25", cliente.getdataNascita());
        assertEquals("COD1", cliente.getCodiceCliente());
    }

    // Secondi test
    @Test
    public void testAggiungiCliente() {
        Cliente cliente3 = new Cliente("Crisafulli", "Maurizio", "Italia", "Milazzo", "1981-10-09", "COD4");
        contClienti.aggiungiCliente(cliente3);
        assertEquals(1, contClienti.cercaClientiPerParametri("Crisafulli", "Maurizio").size());
    }

    @Test
    public void testEliminaCliente() {
        contClienti.eliminaCliente("COD1");
        assertEquals(0, contClienti.cercaClientiPerParametri("Crisafulli", "Pasquale").size());
    }

    @Test
    public void testCercaClientiPerParametri() {
        assertEquals(1, contClienti.cercaClientiPerParametri("Crisafulli", "Pasquale").size());
        assertEquals(0, contClienti.cercaClientiPerParametri("Bresciani", "Nicola").size());
        assertEquals(0, contClienti.cercaClientiPerParametri("Crisafulli", "Maurizio").size());
    }

    // Terzi test
    @Test
    public void testGetters() {
        assertEquals("VOL1", volo.getCodiceVolo());
        assertEquals("Bergamo", volo.getaeroportoP());
        assertEquals("New York", volo.getaeroportoA());
        assertEquals("2023-07-12", volo.getDataVolo());
        assertEquals("08:00", volo.getoraP());
        assertEquals("20:00", volo.getoraA());
        assertEquals(150, volo.getNumeroPosti());
        assertEquals(250.0, volo.getCostoVolo(), 0.01);
    }

    @Test
    public void testSetters() {
        volo.setaeroportoP("Milano");
        volo.setaeroportoA("Napoli");
        volo.setDataVolo("2023-07-13");
        volo.setoraP("09:00");
        volo.setoraA("11:00");
        volo.setNumeroPosti(200);
        volo.setCostoVolo(100.0);

        assertEquals("Milano", volo.getaeroportoP());
        assertEquals("Napoli", volo.getaeroportoA());
        assertEquals("2023-07-13", volo.getDataVolo());
        assertEquals("09:00", volo.getoraP());
        assertEquals("11:00", volo.getoraA());
        assertEquals(200, volo.getNumeroPosti());
        assertEquals(100.0, volo.getCostoVolo(), 0.01);
    }

    @Test
    public void testModificaDatiVolo() {
        volo.modificaDati("Milano", "Bari", "2023-07-13", "09:00", "11:00", 200, 50.0);

        assertEquals("Milano", volo.getaeroportoP());
        assertEquals("Bari", volo.getaeroportoA());
        assertEquals("2023-07-13", volo.getDataVolo());
        assertEquals("09:00", volo.getoraP());
        assertEquals("11:00", volo.getoraA());
        assertEquals(200, volo.getNumeroPosti());
        assertEquals(50.0, volo.getCostoVolo(), 0.01);
    }

    // Quarti test
    @Test
    public void testAggiungiVolo() {
        Volo volo3 = new Volo("VOL3", "Londra", "Berlino", "2023-09-13", "10:00", "12:00", 180, 280.0);
        contVoli.aggiungiVolo(volo3);
        assertEquals(3, contVoli.size());
    }

    @Test
    public void testEliminaVolo() {
        contVoli.eliminaVolo("VOL1");
        assertEquals(1, contVoli.size());
    }

    @Test
    public void testCercaVoloPerCodice() {
        Volo volo = contVoli.cercaVoloPerCodice("VOL2");
        assertEquals("VOL2", volo.getCodiceVolo());
    }

    @Test
    public void testCercaVoliPerParametri() {
        assertEquals(1, contVoli.cercaVoliPerParametri("2023-09-12", "Bergamo", "Napoli", "08:00").size());
        assertEquals(0, contVoli.cercaVoliPerParametri("2023-09-13", "Bergamo", "Napoli", "08:00").size());
        assertEquals(1, contVoli.cercaVoliPerParametri("2023-09-12", "Milano", "Bari", "09:00").size());
    }

    // Quinti test
    @Test
    public void testAggiungiPrenotazione() {
        Prenotazione nuovaPrenotazione = new Prenotazione("COD2", "VOL2");
        prenotazione.aggiungiPrenotazione(nuovaPrenotazione);
        assertEquals(1, prenotazione.getPrenotazioni().size());
    }

    @Test
    public void testRimuoviPrenotazioneCodiceClienteECodiceVolo() {
        Prenotazione prenotazioneDaRimuovere = new Prenotazione("COD2", "VOL2");
        prenotazione.aggiungiPrenotazione(prenotazioneDaRimuovere);
        prenotazione.rimuoviPrenotazioneCodiceClienteECodiceVolo("VOL2", "COD2");
        assertEquals(0, prenotazione.getPrenotazioni().size());
    }

    @Test
    public void testAggiungiBagaglio() {
        prenotazione.aggiungiBagaglio(20.0);
        assertEquals(1, prenotazione.getBagagli().size());
    }

    public @interface Before {

    }

}
