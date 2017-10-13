package places;

import exceptions.ValidateStringException;

public class PlacesPOJO {

    /*
    Table: places
        Columns:
        id	int(11) AI PK
        name	varchar(45)
     */

    private static int uid;
    private int id;
    private String name;

    public PlacesPOJO() {
        this.setId();
    }

    public PlacesPOJO(String name) {
        this();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = ++uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidateStringException {
        this.name = ValidateStringException.validateString(name);
    }

}
