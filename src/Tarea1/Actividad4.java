package Tarea1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Actividad4 {
    public static void main(String[] args) {

        Path proyecto = Paths.get("./proyecto");
        Path source = proyecto.resolve("src");
        Path documents = proyecto.resolve("docs");
        Path resources = proyecto.resolve("resources");
        Path readMe = documents.resolve("README.txt");

        List<Path> carpetas = new ArrayList<>();
        carpetas.add(proyecto);
        carpetas.add(source);
        carpetas.add(documents);
        carpetas.add(resources);
        carpetas.add(readMe);

        for (Path path: carpetas){
            if (!Files.exists(path))
                try {
                    Files.createDirectory(path);
                    System.out.println("Se ha creado la carpeta: " + path.getFileName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            else {
                System.out.println("La carpeta ya existia");
            }
        }
    }
}
