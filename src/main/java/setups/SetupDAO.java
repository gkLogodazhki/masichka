package setups;

import exceptions.ValidateStringException;
import id_name_tables.IdNameDAO;

public class SetupDAO extends IdNameDAO{

    public SetupDAO() throws ValidateStringException {
        super("setups");
    }

}
