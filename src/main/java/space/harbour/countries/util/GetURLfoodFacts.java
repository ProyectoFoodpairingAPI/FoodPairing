package space.harbour.countries.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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

    public String getUrlSearch(){

        String url = "https://world.openfoodfacts.org/api/v2/search";
        //junto a esto hay que enviar un json con los parametros de busqueda
        return url;
    }
    public JsonObject getJsonSearch(){
        Gson g = new Gson();
        JsonObject json = g.fromJson("categories_tags_en=pizza", JsonObject.class);
        //json con los parametros de busqueda
        return json;
    }
}
