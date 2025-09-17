package Tarea1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Actividad3 {
    public static void main(String[] args) {
        Path rutaPruebas = Paths.get("./pruebas");

        Path rutaRespaldo = Paths.get("./respaldo");


        //Para crear la carpeta respaldo si esta no existe
        if (!Files.exists(rutaRespaldo) && !Files.isDirectory(rutaRespaldo)){
            try {
                Files.createDirectory(rutaRespaldo);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(rutaPruebas)){
            for (Path path: stream){
                Files.copy(path, rutaRespaldo.resolve(path.getFileName()));
            } // ./pruebas/hola1.txt ./respaldo/hola1.txt
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
