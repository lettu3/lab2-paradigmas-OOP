package namedEntities;

import java.util.List;

public class LocationEntity extends NamedEntity {
    
    private String coordinates;
    private int heightFromSeaLevel;
    private String country;
    private String name;
    public List <String> tags;

    public LocationEntity(String name) {
        super();
        this.coordinates = "";
        this.heightFromSeaLevel = 0;
        this.country = "";
        this.name = name;
    }

    /*
    public LocationEntity(String coordinates, int heightFromSeaLevel, String country) {
        super();
        this.coordinates = coordinates;
        this.heightFromSeaLevel = heightFromSeaLevel;
        this.country = country;
    }
    */

    public String getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public int getHeightFromSeaLevel() {
        return this.heightFromSeaLevel;
    }

    public void setHeightFromSeaLevel(int heightFromSeaLevel) {
        this.heightFromSeaLevel = heightFromSeaLevel;
    }
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}