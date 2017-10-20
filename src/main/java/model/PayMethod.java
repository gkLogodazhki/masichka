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

    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
