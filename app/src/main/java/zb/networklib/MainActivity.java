package zb.networklib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

import zb.networklib.bean.Weather;
import zb.networklib.retrofit.HttpEngine;

public class MainActivity extends AppCompatActivity {

    private HttpEngine httpEngine = new HttpEngine();

    private TextView mWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeather = (TextView) findViewById(R.id.weather);

        httpEngine.executeGet("http://www.weather.com.cn/data/sk/101010100.html"
                , new HashMap<String, String>()
                , new HttpEngine.ResponseCallBack<Weather>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("kevin", "error");
                    }

                    @Override
                    public void onSuccess(Weather response) {

                        mWeather.setText(response.getWeatherinfo().getCity() + "\n"
                                + response.getWeatherinfo().getWD() + "\n"
                                + "温度：" + response.getWeatherinfo().getTemp());
                    }
                });

        httpEngine.get("http://www.weather.com.cn/data/sk/101010100.html"
                , new HashMap<String, String>()
                , new HttpEngine.ResponseCallBack<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onSuccess(String response) {

                        Log.i("kevin", response);

                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        httpEngine.onUnsubscribe();
    }
}
