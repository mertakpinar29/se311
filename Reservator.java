// 1- Display given element's schedule.
// 2- Make a reservation for given equipment type
// 3- Unlock room by security

import java.util.ArrayList;
import java.util.Scanner;

public class Reservator {
    class Reservation {
        String name;
        String reservationName;
        Room room;
        CompositeEquipment compositeEquipment;

        public Room getRoom() {
            return room;
        }

        public Reservation(String name, String reservationName, Room room) {this.name = name; this.reservationName = reservationName; this.room = room;}
        public Reservation(String name, String reservationName,CompositeEquipment compositeEquipment) {this.name = name; this.reservationName = reservationName; this.compositeEquipment = compositeEquipment;}

        public String getName() {
            return name;
        }
    }

    private static Reservator reservatorInstance = null;

    ArrayList<Reservation> equipmentReservations;
    ArrayList<Reservation> roomReservations;
    private Reservator() {
        this.equipmentReservations = new ArrayList<>();
        this.roomReservations = new ArrayList<>();
    }

    public static Reservator getInstance() {
        if(reservatorInstance == null) reservatorInstance = new Reservator();

        return reservatorInstance;
    }

    public void displayWeeklyScheduleEquipments(CompositeEquipment compositeEquipment) {
        if(compositeEquipment.getType() != 3) {System.out.println("You can't check single equipment's schedule");}
        else {
            String[] weeklySchedule = compositeEquipment.getWeeklySchedule();
            for(int i = 0; i < weeklySchedule.length; i++) {
                System.out.println(weeklySchedule[i]);
            }
        }
    }

    public void displayWeeklyScheduleRooms(Room room) {
        String[] weeklySchedule = room.getWeeklySchedule();
        for(int i = 0; i < weeklySchedule.length; i++){
            System.out.println(weeklySchedule[i]);
        }
    }

    public void makeEquipmentReservation(CompositeEquipment compositeEquipment, Scanner scanner, String userName) {
        System.out.println("Schedule for " + compositeEquipment.getName());
        displayWeeklyScheduleEquipments(compositeEquipment);
        System.out.println("Type an integer to select a day.");
        int choice = scanner.nextInt();
        String[] weeklySchedule = compositeEquipment.getWeeklySchedule();
        if(weeklySchedule[choice] == "full") {System.out.println("You can not use " + compositeEquipment.getName() + " this day.");}
        else {
            weeklySchedule[choice] = "full";
            compositeEquipment.setWeeklySchedule(weeklySchedule);
            equipmentReservations.add(new Reservation(userName, compositeEquipment.getName(), compositeEquipment));
            System.out.println("Your reservation has been made.");
        }
    }

    public void makeRoomReservation(Room room, Scanner scanner, String userName) {
        System.out.println("Schedule for " + room.getName());
        displayWeeklyScheduleRooms(room);
        System.out.println("Type an integer to select a day.");
        int choice = scanner.nextInt();
        String[] weeklySchedule = room.getWeeklySchedule();
        if(weeklySchedule[choice] == "full") {System.out.println("You can not use " + room.getName() + " this day.");}
        else {
            weeklySchedule[choice] = "full";
            room.setWeeklySchedule(weeklySchedule);
            roomReservations.add(new Reservation(userName, room.getName(), room));
            System.out.println("Your reservation has been made.");
        }
    }

    public void unlockRoom(Security security, Scanner scanner) {
        System.out.println("Type an integer to select your reservation");
        for(int i = 0; i < roomReservations.size(); i++) {
            System.out.println(roomReservations.get(i).name + " - " + roomReservations.get(i).reservationName);
        }
        int choice = scanner.nextInt();
        Security.unlockRoom(roomReservations.get(choice).getRoom());
        System.out.println("Room has been unlocked");
    }
}
