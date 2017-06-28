package com.example.android.quakereport;

/**
 * Created by SOURABH RANA on 23-06-2017.
 */

public class Flavour {
    private double mag;

    private String place;

    private long timeinmm;
    private String url;

    public Flavour(double fmag, String fplace, long ftime,String furl)
    {
        mag = fmag;
        place = fplace;
        timeinmm = ftime;
        url=furl;
    }

    public long getTime() {
        return timeinmm;
    }

    public double getMag() {
        return mag;
    }

    public String getplace() {
        return place;

    }
    public String getUrl(){
        return url;
    }
}
