import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestRecorrerDir {
    public static void main(String[] args){
        /**
         * Recorrer directorios
         * -Files.list --> no entra en subdirectorios, se queda en el primer nivel
         * -Files.walk --> entra en subdirectorios, se puede especificar el nivel
         * -Files.find --> entra en subdirectorios, permite buscar
         */
//        try(Stream<Path> stream = Files.find(Path.of("."), Integer.MAX_VALUE,
//                (p , attr ) -> attr.isRegularFile())){
//            long ficherosJava= stream
//                    .filter(path -> path.toString().endsWith(".java"))
//                    .count();
//            System.out.println(ficherosJava);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
        try (Stream<Path> stream = Files.walk(Path.of("./"))) {
            stream
                    .filter(path -> Files.isDirectory(path))
                    .forEach(path -> {
                        try (Stream<Path> stream1 = Files.list(path)){
                            long fijJa = stream1
                                    .filter(p -> Files.isRegularFile(p))
                                    .filter(path1 -> path1.getFileName().toString().endsWith(".java"))
                                    .count();
                            if (fijJa > 0)
                                System.out.println("Hay " + fijJa + " en el directorio " + path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try (Stream<Path> stream = Files.list(Path.of("files"))) {
//            stream.forEach(System.out::println);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//       try (Stream<Path> stream = Files.walk(Path.of("files"))){
//           stream.forEach(System.out::println);
//       } catch (IOException e) {
//           throw new RuntimeException(e);
//       }
    }
}
