package br.com.mxtheuz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static String getDate() {
        Date dataAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh/MM/yyyy hh:mm:ss");
        return sdf.format(dataAtual);
    }
}
