package space.harbour.countries.util;

public abstract class GetURLfoodFacts{
    //devuelve url para leer json de un codigo de barra
    public static String getURLfoodFactsBarcode(int barcode){
        String url = "https://world.openfoodfacts.org/api/v0/product/"+barcode+".json";
        return url;
    }
    //devuelve el url para obtenor comida del pais
    public static String getURLcountryFoodFacts(String countryPrefix){
        String url = "https://"+countryPrefix+".openfoodfacts.org/cgi/nutrients.pl";
        return url;
    }
}
