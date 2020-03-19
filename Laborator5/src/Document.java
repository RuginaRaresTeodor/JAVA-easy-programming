import java.io.File;
import java.io.Serializable;
import java.nio.file.InvalidPathException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Document implements Serializable {
    private String id;
    private String name;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) throws InvalidPathException {
        if (location.startsWith( "http://") || location.startsWith("https://" )) {
            this.location = location;
        }
        else {
            File file = new File(location);
            if (    !file.exists());
        }
        this.location = location;
    }
    public Map<String, Object> getTags() {
        return tags;
    }
    //...
    public void addTag(String key, Object obj) {
        tags.put(key, obj); }
//...
    public void printTags() {
        for (var tag : tags.keySet()) {
            System.out.println("{ "+ tag + " " + tags.get(tag) + " }");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(name, document.name) &&
                Objects.equals(location, document.location) &&
                Objects.equals(tags, document.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, tags);
    }

}