package com.ua.pt;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.ua.pt.IpmaCityForecast;
import com.ua.pt.IpmaService;
import com.ua.pt.CityForecast;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Hello world!
 *
 */
public class WeatherStarter 
{
    private static final int CITY_ID_AVEIRO = 1010500;
    
    private static Logger logger = LogManager.getLogger(WeatherStarter.class);

    public static void main( String[] args )
    {
        System.setProperty("log4j.configurationFile","./path_to_the_log4j2_config_file/log4j2.xml");
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
                logger.info("No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
