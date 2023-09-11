package it.itispaleocapa.crisafullip;

import java.text.SimpleDateFormat;
import java.util.Random;

public class Cliente {
    private String cognome;
    private String nome;
    private String nazioneNascita;
    private String cittaNascita;
    private String dataNascita;
    private String codiceCliente;

    public Cliente(String cognome, String nome, String nazioneNascita, String cittaNascita, String dataNascita) {
        this.cognome = cognome;
        this.nome = nome;
        this.nazioneNascita = nazioneNascita;
        this.cittaNascita = cittaNascita;
        this.dataNascita = dataNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getnazioneNascita() {
        return nazioneNascita;
    }

    public String getcittaNascita() {
        return cittaNascita;
    }

    public String getdataNascita() {
        return dataNascita;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNazione(String nazione) {
        this.nazioneNascita = nazione;
    }

    public void setCitta(String citta) {
        this.cittaNascita = citta;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setCodice(String codice) {
        this.codiceCliente = codice;
    }
    
    private String generaCodiceCliente() {
        
        String inizialiNome = nome.substring(0, 2).toUpperCase();
        String inizialiCognome = cognome.substring(0, 2).toUpperCase();

        String sdf = new SimpleDateFormat("ddMMyyyy").format(dataNascita);
        String dataNascitaCod = sdf.substring(0, 2);

        Random random = new Random();
        int numeroCasuale = random.nextInt(900) + 100;

        codiceCliente = inizialiCognome + inizialiNome + dataNascitaCod  + numeroCasuale;

        return codiceCliente;
    }

    public void modificaDati(String cognome, String nome, String nazioneNascita, String cittaNascita, String dataNascita) {
        this.cognome = cognome;
        this.nome = nome;
        this.nazioneNascita = nazioneNascita;
        this.cittaNascita = cittaNascita;
        this.dataNascita = dataNascita;
    }
}
