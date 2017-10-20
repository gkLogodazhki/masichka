package places;

import avg_bills.AvgBillDAO;
import exceptions.PlacesInfoException;
import exceptions.ValidateNumberException;
import exceptions.ValidateStringException;
import regions.RegionDAO;
import work_time_hours.WorkTimeHourDAO;

import java.io.FileNotFoundException;

public class PlacePOJO {

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

    private int id;
    private int placeTypeID;
    private String logo;
    private String name;
    private String address;
    private String pathToGallery;
    private float mapLat;
    private float mapLng;
    private String infoPlace;
    private int spots;
    private int regionId;
    private int avgBillId;
    private int workTimeId;

    public PlacePOJO() {
    }

    public PlacePOJO(int placeTypeID, String logo, String name, String address, String pathToGallery, float mapLat, float mapLng, String infoPlace, int spots, int regionId, int avgBillId, int workTimeId) throws ValidateStringException, ValidateNumberException, FileNotFoundException, PlacesInfoException {
        this.setPlaceTypeID(placeTypeID);
        this.setLogo(logo);
        this.setName(name);
        this.setAddress(address);
        this.setPathToGallery(pathToGallery);
        this.setMapLat(mapLat);
        this.setMapLng(mapLng);
        this.setInfoPlace(infoPlace);
        this.setSpots(spots);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws ValidateNumberException, FileNotFoundException, PlacesInfoException {
        this.id = ValidateNumberException.validateInteger(id, 1, new PlaceDAO().getCount());
    }

    public int getPlaceTypeID() {
        return placeTypeID;
    }

    public void setPlaceTypeID(int placeTypeID) throws ValidateNumberException, FileNotFoundException, PlacesInfoException {
        this.placeTypeID = ValidateNumberException.validateInteger(placeTypeID, 1, new PlaceDAO().getCount());
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) throws ValidateStringException {
        this.logo = ValidateStringException.validateString(logo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidateStringException {
        this.name = ValidateStringException.validateString(name);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws ValidateStringException {
        this.address = ValidateStringException.validateString(address);
    }

    public String getPathToGallery() {
        return pathToGallery;
    }

    public void setPathToGallery(String pathToGallery) throws ValidateStringException {
        this.pathToGallery = ValidateStringException.validateString(pathToGallery);
    }

    public float getMapLat() {
        return mapLat;
    }

    public void setMapLat(float mapLat) throws ValidateNumberException {
        this.mapLat = ValidateNumberException.validateFloat(mapLat, -90f, 90f);
    }

    public float getMapLng() {
        return mapLng;
    }

    public void setMapLng(float mapLng) throws ValidateNumberException {
        this.mapLng = ValidateNumberException.validateFloat(mapLng, -180f, 180f);
    }

    public String getInfoPlace() {
        return infoPlace;
    }

    public void setInfoPlace(String infoPlace) throws ValidateStringException {
        this.infoPlace = ValidateStringException.validateString(infoPlace);
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) throws ValidateNumberException {
        int maxSpots = 99;
        this.spots = ValidateNumberException.validateInteger(spots, 1, maxSpots);
    }

    public int getAvgBillId() {
        return avgBillId;
    }

    public void setAvgBillId(int avgBillId) throws ValidateNumberException, ValidateStringException, FileNotFoundException, PlacesInfoException {
        this.avgBillId = ValidateNumberException.validateInteger(avgBillId, 1, new AvgBillDAO().getCount());
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) throws ValidateNumberException, ValidateStringException, FileNotFoundException, PlacesInfoException {
        this.regionId = ValidateNumberException.validateInteger(regionId, 1, new RegionDAO().getCount());
    }

    public int getWorkTimeId() {
        return workTimeId;
    }

    public void setWorkTimeId(int workTimeId) throws ValidateNumberException, ValidateStringException, FileNotFoundException, PlacesInfoException {
        this.workTimeId = ValidateNumberException.validateInteger(workTimeId, 1, new WorkTimeHourDAO().getCount());
    }

}