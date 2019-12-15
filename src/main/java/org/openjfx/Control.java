package org.openjfx;
import org.openjfx.Model;
import org.openjfx.View;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;



public class Control{
    private Model model;
    private View view;
    private String input;



    public Control(Model model, View view, String input){
        this.model = model;
        this.view = view;
        this.input = input;
    }

    public String updateAndShowWeather() throws Exception{

        String id = findCityid(input);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?id="+id+"&units=metric&appid=718d7a1d983cde6209dd9b9e583b0618"))
                .build();

        HttpResponse<String> response =client.send(request,HttpResponse.BodyHandlers.ofString());

        final String json = response.body();
        if(json != null){
            JSONObject obj = new JSONObject(json);
            String objWeather = obj.getJSONArray("weather").getJSONObject(0).getString("main");
            int objTemp = obj.getJSONObject("main").getInt("temp");
            int objTempMin = obj.getJSONObject("main").getInt("temp_min");
            int objTempMax = obj.getJSONObject("main").getInt("temp_max");
            String objDes = obj.getJSONArray("weather").getJSONObject(0).getString("description");
            int timeStamp = obj.getInt("dt");
            Date date=new Date((long)timeStamp*1000);
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

            this.model.setWeather(objWeather);
            this.model.setTemp(objTemp);
            this.model.setTempMin(objTempMin);
            this.model.setTempMax(objTempMax);
            this.model.setDes(objDes);
            this.model.setCityId(input);
            this.model.setTime(time);
        }

        return this.view.printView(model);
    }

    public String findCityid(String input){
        String js = "{'Cheongju': '1845604','Seoul':'1835847'}";
        JSONObject obj = new JSONObject (js);
        String id = obj.getString(input);
        return id;
    }



}


