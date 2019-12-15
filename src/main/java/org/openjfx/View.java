package org.openjfx;
import org.openjfx.Model;
import org.openjfx.Control;


public class View {

    public String printView(Model model){
        String result ="\n"+
                "Weather in "+ model.getCityId()+ ": "  + model.getWeather()+"\n"+
                "Time: "+ model.getTime()+"\n"+
                "Temp: " + model.getTemp() +"\n"+
                "minTemp: " + model.getTempMin() +"\n"+
                "maxTemp: " + model.getTempMax()+"\n"+
                "Comments: " + model.getDes()+"\n";
        return result;

    }




}
