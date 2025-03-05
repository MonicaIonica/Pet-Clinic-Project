package org.example.services;

import org.example.configs.InvalidFormatException;
import org.example.entities.Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class AppointmentService {
    public void registerAppointment() throws InvalidFormatException {
        Appointment appointment = new Appointment();
        Scanner input = new Scanner(System.in);

        System.out.println("Type the date for your appointment in  following format : yyyy-MM-dd:");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        System.out.println("Type the hour for your appointment in  following format : hh:mm:");
        String time = scanner.nextLine();
        try{
            LocalDateTime date1 = LocalDateTime.of(LocalDate.parse(date), LocalTime.parse(time));
            appointment.setDate(date1);
        } catch (Exception e) {
            throw new InvalidFormatException("Invalid format");
        }
        System.out.println(appointment);
    }
}
