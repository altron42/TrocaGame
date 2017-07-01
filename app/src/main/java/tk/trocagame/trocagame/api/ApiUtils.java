package tk.trocagame.trocagame.api;

/**
 * Created by micael on 6/16/17.
 */

public class ApiUtils {

    private ApiUtils () {}

    public static final String BASE_URL = "http://api.trocagame.tk/";

    public static ApiService getApiService() {
        return ApiClient.getClient(BASE_URL).create(ApiService.class);
    }
}
