package Intermedio.Clase13.CSV;

import Intermedio.Clase13.Persona;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV_Helper {

    public static List<Persona> LISTA_PERSONAS = new ArrayList<>();

    public static void loadpeopleFromCSV() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader("dataloader/email.csv"));
        //meto un contador para saltear la cabecera del archivo

        String[] fila;
        int cabecera = 0;
        while((fila=reader.readNext()) != null){
            if (cabecera != 0){
                //System.out.println("--> " + fila[0]);
                for(int i = 0; i < fila.length; i++){
                    String infoDePersona = fila[i];
                    //System.out.println(infoDePersona);
                    procesarDatos(infoDePersona);

                }

            }
            cabecera++;

        }

    }
    public static List<String> getDataFromCSV(String filename) throws IOException, CsvValidationException {
        Assert.assertTrue(filename.endsWith(".csv"));
        CSVReader reader = new CSVReader(new FileReader(filename));
        //meto un contador para saltear la cabecera del archivo
        int cabecera = 0;
        String[] fila;
        List<String> csvData = new ArrayList<>();

        while((fila=reader.readNext()) != null){
            if (cabecera != 0){
                //System.out.println("--> " + fila[0]);
                for(int i = 0; i < fila.length; i++){
                    String datosDeLaFila = fila[i];
                    //System.out.println(infoDePersona);
                    csvData.add(datosDeLaFila);

                }

            }
            cabecera++;

        }
        return csvData;

    }
    public static void procesarDatos(String datosPersonales){
        String[] datos = datosPersonales.split(";");
        String email = datos[0];
        String identificador = datos[1];
        String firstName = datos[2];
        String lastName = datos[3];
        String fullName = firstName.concat(" ").concat(lastName);

        Persona pers = new Persona( "Argentina", fullName, Integer.parseInt(identificador), email);
        LISTA_PERSONAS.add(pers);

        System.out.println(">>> " + pers);

    }

}
