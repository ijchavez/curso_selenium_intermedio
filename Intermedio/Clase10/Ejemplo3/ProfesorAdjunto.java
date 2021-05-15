package Intermedio.Clase10.Ejemplo3;

public class ProfesorAdjunto implements IProfesor{

    // hago el implements y sobreescribo los metodos
    @Override
    public void mostrarNombre(String unNombre) {
        System.out.println("Este es el nombre del profesor " + unNombre);
    }

    @Override
    public void mostrarDNI(int unDni) {
        System.out.println("Este es el DNI del profesor " + unDni);
    }

    @Override
    public void obtenerSalario(float unSalario) {
        System.out.println("Este es el salario del profesor " + unSalario);
    }

    @Override
    public void obtenerMateria(String unaMateria) {
        System.out.println("Esta es la materia asignada " + unaMateria);
    }
}
