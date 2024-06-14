package namedEntities;

public class OrganizationEntity extends NamedEntity {
    
    private String name;
    private int numMembers;
    private boolean nonProfit;

    public OrganizationEntity(String name) {
        super();
        this.name = name;
        this.numMembers = 0;
        this.nonProfit = true;
    }
    
    // Getters y Setters

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNumMembers() {
        return this.numMembers;
    }
    public void setNumMembers(int numMembers) {
        this.numMembers = numMembers;
    }

    public boolean getNonProfit() {
        return this.nonProfit;
    }
    public void setNonProfit(boolean nonProfit) {
        this.nonProfit = nonProfit;
    }

}
