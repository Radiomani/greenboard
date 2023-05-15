package com.example.utils;

public class TimeFormat {
    private int dd;
    private int mm;
    private int yyyy;
    private int h;
    private int m;
    private int s;

    public TimeFormat(int dd, int mm, int yyyy) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }

    public TimeFormat(int dd, int mm, int yyyy, int h) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
        this.h = h;
        this.m = 0;
        this.s = 0;
    }

    public TimeFormat(int dd, int mm, int yyyy, int h, int m) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
        this.h = h;
        this.m = m;
        this.s = 0;
    }

    public TimeFormat(int dd, int mm, int yyyy, int h, int m, int s) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
        this.h = h;
        this.m = m;
        this.s = s;
    }

    String getTimeString() {
        String format = dd < 10 ? "%d%d-" : "%d-";
        format += mm < 10 ? "%d%d-" : "%d-";
        format += "%d|";
        format += h < 10 ? "%d%d:" : "%d:";
        format += m < 10 ? "%d%d:" : "%d:";
        format += s < 10 ? "%d%d:" : "%d:";
        String formattedString = String.format(format, dd, mm, yyyy, h, m, s);
        return formattedString;
    }
}