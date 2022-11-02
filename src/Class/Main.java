package Class;

import Database.DB;

public class Main {
    public static void main(String[] args) {
        DB.initBD("KahalaHotel.db");
        //DB.insertarCliente("784503S", "Asier", "Martínez", "asier123", "17/03/1998");
        DB.closeBD();
        
    }
}
