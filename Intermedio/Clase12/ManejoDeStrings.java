package Intermedio.Clase12;

import java.util.HashMap;

public class ManejoDeStrings {
    public static String PAISES = "Chile, Santiago, Peso Chileno, Argentina, Buenos Aires, Peso Argentino, España, Madrid, Euro, Uruguay, Montevideo, Peso Uruguayo";
    //posicion 1 del string  PAIS, CAPITAL, TIPO MONEDA

    public static void main(String[] args) {

        PAISES = PAISES.replace(", ", ",");

        String [] arregloPaises = PAISES.split(",");

        for (int i = 0; i < arregloPaises.length; i++){
            System.out.println("posicion: " + i + " - " + arregloPaises[i]);

        }
        //ej capitales
        muestroDato(arregloPaises,1,3, "Capitales: ");
        HashMap<String, String> mapaPaisesConCapitales = new HashMap<>();
        for(int i = 0; i< arregloPaises.length; i = i+3){
            mapaPaisesConCapitales.put(arregloPaises[i],arregloPaises[i+1]);

        }
        System.out.println("la capital de Chile es: " + mapaPaisesConCapitales.get("Chile"));
        System.out.println("la capital de España es: " + mapaPaisesConCapitales.get("España"));
        System.out.println("la capital de Argentina es: " + mapaPaisesConCapitales.get("Argentina"));
        System.out.println("la capital de Uruguay es: " + mapaPaisesConCapitales.get("Uruguay"));
        //ej Paises

        muestroDato(arregloPaises,0,3, "Paises: ");
        //ej monedas
        muestroDato(arregloPaises,2,3, "Monedas: ");

        //dado el nombre de un pais quiero recibir la capital

    }
    public static void muestroDato(String[] arreglo, int posicion, int salto, String queObtener){
        for (int i = posicion; i < arreglo.length; i = i + salto){
            System.out.println(queObtener + arreglo[i]);

        }
    }

}
