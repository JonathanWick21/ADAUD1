import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

    class Employee implements Serializable {
        //private final static long serialVersionUID
        private String name;
        private String email;
        private int salary;
        private List<String> proyects;

        public Employee(String name, String email, int salary, List<String> proyects){
            this.name = name;
            this.email = email;
            this.salary = salary;
            this.proyects = proyects;
        }
    }





public class Serializacion {

    public static void main(String[] args) {
        Employee employee = new Employee("Jonathan", "jonvilmor@alu.edu.gva.es", 2000, List.of("ada", "psp"));

        try (ObjectOutputStream os =
                     new ObjectOutputStream(Files.newOutputStream(Path.of("files/employee.dat")))) {
            os.writeObject(employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
