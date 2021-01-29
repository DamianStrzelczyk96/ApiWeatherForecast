package Project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {


    public List<Dni> connectByCityForXDays(String cityName, int iloscDni) throws IOException, JSONException {
        String response = null;
        try {
            response = new HttpService().connect( Config.APP_URL_DAILY+"q="+cityName+"&appid="+Config.APP_ID);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseJsonForXDays(response,iloscDni);
    }

    public List<Dni> parseJsonForXDays(String json, int iloscDni) throws JSONException {

        List<Dni> listadni = new ArrayList<>();
        JSONObject rootObject = new JSONObject(json);
        if (rootObject.getInt("cod") == 200) {

            JSONArray listJsonArray = rootObject.getJSONArray("list");

            int ktorydzien=0;
            for (int i=0 ; i<iloscDni*8 ; i++){

                JSONObject one = (JSONObject) listJsonArray.get(i);
                Dni dni = new Dni();
                JSONObject main = one.getJSONObject("main");
                dni.setTemp(main.getDouble("temp"));
                dni.setHumidity(main.getInt("humidity"));
                dni.setPressure(main.getInt("pressure"));
                JSONObject cloud = one.getJSONObject("clouds");
                dni.setClouds(cloud.getInt("all"));
                JSONObject wind = one.getJSONObject("wind");
                dni.setWind(wind.getDouble("speed"));
                dni.setDzien(ktorydzien);
                JSONArray pogoda = one.getJSONArray("weather");
                JSONObject opis = pogoda.getJSONObject(0);
                dni.setOpis(opis.getString("description"));
                dni.setData(one.getString("dt_txt"));

                try {
                    JSONObject snow = one.getJSONObject("snow");
                    dni.setSnow(snow.getDouble("3h"));
                }catch (JSONException e){

                }
                listadni.add(dni);
                ktorydzien++;
            }
        } else {
            System.out.println("Error");
        }
        return listadni;
    }
}
