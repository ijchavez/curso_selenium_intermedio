package Intermedio.Clase10.Ejemplo1;

public class Sistema {
    public static void main(String [] args){
        System.out.println("***** INTERFACES *****");
        MyInterface obj = new Demo();
        obj.metodo1();
        obj.metodo2();
        obj.metodo3(3,5);

    }
}
