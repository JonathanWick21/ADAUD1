import com.google.gson.Gson;

import java.util.List;

/*
private String name;
private String email;
private int salary;
private List<String> proyects;

"employee": {
        "name":"Jonathan",
        "email": "pepe@gmail.com",
        "salary": 2000,
        "proyects": ["pepe1", "pepe2", "pepe3"],
        "direccion": {
                "calle": "",
                "fecha": "12-01-2025",
                "isActive": true
    }
 */
class Persona {
    String nombre;
    int edad;
    List<String> hobbies;
    boolean activo;

    public Persona(String nombre, int edad, List<String> hobbies, boolean activo) {
        this.nombre = nombre;
        this.edad = edad;
        this.hobbies = hobbies;
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", hobbies=" + hobbies +
                ", activo=" + activo +
                '}';
    }
}

class Servlet{

}

class WebApp{
    private Servlet servlet;
}
class Server {
    private WebApp webApp;
}

public class SerializarJSON {
    /**
     * {,} --> contiene objeto
     * [] --> lista de algo (array)
     *
     */

    static void main() {
        Gson gson = new Gson();
        Persona p = new Persona("Jonathan", 22, List.of("Beber", "Fumar"), true);
        String json = gson.toJson(p);
        System.out.println(json);

        Persona p2 = gson.fromJson(json, Persona.class);
        System.out.println(p2);
    }
}
