package Tarea3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce una ruta");
        Path ruta = Path.of(scanner.nextLine());

        Map<String, Integer> mapa = new HashMap<>();

        try (Stream<Path> stream = Files.walk(ruta)){
            stream.filter(p -> Files.isRegularFile(p))
                    .forEach(path -> {
                        int index = path.getFileName().toString().lastIndexOf(".");
                        if (index >0){
                            String extension = path.getFileName().toString().substring(index);
                            mapa.put(extension, (mapa.getOrDefault(extension, 0) + 1));
                        }
                    });
            mapa.entrySet().stream().forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
