package Intermedio.Clase10.Ejemplo2;

public class Auto implements IVehiculo{

    @Override
    public void encender() {
        System.out.println("Se enciende el auto");
    }

    @Override
    public void girar() {
        System.out.println("Se gira el auto");
    }

    @Override
    public void apagar() {
        System.out.println("Se apaga el auto");
    }

    @Override
    public void acelerar() {
        System.out.println("Se acelera el auto");
    }
}
