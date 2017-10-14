package work_time_hours;

import exceptions.ValidateStringException;
import id_name_tables.IdNameDAO;

public class WorkTimeHourDAO extends IdNameDAO {

    public WorkTimeHourDAO() throws ValidateStringException {
        super("work_time_hour");
    }
}
