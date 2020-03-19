import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {

    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        Object o;
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            o = ois.readObject();
        }
        if (!(o instanceof Catalog)) {
            throw new InvalidCatalogException();
        }
        return (Catalog)o;
//...
        }
        public static void view (Document doc) throws IOException {
            Desktop desktop = Desktop.getDesktop();
//... browse or open, depending of the location type
            desktop = Desktop.getDesktop();
            String location = doc.getLocation();
            if (location.startsWith("http://") || location.startsWith("https://")) {
                desktop.browse(URI.create(location));
            }
            else {
                File file = new File(location);
                if (file.exists()) {
                    desktop.open(file);
                }
            }
        }
    }