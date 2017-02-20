package zb.networklib.bean;

/**
 * Created by kevin on 17/2/17.
 */

public class Weather {

    @Override
    public String toString() {
        return "Weather{" +
                "weatherinfo=" + weatherinfo +
                '}';
    }

    /**
     * weatherinfo : {"city":"北京","cityid":"101010100","temp":"18","WD":"东南风","WS":"1级","SD":"17%","WSE":"1","time":"17:05","isRadar":"1","Radar":"JC_RADAR_AZ9010_JB","njd":"暂无实况","qy":"1011","rain":"0"}
     */



    private WeatherinfoBean weatherinfo;

    public WeatherinfoBean getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WeatherinfoBean weatherinfo) {
        this.weatherinfo = weatherinfo;
    }
}
