package Intermedio.Clase10.Ejemplo3;

public class Colegio {
    //creo una clase para ejecutar los metodos
    public static void main(String[] args) {
        IProfesor profeQuimica = new ProfesorAdjunto();
        profeQuimica.obtenerMateria("Quimica");
        profeQuimica.obtenerSalario(1300);
        profeQuimica.mostrarNombre("Juan");
        profeQuimica.mostrarDNI(35126912);

        IAlumno alumno = new AlumnoUniversitario();
        alumno.calcularPromedio(7);
        alumno.obtenerCurso("Historia");
    }
}
