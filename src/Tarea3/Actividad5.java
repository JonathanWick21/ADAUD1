package Tarea3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce la ruta base");
        Path ruta = Path.of(scan.nextLine());

        try (Stream<Path> stream = Files.walk(ruta)) {
            stream.filter(Files::isDirectory)
                    .filter(path -> !path.equals(ruta))
                    .filter(path -> {
                        try (Stream<Path> hijos = Files.list(path)){
                            return !hijos.findAny().isPresent();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println(path + " borrado");
                        } catch (IOException e) {
                            System.err.println("No se puedo borrar " + path);
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
