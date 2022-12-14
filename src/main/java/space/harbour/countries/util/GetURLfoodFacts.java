package space.harbour.countries.util;

public abstract class GetURLfoodFacts{
    //devuelve url para leer json de un codigo de barra
    public static String getURLfoodFactsBarcode(int barcode){
        String url = "https://world.openfoodfacts.org/api/v0/product/"+barcode+".json";
        return url;
    }
    //devuelve el url para obtenor nutrientes del pais
    public static String getURLcountryFoodNutrients(String countryPrefix){
        String url = "https://"+countryPrefix+".openfoodfacts.org/cgi/nutrients.pl";
        return url;
    }

    //devuelve la url para buscar un productor en un pais
    public static String getURLcountryFoodProducer(String countryPrefix){
        String url = "https://"+countryPrefix+".openfoodfacts.org/cgi/search.pl";
        return url;
    }
}
