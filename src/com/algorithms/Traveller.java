package com.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
public class Traveller {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm");
    public static void main(String[] args) throws ParseException {
        BufferedReader in;
        List<String> flights = new LinkedList<>();
        double maxStopOverTime = 0;
        List<String> lines = new LinkedList<>();
        int result = 0;
        try {
            in = new BufferedReader(new FileReader(new File(args[0])));
            while (in.ready()) {
                lines.add(in.readLine());
            }
            for (int i = 1; i < lines.size();
                 i++)
                flights.add(lines.get(i));
            maxStopOverTime = Double.parseDouble(lines.get(0));
            /* YOUR  CODE HERE */
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

