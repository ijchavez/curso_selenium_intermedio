package Intermedio.Clase12.Ejercicios.ManejoDeStrings;

import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Concat {
    public static void main(String[] args) {
        String nombre1 = "Juan";
        String nombre2 = "Jorge";
        String nombre3 = "Fabiana";

        String nombreCompleto = nombre1.concat(nombre2).concat(nombre3);
        System.out.println(nombreCompleto);


    }

}
