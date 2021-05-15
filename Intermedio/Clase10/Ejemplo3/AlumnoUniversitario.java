package Intermedio.Clase10.Ejemplo3;

public class AlumnoUniversitario implements IAlumno{

    @Override
    public void obtenerCurso(String unCurso) {
        System.out.println("Nombre del alumno " + unCurso);
    }

    @Override
    public void calcularPromedio(float unPromedio) {
        System.out.println("Promedio del alumno " + unPromedio);
    }

    @Override
    public void mostrarNombre(String unNombre) {
        System.out.println("Este es el nombre del alumno " + unNombre);
    }

    @Override
    public void mostrarDNI(int unDni) {
        System.out.println("Este es el DNI del alumno " + unDni);
    }
}
