package places;

import exceptions.PlacesInfoException;
import exceptions.ValidateNumberException;
import exceptions.ValidateStringException;
import id_name_tables.IdNamePOJO;

import java.io.FileNotFoundException;

public class PlacePOJO {

    /*
    Table: places
        Columns:
            places_id	int(11) PK
            places_info_id	int(11) PK
            logo	varchar(45)
            name	varchar(99)
            address	varchar(45)
            rating	varchar(45)
            path_to_gallery	varchar(45)
            map_id	int(11)
            info_place	varchar(300)
            regions_id	int(11)
            work_time_hours_id	int(11)
            avg_bills_idavg_bill_tag	int(11)
     */

    private int id;
    private String logo;
    private String name;
    private String address;
    private int rating;
    private int placesId;
    private String pathToGallery;
    private float mapLat;
    private float mapLng;
    private String infoPlace;
    private int spots;
    private int avgBillTagId;
    private int moreOptionTagId;
    private int regionTagId;
    private int payMethod;
    private int setupTagsId;
    private int workTimeTagsId;

    public PlacePOJO() {
    }

    public PlacePOJO(String logo, String name, String address, int rating, int placesId, String pathToGallery, float mapLat, float mapLng, String infoPlace, int spots, int avgBillTagId, int moreOptionTagId, int regionTagId, int payMethod, int setupTagsId, int workTimeTagsId) throws ValidateStringException, ValidateNumberException, FileNotFoundException, PlacesInfoException {
        this.setLogo(logo);
        this.setName(name);
        this.setAddress(address);
        this.setRating(0);
        this.setPlacesId(placesId);
        this.setPathToGallery(pathToGallery);
        this.setMapLat(mapLat);
        this.setMapLng(mapLng);
        this.setInfoPlace(infoPlace);
        this.setSpots(spots);
        this.setAvgBillTagId(avgBillTagId);
        this.setMoreOptionTagId(moreOptionTagId);
        this.setRegionTagId(regionTagId);
        this.setPayMethod(payMethod);
        this.setSetupTagsId(setupTagsId);
        this.setWorkTimeTagsId(workTimeTagsId);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) throws ValidateNumberException {
        this.id = ValidateNumberException.validateInteger(id, 1, id);
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws ValidateNumberException {
        this.rating = ValidateNumberException.validateInteger(rating, 0, 5);
    }

    public int getPlacesId() {
        return placesId;
    }

    public void setPlacesId(int placesId) throws ValidateNumberException, FileNotFoundException, PlacesInfoException {
        int placesRows = new PlaceDAO().getCount();
        this.placesId = ValidateNumberException.validateInteger(placesId, 1, placesRows);
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

    public void setMapLng(float mapLng) {
        this.mapLng = mapLng;
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

    public int getAvgBillTagId() {
        return avgBillTagId;
    }

    public void setAvgBillTagId(int avgBillTagId) throws ValidateNumberException {
        // TODO : get id of the last row in table avg_bill_tag
        int avgBillTagRows = 0;
        this.avgBillTagId = ValidateNumberException.validateInteger(avgBillTagId, 1, avgBillTagRows);
    }

    public int getMoreOptionTagId() {
        return moreOptionTagId;
    }

    public void setMoreOptionTagId(int moreOptionTagId) throws ValidateNumberException {
        // TODO : get id of the last row in table more_option_tag
        int moreOptionTagRows = 0;
        this.moreOptionTagId = ValidateNumberException.validateInteger(moreOptionTagId, 1, moreOptionTagRows);
    }

    public int getRegionTagId() {
        return regionTagId;
    }

    public void setRegionTagId(int regionTagId) throws ValidateNumberException {
        // TODO : get id of the last row in table region_tag
        int regionTagRows = 0;
        this.regionTagId = ValidateNumberException.validateInteger(regionTagId, 1, regionTagRows);
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) throws ValidateNumberException {
        // TODO : get id of the last row in table pay_methods
        int payMethodgRows = 0;
        this.payMethod = ValidateNumberException.validateInteger(payMethod, 1, payMethodgRows);
    }

    public int getSetupTagsId() {
        return setupTagsId;
    }

    public void setSetupTagsId(int setupTagsId) throws ValidateNumberException {
        // TODO : get id of the last row in table setup_tags
        int setupTagsRows = 0;
        this.setupTagsId = ValidateNumberException.validateInteger(setupTagsId, 1, setupTagsRows);
    }

    public int getWorkTimeTagsId() {
        return workTimeTagsId;
    }

    public void setWorkTimeTagsId(int workTimeTagsId) throws ValidateNumberException {
        // TODO : get id of the last row in table work_time_taga
        int workTimeTagsRows = 0;
        this.workTimeTagsId = ValidateNumberException.validateInteger(workTimeTagsId, 1, workTimeTagsRows);
    }
}