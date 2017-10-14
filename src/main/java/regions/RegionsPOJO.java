package regions;

import exceptions.ValidateNumberException;
import exceptions.ValidateStringException;

public class RegionsPOJO {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) throws ValidateNumberException {
        // TODO - get rows in table regions
        int regionsRows = 0;
        this.id = ValidateNumberException.validateInteger(id,1,regionsRows);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidateStringException {
        this.name = ValidateStringException.validateString(name);
    }
}
