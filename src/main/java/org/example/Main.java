package org.example;

import org.example.configs.InvalidFormatException;
import org.example.entities.Appointment;
import org.example.entities.Owner;
import org.example.entities.Pet;
import org.example.services.AppointmentService;
import org.example.services.OwnerService;
import org.example.services.PetService;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Pet-Clinic\n" +
                "Please chose one of the following options:\n" +
                "0 - End session.\n" +
                "1 - Register a pet.\n" +
                "2 - Display all pets.\n" +
                "3 - Register a owner.\n" +
                "4 - Display all owners.\n" +
                "5 - Register an appointment.\n" +
                "6 - Display all appointments.\n" +
                "7 - Add a...");

        PetService petService = new PetService();
        OwnerService ownerService = new OwnerService();
        AppointmentService appointmentService = new AppointmentService();

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        switch (number){
           case 0:
               System.out.println("Session ended");
               break;
           case 1:
               petService.registerPet();
           case 2:
               petService.displayAllPets();
           case 3:
               ownerService.registerOwner();
           case 5:
               try {
                   appointmentService.registerAppointment();
               } catch (InvalidFormatException e) {
                   System.out.println(e.getMessage());
               }
        }
    }
}
