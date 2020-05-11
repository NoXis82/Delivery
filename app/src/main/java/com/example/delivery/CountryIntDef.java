package com.example.delivery;

import androidx.annotation.IntDef;

@IntDef({CountryIntDef.RUS, CountryIntDef.UKR, CountryIntDef.BLR})

public @interface CountryIntDef {

    public static int RUS = 0;

    public static int UKR = 1;

    public static int BLR = 2;


}
