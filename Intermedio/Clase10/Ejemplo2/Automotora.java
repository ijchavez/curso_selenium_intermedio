package Intermedio.Clase10.Ejemplo2;

public class Automotora {
    public static void main(String[] args) {
        IVehiculo automovil = new Auto();
        IVehiculo motocicleta = new Moto();

        automovil.encender();
        automovil.acelerar();
        automovil.acelerar();
        automovil.apagar();

        motocicleta.encender();
        motocicleta.acelerar();
        motocicleta.acelerar();
        motocicleta.apagar();

        /***
         * go to
         *    >> declaration --> interfaz
         *    >> implementation --> clase
         *
         */



    }
}
