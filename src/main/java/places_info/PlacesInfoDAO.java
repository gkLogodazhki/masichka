package places_info;

import database_access.DatabaseAccessManager;
import exceptions.PlacesInfoException;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlacesInfoDAO {

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

    public int InsertPlaceInfo(PlacesInfoPOJO placesInfo) throws PlacesInfoException, FileNotFoundException {
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

    public List<String> getAllPlaceInfoNames(PlacesInfoPOJO placesInfo) throws PlacesInfoException, FileNotFoundException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        List<String> list = new ArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_NAME_FROM_PLACES_INFO_SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("name"));
            }
            return list;

        } catch (SQLException e) {
            throw new PlacesInfoException("You can't insert into table places_info right now. Please try again later or connect with our supports");
        }
    }

}
