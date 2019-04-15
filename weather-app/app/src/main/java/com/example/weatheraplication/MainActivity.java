package com.example.weatheraplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.api.Places;

//Add an import statement for the client library.


public class MainActivity extends AppCompatActivity {
    String TAG = "placeautocomplete";
    TextView cityView;
    TextView countryView;
    TextView weekDayView;
    TextView degreeView;
    TextView forecastView;
    TextView firstIntervalView;
    TextView secondIntervalView;
    TextView thirdIntervalView;
    TextView firstIntervalTempView;
    TextView secondIntervalTempView;
    TextView thirdIntervalTempView;
    TextView firstIntervalDescriptionView;
    TextView secondIntervalDescriptionView;
    TextView thirdIntervalDescriptionView;
    TextView day1View;
    TextView day2View;
    TextView day3View;
    TextView day1DescriptionView;
    TextView day2DescriptionView;
    TextView day3DescriptionView;
    TextView day1TempView;
    TextView day2TempView;
    TextView day3TempView;
    ImageView currentImageView;
    ImageView iconHour1View;
    ImageView iconHour2View;
    ImageView iconHour3View;
    ImageView iconDay1View;
    ImageView iconDay2View;
    ImageView iconDay3View;
    String mydate;
    WeatherRequest request;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityView = findViewById(R.id.city);
        countryView = findViewById(R.id.country);
        weekDayView = findViewById(R.id.weekDay);
        degreeView  = findViewById(R.id.degree);
        forecastView = findViewById(R.id.forecast);
        currentImageView = findViewById(R.id.currentImage);
        firstIntervalView = findViewById(R.id.firstInterval);
        secondIntervalView = findViewById(R.id.secondInterval);
        thirdIntervalView = findViewById(R.id.thirdInterval);
        firstIntervalTempView = findViewById(R.id.firstIntervalTemp);
        secondIntervalTempView = findViewById(R.id.secondIntervalTemp);
        thirdIntervalTempView = findViewById(R.id.thirdIntervalTemp);
        iconHour1View = findViewById(R.id.iconHour1);
        iconHour2View = findViewById(R.id.iconHour2);
        iconHour3View = findViewById(R.id.iconHour3);
        firstIntervalDescriptionView = findViewById(R.id.firstIntervalDescription);
        secondIntervalDescriptionView = findViewById(R.id.secondIntervalDescription);
        thirdIntervalDescriptionView = findViewById(R.id.thirdIntervalDescription);
        day1View = findViewById(R.id.day1);
        day2View = findViewById(R.id.day2);
        day3View = findViewById(R.id.day3);
        iconDay1View = findViewById(R.id.iconDay1);
        iconDay2View = findViewById(R.id.iconDay2);
        iconDay3View = findViewById(R.id.iconDay3);
        day1DescriptionView = findViewById(R.id.day1Description);
        day2DescriptionView = findViewById(R.id.day2Description);
        day3DescriptionView = findViewById(R.id.day3Description);
        day1TempView = findViewById(R.id.day1Temp);
        day2TempView = findViewById(R.id.day2Temp);
        day3TempView = findViewById(R.id.day3Temp);



        //Set Curent search for Craiova
        mydate =  java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        weekDayView.setText(mydate);
        cityView.setText("Craiova");
        request = new WeatherRequest("Craiova");
        countryView.setText("Romania");
        mydate =  java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        weekDayView.setText(mydate);
        try {
            request.execute().get();
            degreeView.setText(request.getCurentTemp() + "°C");
            forecastView.setText(request.getCurentDescription());
            currentImageView.setImageResource(getImageFromString(request.getCurrentIcon()));
            iconHour1View.setImageResource(getImageFromString(request.getFirstIntervalIcon()));
            iconHour2View.setImageResource(getImageFromString(request.getSecondtIntervalIcon()));
            iconHour3View.setImageResource(getImageFromString(request.getThirdIntervalIcon()));
            iconDay1View.setImageResource(getImageFromString(request.getDay1Icon()));
            iconDay2View.setImageResource(getImageFromString(request.getDay2Icon()));
            iconDay3View.setImageResource(getImageFromString(request.getDay3Icon()));
            firstIntervalView.setText(request.getFirstIntervalHour());
            secondIntervalView.setText(request.getSecondIntervalHour());
            thirdIntervalView.setText(request.getThirdIntervalHour());
            firstIntervalTempView.setText(request.getFirstIntervalTemp() + "°C");
            secondIntervalTempView.setText(request.getSecondIntervalTemp() + "°C");
            thirdIntervalTempView.setText(request.getThirdIntervalTemp() + "°C");
            firstIntervalDescriptionView.setText(request.getFirstIntervalDescription());
            secondIntervalDescriptionView.setText(request.getSecondIntervalDescription());
            thirdIntervalDescriptionView.setText(request.getThirdIntervalDescription());
            day1View.setText(request.getFirstDayDate());
            day2View.setText(request.getSecondDayDate());
            day3View.setText(request.getThirdDayDate());
            day1DescriptionView.setText(request.getDay1Description());
            day2DescriptionView.setText(request.getDay2Description());
            day3DescriptionView.setText(request.getDay3Description());
            day1TempView.setText(request.getTempMinDay1()+"°C/"+request.getTempMaxDay1()+"°C");
            day2TempView.setText(request.getTempMinDay2()+"°C/"+request.getTempMaxDay2()+"°C");
            day3TempView.setText(request.getTempMinDay3()+"°C/"+request.getTempMaxDay3()+"°C");
        }catch (Exception e) {
            e.printStackTrace();
        }


        //Google Places
        Places.initialize(getApplicationContext(), "AIzaSyDlhB2m5JFYo838fSYr8JJeJTkCyifq7Cs");
        PlacesClient placesClient = Places.createClient(this);


        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.TYPES));
        autocompleteFragment.setTypeFilter(TypeFilter.CITIES);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                cityView.setText(place.getName());
                request = new WeatherRequest(place.getName());
                countryView.setText(place.getAddress().substring(place.getAddress().indexOf(",")+1));
                mydate =  java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                weekDayView.setText(mydate);
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId() + ", " + place.getAddress().substring(place.getAddress().indexOf(",")));
                try {
                    request.execute().get();
                    degreeView.setText(request.getCurentTemp() + "°C");
                    forecastView.setText(request.getCurentDescription());
                    currentImageView.setImageResource(getImageFromString(request.getCurrentIcon()));
                    iconHour1View.setImageResource(getImageFromString(request.getFirstIntervalIcon()));
                    iconHour2View.setImageResource(getImageFromString(request.getSecondtIntervalIcon()));
                    iconHour3View.setImageResource(getImageFromString(request.getThirdIntervalIcon()));
                    iconDay1View.setImageResource(getImageFromString(request.getDay1Icon()));
                    iconDay2View.setImageResource(getImageFromString(request.getDay2Icon()));
                    iconDay3View.setImageResource(getImageFromString(request.getDay3Icon()));
                    firstIntervalView.setText(request.getFirstIntervalHour());
                    secondIntervalView.setText(request.getSecondIntervalHour());
                    thirdIntervalView.setText(request.getThirdIntervalHour());
                    firstIntervalTempView.setText(request.getFirstIntervalTemp()+ "°C");
                    secondIntervalTempView.setText(request.getSecondIntervalTemp()+ "°C");
                    thirdIntervalTempView.setText(request.getThirdIntervalTemp()+ "°C");
                    firstIntervalDescriptionView.setText(request.getFirstIntervalDescription());
                    secondIntervalDescriptionView.setText(request.getSecondIntervalDescription());
                    thirdIntervalDescriptionView.setText(request.getThirdIntervalDescription());
                    day1View.setText(request.getFirstDayDate());
                    day2View.setText(request.getSecondDayDate());
                    day3View.setText(request.getThirdDayDate());
                    day1DescriptionView.setText(request.getDay1Description());
                    day2DescriptionView.setText(request.getDay2Description());
                    day3DescriptionView.setText(request.getDay3Description());
                    day1TempView.setText(request.getTempMinDay1()+"°C/"+request.getTempMaxDay1()+"°C");
                    day2TempView.setText(request.getTempMinDay2()+"°C/"+request.getTempMaxDay2()+"°C");
                    day3TempView.setText(request.getTempMinDay3()+"°C/"+request.getTempMaxDay3()+"°C");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
    }

    public int getImageFromString(String s){
        if(s.equals("01d")){
            return R.drawable.a01d;
        }
        if(s.equals("01n")){
            return R.drawable.a01n;
        }
        if(s.equals("02d")){
            return R.drawable.a02d;
        }
        if(s.equals("02n")){
            return R.drawable.a02n;
        }
        if(s.equals("03d")){
            return R.drawable.a03d;
        }
        if(s.equals("03n")){
            return R.drawable.a03n;
        }
        if(s.equals("04d")){
            return R.drawable.a04d;
        }
        if(s.equals("04n")){
            return R.drawable.a04n;
        }
        if(s.equals("09d")){
            return R.drawable.a09d;
        }
        if(s.equals("09n")){
            return R.drawable.a09n;
        }
        if(s.equals("10d")){
            return R.drawable.a10d;
        }
        if(s.equals("10n")){
            return R.drawable.a10n;
        }
        if(s.equals("11d")){
            return R.drawable.a11d;
        }
        if(s.equals("11n")){
            return R.drawable.a11n;
        }
        if(s.equals("13d")){
            return R.drawable.a13d;
        }
        if(s.equals("13n")){
            return R.drawable.a13n;
        }
        if(s.equals("50d")){
            return R.drawable.a50d;
        }
        if(s.equals("50n")){
            return R.drawable.a50n;
        }
        return R.drawable.cloud;
    }
}