package places;

import database_access.DatabaseAccessManager;
import exceptions.PlacesInfoException;

import java.io.FileNotFoundException;
import java.sql.*;

public class PlaceDAO {

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

    private static final String EXCEPTION = "You can't insert into table places right now. Please try again later or connect with our supports";
    private static final String INSERT_INTO_PLACES_SQL = "INSERT INTO places VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_NAMES_FROM_PLACES_TABLE_SQL = "SELECT name FROM places;";
    private static final String SELECT_COUNT_FROM_PLACES_TABLE_SQL = "SELECT count(id) count FROM places;";

    private static final String SELECT_ALL_PLACES_FROM_PLACES_TABLE_SQL = "SELECT * FROM places;";

    public int InsertIntoPlaces(PlacePOJO place) throws PlacesInfoException, FileNotFoundException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_PLACES_SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, place.getPlaceTypeID());
            ps.setString(2, place.getLogo());
            ps.setString(3, place.getName());
            ps.setString(4, place.getAddress());
            ps.setString(5, place.getPathToGallery());
            ps.setFloat(6, place.getMapLat());
            ps.setFloat(7, place.getMapLng());
            ps.setString(8, place.getInfoPlace());
            ps.setInt(9, place.getSpots());
            ps.setInt(10, place.getRegionId());
            ps.setInt(11, place.getAvgBillId());
            ps.setInt(12, place.getWorkTimeId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt("id");

        } catch (SQLException e) {
            throw new PlacesInfoException(EXCEPTION);
        }
    }

    public ResultSet getAllPlaceNames() throws PlacesInfoException, FileNotFoundException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_NAMES_FROM_PLACES_TABLE_SQL);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new PlacesInfoException(EXCEPTION);
        }
    }

    public ResultSet getAllPlaces() throws PlacesInfoException, FileNotFoundException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PLACES_FROM_PLACES_TABLE_SQL);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new PlacesInfoException(EXCEPTION);
        }
    }

    public int getCount() throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_COUNT_FROM_PLACES_TABLE_SQL);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("column");
        } catch (SQLException e) {
            throw new PlacesInfoException(EXCEPTION);
        }
    }
}