package Lab16;

public class Address {
    private String cityName;
    private int zipCode;
    private String streetName;
    private int buildingNumber;
    private char buildingLetter;
    private int apartmentNumber;
    public static final Address EMPTY_ADDRESS = new Address("", 0, "", 0,'0', 0);;

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    @Override
    public String toString() {
        return cityName + ", " + zipCode + ", " + streetName + ", " + buildingNumber + ", " + buildingLetter + ", " + apartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (zipCode != address.zipCode) return false;
        if (buildingLetter != address.buildingLetter) return false;
        if (apartmentNumber != address.apartmentNumber) return false;
        if (cityName != null ? !cityName.equals(address.cityName) : address.cityName != null) return false;
        return streetName != null ? streetName.equals(address.streetName) : address.streetName == null;
    }
}
