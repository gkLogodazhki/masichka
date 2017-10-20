package regions;

import exceptions.ValidateStringException;
import id_name_tables.IdNameDAO;

public class RegionDAO extends IdNameDAO{

    public RegionDAO() throws ValidateStringException {
        super("regions");
    }

}
