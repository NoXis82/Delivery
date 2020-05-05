package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainApp";
    private Spinner mCountriesSpinner;
    private Spinner mCitiesSpinner;
    private Spinner mHouseNumberSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        actionBtn();
    }

    public void actionBtn() {
        Button mShowAddressBtn = findViewById(R.id.showAddress);
        mShowAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this
                        , mCountriesSpinner.getSelectedItem().toString() + " "
                                + mCitiesSpinner.getSelectedItem().toString() + " "
                                + mHouseNumberSpinner.getSelectedItem().toString()
                        , Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    public void initViews() {
        mCountriesSpinner = findViewById(R.id.countriesSpinner);
        mCitiesSpinner = findViewById(R.id.citiesSpinner);
        mHouseNumberSpinner = findViewById(R.id.houseNumberSpinner);
        initSpinnerCountries();
        initHouseNumbersSpinner();
    }

    public void initSpinnerCountries() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this,
                R.array.countries,
                android.R.layout.simple_spinner_item
                );
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCountriesSpinner.setAdapter(adapterCountries);
        mCountriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view,
                                       int position,
                                       long id) {
                String[] countries = getResources().getStringArray(R.array.countries);
                initSpinnerCities(position);
                Log.i(TAG, "Выбрана позиция: " + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void initSpinnerCities(int position) {
        ArrayAdapter<CharSequence> adapter;
        switch (position) {
            case 0:
                adapter = ArrayAdapter.createFromResource(this, R.array.r_cities,
                        android.R.layout.simple_spinner_item);
                break;
            case 1:
                adapter = ArrayAdapter.createFromResource(this, R.array.u_cities,
                        android.R.layout.simple_spinner_item);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this, R.array.b_cities,
                        android.R.layout.simple_spinner_item);
                break;
            default:
                adapter = null;
        }
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mCitiesSpinner.setAdapter(adapter);
        }
    }

    public void initHouseNumbersSpinner() {
        Integer[] houseNumbers = new Integer[50];
        for (int i = 1; i <= 50; i++) {
            houseNumbers[i - 1] = i;
        }
        ArrayAdapter<Integer> adapterHouseNumber = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_dropdown_item,
                houseNumbers);
        mHouseNumberSpinner.setAdapter(adapterHouseNumber);
    }
}
