package Recursividad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Class.Habitacion;
import Database.GestorBD;


public class Recursividad {
    private static void combinacionesR(List<List<Habitacion>> result, List<Habitacion> elementos, double disponible,double sobranteMax,List<Habitacion> temp) {
           if (disponible < 0) {
               return; 
           } else if (disponible < sobranteMax) {
               Comparator<Habitacion> comp = (f1, f2) -> { return f1.getCod().compareTo(f2.getCod()); };
               Collections.sort(temp,comp);
               
               if (!result.contains(temp)) {
                   result.add(new ArrayList<>(temp));          
               }
           } else {
               for(Habitacion h : elementos) {
                   temp.add(h);
                   combinacionesR(result, elementos, disponible-h.getPrecio(), sobranteMax, temp);
                   temp.remove(temp.size()-1);
               }
           }
       }
       
       public static List<List<Habitacion>> combinaciones(List<Habitacion> elementos, double disponible, double sobranteMax) {
           List<List<Habitacion>> result = new ArrayList<>();
           combinacionesR(result, elementos, disponible, sobranteMax, new ArrayList<>());
           return result;
       }
       
       public static void main(String[] args) {
           GestorBD gb = new GestorBD();
           List<Habitacion> elementos = new ArrayList<>();
           for(Habitacion h: gb.loadHabitacionCSV().values()) {
               elementos.add(h);
           }
           while(elementos.size()>10) {
               elementos.remove(0);
           }
           double disponible = 150;
           double sobranteMax = 10;
           
           List<List<Habitacion>> result = combinaciones(elementos, disponible, sobranteMax);
           
           System.out.println(String.format("Combinaciones de menos de %.2f€ y sobrante máximo de %.2f€", disponible, sobranteMax));
           result.forEach(r -> System.out.println(r));
           
       }

}
