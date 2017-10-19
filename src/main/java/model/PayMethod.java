package model;

import id_name_tables.IdNamePOJO;

public class PayMethod extends IdNamePOJO {
    /*
    Table: pay_methods
        Columns:
        id	int(11) PK
        name	varchar(45)
        status	tinyint(4)
     */

    private byte status;

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

}
