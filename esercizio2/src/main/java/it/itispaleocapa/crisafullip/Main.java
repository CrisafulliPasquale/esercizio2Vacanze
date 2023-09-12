package it.itispaleocapa.crisafullip;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Crisafulli", "Pasquale", "Italia", "Milazzo", "25/08/2005", "C001");
        Volo volo = new Volo("V001", "Bergamo", "Roma", "01/10/2023", "08:00", "10:00", 150, 120.0);

        cliente.setCognome("Loda");
        cliente.setNome("Matilde");
        cliente.setNazione("Italia");
        cliente.setCitta("Brescia");
        cliente.setDataNascita("30/07/2006");

        volo.setaeroportoP("Bergamo");
        volo.setaeroportoA("Napoli");
        volo.setDataVolo("16/10/2023");
        volo.setoraP("09:00");
        volo.setoraA("11:00");
        volo.setNumeroPosti(180);
        volo.setCostoVolo(150.0);

        System.out.println("Dati del cliente: " + cliente.getNome() + " " + cliente.getCognome());
        System.out.println("Dati del volo: " + volo.getCodiceVolo() + " " + volo.getaeroportoP() + " - " + volo.getaeroportoA());
    }
}
