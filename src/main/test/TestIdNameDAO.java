import exceptions.PlacesInfoException;
import exceptions.ValidateNumberException;
import exceptions.ValidateStringException;
import id_name_tables.IdNameDAO;
import model.PayMethod;
import model.PayMethodDAO;
import more_options.OptionDAO;
import more_options.OptionPOJO;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class TestIdNameDAO {



//    @Test
//    public void TestInsertIntoPayMethods() throws ValidateStringException, FileNotFoundException, PlacesInfoException, ValidateNumberException {
//        PayMethod payMethod = new PayMethod();
//        PayMethodDAO payMethodDAO = new PayMethodDAO();
//
//        payMethod.setName("karta");
//        payMethod.setStatus(true);
//        payMethod.setId(payMethodDAO.insertIntoPayMethods(payMethod));
//
//        assertTrue(payMethod.getName().equals(payMethodDAO.getNameById(payMethod)));
//    }

    @Test
    public void TestInsertIntoOptions() throws ValidateStringException, FileNotFoundException, PlacesInfoException, ValidateNumberException {
        OptionPOJO optionPOJO = new OptionPOJO();
        optionPOJO.setName("pesho123");

        optionPOJO.setId(new OptionDAO().insertInto(optionPOJO));
        String testName = new OptionDAO().getNameById(optionPOJO);
        assertTrue(optionPOJO.getName().equals(testName));
    }
}
