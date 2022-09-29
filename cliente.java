public class cliente {
    
    public String nombre;
    public int edad;

    public cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public cliente () {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    

}
