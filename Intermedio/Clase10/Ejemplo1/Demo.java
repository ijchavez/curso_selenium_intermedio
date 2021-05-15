package Intermedio.Clase10.Ejemplo1;

public class Demo implements MyInterface{
    @Override
    public void metodo1() {
        System.out.println("este es el metodo 1");
    }

    @Override
    public void metodo2() {
        System.out.println("este es el metodo 2");

    }

    @Override
    public void metodo3(int x, int y) {
        int z = x + y;
        System.out.println("este es el metodo 3, resultado: " + z );

    }
    //@override >> los metodos son sobreescritos desde la interfaz, los voy a pisar
    //y quiero que se use lo que va dentro del metodo

}
