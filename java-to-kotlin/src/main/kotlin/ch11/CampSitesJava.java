package ch11;

import java.util.Set;
import java.util.stream.Collectors;

public class CampSitesJava {

    public static Set<CampSiteJava> sitesInRegion(
            Set<CampSiteJava> sites,
            String countryISO,
            String region
    ) {
        return sites.stream()
                .filter( campSite ->
                        campSite.getCountryCode().equals(countryISO) &&
                                campSite.region().equalsIgnoreCase(region)
                )
                .collect(Collectors.toUnmodifiableSet());
    }
}
