package org.openjfx;

public class Model {
    private String weather;
    private int temp;
    private int tempMin;
    private int tempMax;
    private String Des;
    private String cityID;
    private String time;


//getters and setters

    public String getWeather(){
        return weather;
    }

    public void setWeather(String weather){
        this.weather = weather;
    }

    public String getTemp(){
        return Integer.toString(temp);
    }

    public void setTemp(int temp){
        this.temp = temp;
    }

    public String getTempMin(){
        return Integer.toString(tempMin);
    }

    public void setTempMin(int tempMin){
        this.tempMin = tempMin;
    }

    public String getTempMax(){
        return Integer.toString(tempMax);
    }

    public void setTempMax(int tempMax){
        this.tempMax = tempMax;
    }

    public String getDes(){
        return Des;
    }

    public void setDes(String Des){
        this.Des = Des;
    }

    public String getCityId(){
        return cityID;
    }

    public void setCityId(String cityId){
        this.cityID = cityId;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }
}
