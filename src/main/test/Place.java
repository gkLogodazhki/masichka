import com.sun.xml.internal.bind.v2.TODO;
import exceptions.PlacesInfoException;
import exceptions.ValidateNumberException;
import exceptions.ValidateStringException;
import more_options.OptionDAO;
import more_options.OptionPOJO;
import org.junit.Test;
import placeTypes.PlaceTypeDAO;
import placeTypes.PlaceTypePOJO;
import places.PlaceDAO;
import places.PlacePOJO;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

public class Place {

    /*
        Table: places
            Columns:
            id	int(11) PK
            place_type_id	int(11) PK
            logo	varchar(45)
            name	varchar(99)
            address	varchar(45)
            path_to_gallery	varchar(45)
            map_lat	int(11)
            map_lng	int(11)
            info_place	varchar(300)
            region_id	int(11)
            avg_bill_id	int(11)
            work_time_id	int(11)
     */

    // TODO input rows in regions, avg_bills, work_time
//    @Test
//    public void InsertIntoPlace() throws ValidateStringException, FileNotFoundException, PlacesInfoException, ValidateNumberException {
//        PlacePOJO placePOJO = new PlacePOJO().setPlaceTypeID(1).setLogo("logo").setName("happy")
//                .setAddress("Vitoshka").setPathToGallery("galaryPath").setMapLat(4.f).setMapLng(6.f)
//                .setRegionId(1).setAvgBillId(1).setWorkTimeId(1);
//        PlaceDAO placeDAO = new PlaceDAO();
//        assertTrue(placeDAO.InsertIntoPlaces(placePOJO) == 1);
//    }

    @Test
    public void InsertIntoPlaceType() throws ValidateStringException, FileNotFoundException, PlacesInfoException, ValidateNumberException {
        PlaceTypePOJO placeTypePOJO = new PlaceTypePOJO();
        placeTypePOJO.setName("club12345");
        placeTypePOJO.setId(new PlaceTypeDAO().insertIntoPlaces(placeTypePOJO));

        assertTrue(placeTypePOJO.getName().equals(new PlaceTypeDAO().getNameById(placeTypePOJO)));
    }

    // TODO must check the logic of the method
    @Test
    public void getPlaceTypeByName() throws ValidateStringException, FileNotFoundException, PlacesInfoException, ValidateNumberException {
        PlaceTypePOJO placeTypePOJO = new PlaceTypePOJO();
        placeTypePOJO.setName("restaurant23");
        placeTypePOJO.setId(new PlaceTypeDAO().getIdByName(placeTypePOJO));

        assertTrue(new PlaceTypeDAO().getNameById(placeTypePOJO).equals(placeTypePOJO.getName()));
    }


}
