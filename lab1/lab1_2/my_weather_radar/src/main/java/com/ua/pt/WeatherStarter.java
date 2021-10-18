package com.ua.pt;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.ua.pt.IpmaCityForecast;
import com.ua.pt.IpmaService;
import com.ua.pt.CityForecast;

import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class WeatherStarter 
{
    private static final int CITY_ID_AVEIRO = 1010500;
    private static final Logger logger = Logger.getLogger(WeatherStarter.class.getName());
    public static void main( String[] args )
    {
        int city_id = Integer.parseInt(args[0]);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(city_id);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info( "max temp for today: " + forecast.getData().
                        listIterator().next().getTMax());
            } else {
                logger.info( "No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
