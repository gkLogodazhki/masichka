package regions;

import exceptions.ValidateNumberException;
import exceptions.ValidateStringException;

public class RegionsPOJO {

    private int id;
    private String name;
    private int cityId;

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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) throws ValidateNumberException {
        // TODO : get count of cities in table city
        int cityCounts = 0;
        this.cityId = ValidateNumberException.validateInteger(cityId,1, cityCounts);
    }
}
