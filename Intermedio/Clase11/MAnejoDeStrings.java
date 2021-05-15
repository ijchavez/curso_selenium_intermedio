package Intermedio.Clase11;

public class MAnejoDeStrings {
    public static String INFO = "Juan,Perez,Uruguay,23,QA;Ana,Lopez,Chile,30,Dev;Rocio,Gonzalez,28,Manager,España";

    public static void main(String args[]){
        boolean estaPresente = INFO.contains("Ana");
        System.out.println("esta presente? --> " + estaPresente);

        String replacedString = INFO.replace("a","A");
        System.out.println(replacedString);

        String [] personas = INFO.split(";");
        System.out.println(personas.length);
        for(int i = 0; i < personas.length; i++){
            System.out.println("Persona " + i +": " + personas[i]);
            String[] datosPersonales = personas[i].split(",");
            for(int j = 0; j < datosPersonales.length;j++){
                System.out.println(datosPersonales[j]);

            }

        }

    }

}
