package space.harbour.countries.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Country {

    private CountryName name;
    private String region;
    private String subregion;
    private int population;

    public  String getName() {
        return name.getCommon();
    }

    public String getOfficialName() {
        return name.getOfficial();
    }

    public  String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public int getPopulation() {
        return population;
    }


}
