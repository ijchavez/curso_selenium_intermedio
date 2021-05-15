package Intermedio.Clase12;

public class Persona {

    private String pais;
    private String nombre;
    private int dni = 0;
    private String email;

    public Persona (String unPais, String unNombre, int unDni, String unEmail){
        this.pais = unPais;
        this.nombre = unNombre;
        this.dni = unDni;
        this.email = unEmail;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getPais(){
        return this.pais;
    }
    public Integer getDni(){
        return this.dni;

    }
    public String getEmail(){
        return this.email;
    }
    public void setPais(String unPais){
        this.pais = unPais;

    }
    public void setNombre(String unNombre){
        this.nombre = unNombre;

    }
    public void setDni(int unDni){
        this.dni = unDni;

    }
    public void setEmail(String unEmail){
        this.email = unEmail;

    }



}
