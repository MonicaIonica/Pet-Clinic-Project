package org.example;

import org.example.configs.InvalidFormatException;
import org.example.configs.InvalidMismatchException;
import org.example.services.AppointmentService;
import org.example.services.OwnerService;
import org.example.services.PetService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetService petService = new PetService();
        OwnerService ownerService = new OwnerService();
        AppointmentService appointmentService = new AppointmentService();

        Scanner input = new Scanner(System.in);
        int number;
        do {
            System.out.println("Welcome to the Pet-Clinic\n" +
                    "Please chose one of the following options:\n" +
                    "0 - End session.\n" +
                    "1 - Register a pet.\n" +
                    "2 - Display all pets.\n" +
                    "3 - Register a owner.\n" +
                    "4 - Display all owners.\n" +
                    "5 - Register an appointment.\n" +
                    "6 - Display all appointments.\n" +
                    "7 - Display all veterinarians ");
            number = input.nextInt();

            switch (number) {
                case 0:
                    System.out.println("Session ended");
                    System.exit(0);
                    break;
                case 1:
                    petService.registerPet();
                    break;
                case 2:
                    petService.displayAllPets();
                    break;
                case 3:
                    ownerService.registerOwner();
                    break;
                case 4:
                    ownerService.displayAllOwners();
                    break;
                case 5:
                    try {
                        appointmentService.registerAppointment();
                    } catch (InvalidFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        appointmentService.displayAllAppointents();
                    } catch (InvalidMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }


        }  while (number != 0) ;
    }
}


