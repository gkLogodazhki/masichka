package placeTypes;

import database_access.DatabaseAccessManager;
import exceptions.PlacesInfoException;

import java.io.FileNotFoundException;
import java.sql.*;

public class PlaceTypeDAO {

    /*
    Table: placeTypes
        Columns:
        id	int(11) AI PK
        name	varchar(45)
     */

    private static final String INSERT_INTO_PLACES_INFO_SQL = "INSERT INTO place_types VALUES (null,?);";
    private static final String SELECT_ID_FROM_PLACES_BY_NAME_SQL = "SELECT id FROM place_types WHERE name = ?;";
    private static final String SELECT_NAME_FROM_PLACES_BY_ID_SQL = "SELECT name FROM place_types WHERE id = ?;";
    private static final String SELECT_COUNT_FROM_PLACES_SQL = "SELECT count(id) counter FROM place_types;";
    private static final String SELECT_NAMES_FROM_PLACES_SQL = "SELECT name FROM place_types";

    public int insertIntoPlaces(PlaceTypePOJO places) throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_PLACES_INFO_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, places.getName());
            PreparedStatement ps2 = connection.prepareStatement(SELECT_ID_FROM_PLACES_BY_NAME_SQL);
            ps2.setString(1, places.getName());
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                throw new PlacesInfoException("The place already exists");
            }
            rs = ps.getGeneratedKeys();
            return rs.getInt("id");

        } catch (SQLException e) {
            throw new PlacesInfoException("You can't insert into table placeTypes right now. Please try again later or connect with our supports");
        }
    }

    public int getIdByName(PlaceTypePOJO places) throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ID_FROM_PLACES_BY_NAME_SQL);
            ps.setString(1, places.getName());
            ResultSet rs = ps.executeQuery();
            if (rs == null){
                throw new PlacesInfoException("There is no such a place");
            }
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't connect to table placeTypes right now. Please try again later or connect with our supports");
        }
    }

    public String getNameById(PlaceTypePOJO places) throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_NAME_FROM_PLACES_BY_ID_SQL);
            ps.setInt(1, places.getId());
            ResultSet rs = ps.executeQuery();
            if (rs == null){
                throw new PlacesInfoException("There is no such a place");
            }
            rs.next();
            return rs.getString("name");
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't connect to table placeTypes right now. Please try again later or connect with our supports");
        }
    }

    public ResultSet getNames() throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_NAMES_FROM_PLACES_SQL);
            if (rs == null){
                throw new PlacesInfoException("The table is empty");
            }
            return rs;
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't connect to table placeTypes right now. Please try again later or connect with our supports");
        }
    }

    public int getCount() throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            ResultSet rs = connection.createStatement().executeQuery(SELECT_COUNT_FROM_PLACES_SQL);
            rs.next();
            return rs.getInt("counter");
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't connect to table placeTypes right now. Please try again later or connect with our supports");
        }
    }


}
