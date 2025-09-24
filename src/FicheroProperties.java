import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class FicheroProperties {
        public static void main(String[] args) {


        Properties properties = new Properties();
        try {
            properties.load(Files.newBufferedReader(Path.of("./Files/server.properties")));

            properties.stringPropertyNames().stream()
                            .sorted()
                    .forEach(k -> System.out.println(k + "=" + properties.getProperty(k)));

            properties.forEach((o, o2) -> System.out.println(o + "=" + o2));
            String timeout = properties.getProperty("server.timeout");
            System.out.println(timeout);
            properties.setProperty("server.log", "info");
            System.out.println(properties);


            properties.store(Files.newBufferedWriter(Path.of("./Files/server.properties")), "log updated");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
