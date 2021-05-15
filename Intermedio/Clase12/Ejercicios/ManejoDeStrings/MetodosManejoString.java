package Intermedio.Clase12.Ejercicios.ManejoDeStrings;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MetodosManejoString {
    public static void main(String[] args) {
        List<String> listaMails = new ArrayList<>();
        listaMails.add("equipo-test@test.com");
        listaMails.add("equipo-dev@dev.com");
        listaMails.add("equipo-uat@uat.com");
        listaMails.add("equipo-plara@mail.com");

        validate(listaMails,"endsWith",".com");
        validate(listaMails,"contains","@");
        validate(listaMails,"startsWith","equipo");


        String unMail = obtenerDeUnaLista(listaMails,0);

        positionOfAt(unMail,"@");


        String mensaje = "Este es un mensaje para probar el replace";
        String mensajeReemplazado = mensaje.replace("a","e");
        System.out.println("Mensaje original: "+ mensaje);
        System.out.println("Mensaje con replace: " + mensajeReemplazado);

        System.out.println("Substring >>> " + mensaje.substring(4,10));

        String informacion = "Este es un String donde VoY a ChEqUeAr el UpPer CASE y LOweR CAse";
        String minusculas = informacion.toLowerCase();
        String mayusculas = informacion.toUpperCase();
        System.out.println(informacion);
        System.out.println(minusculas);
        System.out.println(mayusculas);


    }
    public static void validate(List<String> emailList, String queValidar, String unValor){
        for (String mail : emailList) {
            if (queValidar.equals("contains")){
                if (mail.contains(unValor) == false) {

                    Assert.assertFalse(true);
                }
            }
            else if(queValidar.equals("endsWith")){
                if (mail.endsWith(unValor) == false) {

                    Assert.assertFalse(true);
                }

            }
            else if(queValidar.equals("startsWith")){
                if (mail.startsWith(unValor) == false) {

                    Assert.assertFalse(true);
                }

            }

        }

    }
    public static void positionOfAt(String email, String caracter){
        int i = email.indexOf(caracter);
        String mensaje = "El caracter " + caracter + " está posicionado en: " + i;
        System.out.println(mensaje);

    }
    public static String obtenerDeUnaLista(List<String> unaLista, int unaPosicion){
        String unValor = "";
        try{
            unValor = unaLista.get(unaPosicion);
        }catch(Exception e){
            System.out.println("No existe valor para esa posicion");
        }
        return unValor;
    }
}
