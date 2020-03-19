import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();
    //...

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(name, catalog.name) &&
                Objects.equals(path, catalog.path) &&
                Objects.equals(documents, catalog.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, documents);
    }

    public void add(Document doc) { documents.add(doc);
    }
    public Document findById(String id) { //...
        return documents.stream()
                .filter(doc -> doc.getId()
                        .equals(id)).findFirst()
                .orElse(null);
    } }