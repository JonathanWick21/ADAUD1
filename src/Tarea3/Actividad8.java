package Tarea3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
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
                    mapa.put(path.getFileName().toString(), mapa.getOrDefault(path.getFileName().toString(), 0) + 1);
                }

                mapa = mapa.entrySet().stream().filter(m -> m.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                int total = mapa.values().stream().mapToInt(Integer::intValue).sum();

                System.out.println("Duplicados (criterio: mismo nombre): " + total + " ficheros");
                mapa.entrySet().stream().forEach(stringIntegerEntry -> System.out.println("\""+stringIntegerEntry.getKey()+"\": " + stringIntegerEntry.getValue() + " ocurrencias"));


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
