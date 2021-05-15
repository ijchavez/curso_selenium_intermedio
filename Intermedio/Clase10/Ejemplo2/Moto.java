package Intermedio.Clase10.Ejemplo2;

public class Moto implements IVehiculo{
    @Override
    public void encender() {
        System.out.println("Se enciende la moto");
    }

    @Override
    public void girar() {
        System.out.println("Se gira la moto");
    }

    @Override
    public void apagar() {
        System.out.println("Se apaga la moto");
    }

    @Override
    public void acelerar() {
        System.out.println("Se acelera la moto");
    }
}
