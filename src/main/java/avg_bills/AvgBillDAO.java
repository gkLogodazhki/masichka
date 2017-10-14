package avg_bills;

import exceptions.ValidateStringException;
import id_name_tables.IdNameDAO;

public class AvgBillDAO extends IdNameDAO{

    public AvgBillDAO() throws ValidateStringException {
        super("avg_bills");
    }

}
