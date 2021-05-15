package Intermedio.Clase9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mapas {
    public void main(String args[]){
        HashMap<Integer, String> mapaPersonas = new HashMap<>();
        mapaPersonas.put(111,"Ana Lopez");
        mapaPersonas.put(222,"Juan Perez");
        mapaPersonas.put(333,"Rodrigo Paz");

        System.out.println(mapaPersonas.get(222));

        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("Juan");
        listaNombres.add("Ana");
        listaNombres.add("Maria");
        listaNombres.add("Julia");

        for (String nombre: listaNombres){
            if(nombre.equals("Julia")){
                System.out.println("Se encuenta en el sistema");

            }

        }

    }
}
