package places;

import database_access.DatabaseAccessManager;
import exceptions.PlacesInfoException;

import java.io.FileNotFoundException;
import java.sql.*;

public class PlacesDAO{

        /*
    Table: places_info
        Columns:
            id	int(11) AI PK
            logo	varchar(99)
            name	varchar(99)
            address	varchar(45)
            rating	int(10) UN
            places_id	int(11)
            path_to_gallery	varchar(45)
            map_lat	float
            map_lng	float
            info_place	varchar(500)
            spots	int(10) UN
            avg_bill_tag_id	int(11)
            more_opition_tag_id	int(11)
            region_tags_id	int(11)
            pay_methods_id	int(11)
            setup_tags_id	int(11)
            work_time_tags_id	int(11)
     */

    private static final String INSERT_INTO_PLACES_INFO_SQL = "INSERT INTO places_info VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_NAME_FROM_PLACES_INFO_SQL = "SELECT DISTINCT name FROM places_info;";
    private static final String SELECT_PLACES_INFO_FROM_PLACES_INFO_LIMIT_10_SQL = "SELECT * FROM places_info order by ? DESC LIMIT 10;";
    private static final String SELECT_ALL_PLACES_INFO_FROM_PLACES_INFO = "SELECT * FROM places_info;";
    private static final String SELECT_PLACES_INFO_FROM_PLACES_INFO_ORDER_BY = "SELECT * FROM places_info order by ? ?;";

    public int InsertPlace(PlacesPOJO placesInfo) throws PlacesInfoException, FileNotFoundException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_PLACES_INFO_SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, placesInfo.getLogo());
            ps.setString(2, placesInfo.getName());
            ps.setString(3, placesInfo.getAddress());
            ps.setInt(4, placesInfo.getRating());
            ps.setInt(5, placesInfo.getPlacesId());
            ps.setString(6, placesInfo.getPathToGallery());
            ps.setFloat(7, placesInfo.getMapLat());
            ps.setFloat(8, placesInfo.getMapLng());
            ps.setString(9, placesInfo.getInfoPlace());
            ps.setInt(10, placesInfo.getSpots());
            ps.setInt(11, placesInfo.getAvgBillTagId());
            ps.setInt(12, placesInfo.getMoreOptionTagId());
            ps.setInt(13, placesInfo.getRegionTagId());
            ps.setInt(14, placesInfo.getPayMethod());
            ps.setInt(15, placesInfo.getSetupTagsId());
            ps.setInt(16, placesInfo.getWorkTimeTagsId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            throw new PlacesInfoException("You can't insert into table places_info right now. Please try again later or connect with our supports");
        }
    }

    // option: mostPopular, newOnes, bestDiscount, fastReservation
    public ResultSet getStatistic(String option) throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_PLACES_INFO_FROM_PLACES_INFO_LIMIT_10_SQL);
            ps.setString(1,option);
            return ps.executeQuery();

        } catch (SQLException e) {
            throw new PlacesInfoException("You can't insert into table places_info right now. Please try again later or connect with our supports");
        }
    }

    public ResultSet getAllPlaceNames() throws PlacesInfoException, FileNotFoundException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_NAME_FROM_PLACES_INFO_SQL);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't insert into table places_info right now. Please try again later or connect with our supports");
        }
    }

    public ResultSet getAllPlaces() throws PlacesInfoException, FileNotFoundException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PLACES_INFO_FROM_PLACES_INFO);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't insert into table places_info right now. Please try again later or connect with our supports");
        }
    }

    // option: popularity, newOnes, rating, byName, closests, bestDiscount
    // order: ASC, DESC
    public ResultSet getAllPlacesOrderBy(String option, String order) throws PlacesInfoException, FileNotFoundException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_PLACES_INFO_FROM_PLACES_INFO_ORDER_BY);
            ps.setString(1,option);
            ps.setString(2,order);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't insert into table places_info right now. Please try again later or connect with our supports");
        }
    }

    public int getCount() {
        // TODO
        return 1;
    }
}
