package it.itispaleocapa.crisafullip;
import java.util.HashMap;

public class ContenitoreClienti {
    private HashMap<String, Cliente> clienti = new HashMap<>();

    public void aggiungiCliente(Cliente cliente) {
        clienti.put(cliente.getCodiceCliente(), cliente);
    }

    public void eliminaCliente(String codiceCliente) {
        clienti.remove(codiceCliente);
    }

    public List<Cliente> cercaClientiPerParametri(String cognome, String nome) {
        List<Cliente> risultato = new ArrayList<>();
        for (Cliente cliente : clienti.values()) {
            if (cliente.getCognome().equalsIgnoreCase(cognome) && cliente.getNome().equalsIgnoreCase(nome)) {
                risultato.add(cliente);
            }
        }
        return risultato;
    }

    public void salvaSuFile(String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(clienti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}