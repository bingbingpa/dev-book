package ch11;

public class CampSiteJava {
    private final String id;
    private final String name;
    private final Address address;

    public CampSiteJava(
            String id,
            String name,
            Address address
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return address.getCountryCode();
    }

    public String region() {
        return address.getRegion();
    }

    public Address getAddress() {
        return address;
    }
}
