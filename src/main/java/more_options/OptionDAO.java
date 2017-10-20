package more_options;

import exceptions.ValidateStringException;
import id_name_tables.IdNameDAO;

public class OptionDAO extends IdNameDAO {

    public OptionDAO() throws ValidateStringException {
        super("options");
    }

}
