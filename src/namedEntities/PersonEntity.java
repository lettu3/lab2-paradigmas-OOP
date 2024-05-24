package namedEntities;

//import java.util.List;

public class PersonEntity extends NamedEntity {
    private String name;
    private int age;
    private boolean isAlive;
    private String nationality;
    //public List <String> tags;
    
    public PersonEntity(String name) {
        super();
        this.name = name;
        this.age = 0;
        this.isAlive = true;
        this.nationality = "";
    }

    // Getters y Setters
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String getNationality() {
        return this.nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
