package id_name_tables;

import database_access.DatabaseAccessManager;
import exceptions.PlacesInfoException;
import exceptions.ValidateNumberException;
import exceptions.ValidateStringException;
import places.PlacesPOJO;

import java.io.FileNotFoundException;
import java.sql.*;

public abstract class IdNameDAO {

    private String table;

    private static final String INSERT_INTO_TABLE = "INSERT INTO ? VALUES (null,?);";
    private static final String SELECT_ID_FROM_TABLE_BY_NAME_SQL = "SELECT id FROM ? WHERE name = ?;";
    private static final String SELECT_NAME_FROM_TABLE_BY_ID_SQL = "SELECT name FROM ? WHERE id = ?;";
    private static final String SELECT_COUNT_FROM_TABLE_SQL = "SELECT count(id) counter FROM ?;";
    private static final String SELECT_NAMES_FROM_TABLE_SQL = "SELECT name FROM ?";


    public IdNameDAO(String table) throws ValidateStringException {
        this.table = ValidateStringException.validateString(table);
    }

    public int insertInto(IdNamePOJO idNamePOJO) throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_TABLE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, this.table);
            ps.setString(2, idNamePOJO.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't insert into table places right now. Please try again later or connect with our supports");
        }
    }

    public int getIdByName(IdNamePOJO idNamePOJO) throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ID_FROM_TABLE_BY_NAME_SQL);
            ps.setString(1, this.table);
            ps.setString(2, idNamePOJO.getName());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't connect to table places right now. Please try again later or connect with our supports");
        }
    }

    public String getNameById(IdNamePOJO idNamePOJO) throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_NAME_FROM_TABLE_BY_ID_SQL);
            ps.setString(1, this.table);
            ps.setInt(2, idNamePOJO.getId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("name");
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't connect to table places right now. Please try again later or connect with our supports");
        }
    }

    public ResultSet getNames() throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(SELECT_COUNT_FROM_TABLE_SQL);
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't connect to table places right now. Please try again later or connect with our supports");
        }
    }

    public int getCount() throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();

        try {
            ResultSet rs = connection.createStatement().executeQuery(SELECT_NAMES_FROM_TABLE_SQL);
            rs.next();
            return rs.getInt("counter");
        } catch (SQLException e) {
            throw new PlacesInfoException("You can't connect to table places right now. Please try again later or connect with our supports");
        }
    }

}
