import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Actividad2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Path ruta = Path.of(scan.nextLine());

        if (Files.exists(ruta) && Files.isRegularFile(ruta)) {
            System.out.println("¿Estas seguro que quieres eliminarlo? (Y/N)");
            String respuesta = scan.nextLine();

            if (respuesta.equals("Y"))
                try{
                    Files.delete(ruta);
                    System.out.println("Fichero eliminado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                    System.out.println("Ha habido un error en la eliminación del fichero");
                }
            else if (respuesta.equals("N")){
                System.out.println("Cancelando...");
            }
            else
                System.out.println("Error, elige una opción correcta");
        }
        else
            System.out.println("No existe el fichero");
    }
}
