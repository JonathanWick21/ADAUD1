package Tarea3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce una ruta: ");
        Path ruta = Path.of(scan.nextLine());

        Map<String, Integer> mapa = new HashMap<>();


        if (!Files.exists(ruta))
            System.out.println("No existe la ruta introducida");
        else {
            try (Stream<Path> stream = Files.walk(ruta)){

                List<Path> paths = stream.toList();

                for (Path path: paths){
                    mapa.put(path.getFileName().toString(), mapa.getOrDefault(path, 0) + 1);
                }

                mapa.entrySet().stream().filter()

                System.out.println("Duplicados (criterio: mismo nombre): " + );


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
