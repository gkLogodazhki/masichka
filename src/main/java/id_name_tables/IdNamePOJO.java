package id_name_tables;

import exceptions.ValidateNumberException;
import exceptions.ValidateStringException;

public class IdNamePOJO {

    /*
    Tables:
        Columns:
        id	int(11) AI PK
        name	varchar(45)
     */

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) throws ValidateNumberException {
        this.id = ValidateNumberException.validateInteger(id,1,id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidateStringException {
        this.name = ValidateStringException.validateString(name);
    }

}
