import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LecturaBinarios {


    public static void main(String[] args) {
        try {
            byte[] datos = Files.readAllBytes(Path.of("Files/binary.dat"));
            System.out.println(datos.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mainEscribirNIO(String[] args) {
        Path p = Path.of("Files/binary.dat");
        byte[] datos = {4,5,6};
        try {
            Files.write(p, datos, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    public static void main(String[] args) {
//        try (BufferedOutputStream bos = new BufferedOutputStream(
//                new FileOutputStream("files/test.bin")
//        )) {
//            for (int i = 0; i < 100; i++) {
//                bos.write(i);
//                bos.flush();
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}


//    public static void main(String[] args) {
//        try (BufferedInputStream bis = new BufferedInputStream(
//                new FileInputStream("salida.bin")
//        )) {
//            int byteLeido;
//            while ((byteLeido = bis.read()) != -1) {
//                System.out.println(byteLeido);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}



//    public static void mainLecturaSInBuffer(String[] args) {
//        try (FileInputStream fis = new FileInputStream("files/salida.bin")){
//            int byteLeido;
//            while ((byteLeido = fis.read()) != -1){
//                System.out.println(byteLeido);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    //Sin buffer
//    public static void main(String[] args) {
//        try(FileOutputStream fos = new FileOutputStream("salida.bin", true)) {
//            byte[] datos = {1,2,3};
//            fos.write(datos);
//
//            fos.flush();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.err.println("");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.err.println("");
//        }

