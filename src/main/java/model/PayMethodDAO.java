package model;

import exceptions.ValidateStringException;
import id_name_tables.IdNameDAO;

public class PayMethodDAO extends IdNameDAO {

    public PayMethodDAO() throws ValidateStringException {
        super("pay_methods");
    }

}
