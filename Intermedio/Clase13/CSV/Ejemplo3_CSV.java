package Intermedio.Clase13.CSV;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class Ejemplo3_CSV {
    public static void main(String[] args) throws IOException, CsvValidationException {
        List<String> datosCSV = CSV_Helper.getDataFromCSV("dataloader/email.csv");

        for (String dato : datosCSV){
            System.out.println("--> " + dato);
        }

    }

}
