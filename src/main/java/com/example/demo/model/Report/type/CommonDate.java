package com.example.demo.model.Report.type;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CommonDate {
    private final LocalDate date;


    public CommonDate(LocalDate date) {
        this.date = date;
    }

    public CommonDate(String inputDate) {
        if (inputDate == null) {
            throw new IllegalArgumentException("Input date cannot be null");
        }

        if (!isValidInputDate(inputDate)) {
            throw new IllegalArgumentException("Invalid input date format");
        }

        if (inputDate.contains("-")) {
            this.date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            this.date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        }
    }

    public CommonDate(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }

    private boolean isValidInputDate(String inputDate) {
        return inputDate.matches("\\d{4}(\\-?\\d{2}\\-?\\d{2})?");
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return date.format(formatter);
    }

    public int getYear() {
        return date.getYear();
    }

    public int getMonth() {
        return date.getMonthValue();
    }

    public int getDay() {
        return date.getDayOfMonth();
    }

}

