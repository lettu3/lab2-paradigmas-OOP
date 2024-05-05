package namedEntities;

public class OtherEntity extends NamedEntity{
    private String name;
    private String description;

    public OtherEntity(String name) {
        super();
        this.name = name;
        this.description = "";
    }

    // Getters y Setters
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
