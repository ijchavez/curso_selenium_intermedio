package Intermedio.Clase13.CSV;

import Intermedio.Clase13.Persona;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ejemplo2_CSV {

    // < clave , valor>
    public static HashMap<Integer, Persona> ID_PERSONMAP = new HashMap<>();

    public static void main(String[] args) throws IOException, CsvValidationException {
        CSV_Helper.loadpeopleFromCSV();
        List<Persona> listaPersonas = CSV_Helper.LISTA_PERSONAS;
        System.out.println("Cant. personas: " + listaPersonas.size());

        for(Persona pers : listaPersonas){
            ID_PERSONMAP.put(pers.getDni(), pers);

        }
        int dni = 0;
        devuelvoMedianteIngresoDNI(dni);


    }
    public static void devuelvoMedianteIngresoDNI(int unDni){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese DNI");
        unDni = input.nextInt();
        System.out.println("Los datos son: ");
        System.out.println(ID_PERSONMAP.get(unDni));

    }

}
