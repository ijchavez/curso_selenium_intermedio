package Intermedio.Clase12.Ejercicios.Mapas;

import java.util.HashMap;
import java.util.Map;

public class Mapas {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(0,"Santiago");
        map.put(1,"Buenos Aires");
        map.put(2,"Montevideo");
        map.put(3,"Bogota");
        map.put(4,"CDMX");

        for(int i = 0; i < map.size(); i++){
            System.out.println("Posicion " + i + " : " + map.get(i));

        }
        //Mostrar clave y valor
        for (Map.Entry m : map.entrySet()){
            System.out.println("Clave: " + m.getKey() + " Valor: " + m.getValue());

        }
        //Agregar
        map.put(1, "Madrid");
        //Remover
        map.remove(2);
        for(int i = 0; i < map.size(); i++){
            System.out.println("Posicion " + i + " : " + map.get(i));

        }
    }
}
