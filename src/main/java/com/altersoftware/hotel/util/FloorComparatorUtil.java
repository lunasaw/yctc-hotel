package com.altersoftware.hotel.util;

public class FloorComparatorUtil {

    public static int getNumber(String building) {
        int number = 0;
        switch (building) {
            case "一":
                number = 1;
                break;
            case "二":
                number = 2;
                break;
            case "三":
                number = 3;
                break;
            case "四":
                number = 4;
                break;
            case "五":
                number = 5;
                break;
            case "六":
                number = 6;
                break;
            case "七":
                number = 7;
                break;
            case "八":
                number = 8;
                break;
            case "九":
                number = 9;
                break;
            case "十":
                number = 10;
                break;
            case "十一":
                number = 11;
                break;
            case "十二":
                number = 12;
                break;
            case "十三":
                number = 13;
                break;
            case "十四":
                number = 14;
                break;
            case "十五":
                number = 15;
                break;
            case "十六":
                number = 16;
                break;
            case "十七":
                number = 17;
                break;
            default:
                break;

        }
        return number;
    }
}
