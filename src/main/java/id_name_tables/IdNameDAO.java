package id_name_tables;

import database_access.DatabaseAccessManager;
import exceptions.PlacesInfoException;
import exceptions.ValidateStringException;
import model.PayMethod;

import java.io.FileNotFoundException;
import java.sql.*;

public abstract class IdNameDAO {

    private String table;
    private String exceptionMessage;

    private static final String INSERT_INTO_TABLE = "INSERT INTO @ VALUES (null,?);";
    private static final String INSERT_INTO_TABLE_PAY_METHODS = "INSERT INTO @ VALUES (null,?,?);";

    private static final String SELECT_ID_FROM_TABLE_BY_NAME_SQL = "SELECT id FROM @ WHERE name = ?;";
    private static final String SELECT_NAME_FROM_TABLE_BY_ID_SQL = "SELECT name FROM @ WHERE id = ?;";
    private static final String SELECT_COUNT_FROM_TABLE_SQL = "SELECT count(id) counter FROM @;";
    private static final String SELECT_NAMES_FROM_TABLE_SQL = "SELECT name FROM @";


    public IdNameDAO(String table) throws ValidateStringException {
        this.table = ValidateStringException.validateSQLInjection(table);
        this.exceptionMessage = "You can't insert into table "+ this.table +" right now. Please try again later or connect with our supports";
    }

    public int insertInto(IdNamePOJO idNamePOJO) throws FileNotFoundException, PlacesInfoException, ValidateStringException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {

            // TODO
            String safe = ValidateStringException.validateSQLInjection(this.table);
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_TABLE.replace("@",safe), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, idNamePOJO.getName());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            System.out.println("pesho");

            return rs.getInt(1);
        } catch (SQLException e) {
            throw new PlacesInfoException(exceptionMessage);
        }
    }

    public int insertIntoPayMethods(PayMethod payMethod) throws FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        try {

            // TODO
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_TABLE_PAY_METHODS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, payMethod.getName());
            ps.setBoolean(2, payMethod.getStatus());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            throw new PlacesInfoException(exceptionMessage);
        }
    }

    public int getIdByName(IdNamePOJO idNamePOJO) throws FileNotFoundException, PlacesInfoException, ValidateStringException {
        try {
            PreparedStatement ps = securePreparedStatement(SELECT_ID_FROM_TABLE_BY_NAME_SQL);
            ps.setString(1, idNamePOJO.getName());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            throw new PlacesInfoException(exceptionMessage);
        }
    }

    public String getNameById(IdNamePOJO idNamePOJO) throws FileNotFoundException, PlacesInfoException, ValidateStringException {
        try {
            PreparedStatement ps = securePreparedStatement(SELECT_NAME_FROM_TABLE_BY_ID_SQL);
            ps.setInt(1, idNamePOJO.getId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("name");
        } catch (SQLException e) {
            throw new PlacesInfoException(exceptionMessage);
        }
    }

    public ResultSet getNames() throws FileNotFoundException, PlacesInfoException, ValidateStringException {
        try {
            return securePreparedStatement(SELECT_NAMES_FROM_TABLE_SQL).executeQuery();
        } catch (SQLException e) {
            throw new PlacesInfoException(exceptionMessage);
        }
    }

    public int getCount() throws FileNotFoundException, PlacesInfoException, ValidateStringException {
        try {
            ResultSet rs = securePreparedStatement(SELECT_COUNT_FROM_TABLE_SQL).executeQuery();
            rs.next();
            return rs.getInt("counter");
        } catch (SQLException e) {
            throw new PlacesInfoException(exceptionMessage);
        }
    }

    private PreparedStatement securePreparedStatement(String str) throws ValidateStringException, FileNotFoundException, PlacesInfoException {
        Connection connection = DatabaseAccessManager.getInstance().getConnection();
        ValidateStringException.validateSQLInjection(this.table);
        try {
            return connection.prepareStatement(str.replace("@",this.table));
        } catch (SQLException e) {
            throw new PlacesInfoException(exceptionMessage);
        }
    }
}
