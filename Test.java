import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;
// Ekipmanlarla ilgili işlemler, odalarla ilgili işlemler, odaların açtırılması, bütün ekipman ve odaların display edilmesi
// Belli bir gün için bütün available room ve equipments


public class Test {
    public static void main(String[] args) {
        ArrayList<CompositeEquipment> Equipments = new ArrayList<>();
        ArrayList<Room> Rooms = new ArrayList<>();

        Room VideoEditingRoom1 = new Room("Video Edit room 1");
        Room VideoEditingRoom2 = new Room("Video Edit room 2");

        Rooms.add(VideoEditingRoom1);
        Rooms.add(VideoEditingRoom2);



        // Create a tree structure
        Asset EquipmentsRoot = new CompositeEquipment("Equipments", 4);
        CompositeEquipment VideoEquipments = new CompositeEquipment("Video Equipments", 3);
        CompositeEquipment AudioEquipments = new CompositeEquipment("Audio Equipments", 3);
        CompositeEquipment VideoEditingEquipments = new CompositeEquipment("Video Editing Equipments", 3);


        Equipments.add(VideoEquipments);
        Equipments.add(AudioEquipments);
        Equipments.add(AudioEquipments);

        EquipmentsRoot.Add(VideoEquipments);
        EquipmentsRoot.Add(AudioEquipments);
        EquipmentsRoot.Add(VideoEditingEquipments);

        Asset Camera = new PrimitiveEquipment("Camera", 0);
        Asset Tripod = new PrimitiveEquipment("Tripod", 0);
        Asset LightningKit = new CompositeEquipment("LightningKit", 0);

        VideoEquipments.Add(Camera);
        VideoEquipments.Add(Tripod);
        VideoEquipments.Add(LightningKit);

        Asset LightStand = new PrimitiveEquipment("Light Stand", 0);
        Asset PowerSupply = new PrimitiveEquipment("Power Supply", 0);
        Asset Umbrella = new PrimitiveEquipment("Umbrella", 0);

        LightningKit.Add(LightStand);
        LightningKit.Add(PowerSupply);
        LightningKit.Add(Umbrella);

        Asset Microphone = new PrimitiveEquipment("Microphone", 1);
        Asset LoudSpeakers = new PrimitiveEquipment("Loudspeakers", 1);
        Asset Amplifier = new PrimitiveEquipment("Amplifier", 1);

        AudioEquipments.Add(Microphone);
        AudioEquipments.Add(Amplifier);
        AudioEquipments.Add(LoudSpeakers);

        Asset Software = new PrimitiveEquipment("Software", 2);

        VideoEditingEquipments.Add(Software);

        Reservator reservator = Reservator.getInstance();
        Scanner scanner = new Scanner(System.in);
        Security security = new Security();

        System.out.println("Welcome.Please enter your name:");
        String name = scanner.nextLine();
        User user = new User(name);

        /*

        // for observer testing

        VideoEditingRoom1.watchers.add(user);

        // enter 3
        reservator.getAvailableEquipmentsRoomsForDay(scanner,Equipments, Rooms );
        System.out.println();

        // this will change weeklyschedule for thursday. ("full" to "Thursday") and room will be available, user will be notified.
        reservator.setRoomAvailability(VideoEditingRoom1,3, "Thursday");

        // lets check again the weekly schedule.
        // enter 3
        reservator.getAvailableEquipmentsRoomsForDay(scanner,Equipments, Rooms );

        */




        boolean runner1 = true;

        while(runner1) {
            System.out.println("0 - Equipment Reservation");
            System.out.println("1 - Room Reservation");
            System.out.println("2 - Unlock Room");
            System.out.println("3 - Display available equipments for a selected day.");
            int choice1 = scanner.nextInt();

            switch(choice1) {
                case 0:
                    System.out.println("0 - Video Equipment Reservation");
                    System.out.println("1 - Audio Equipment Reservation");
                    System.out.println("2 - Video Editing Equipment Reservation");

                    int equipmentChoice = scanner.nextInt();

                    if(equipmentChoice == 0) {
                        reservator.makeEquipmentReservation(VideoEquipments,scanner,user.getName());
                        break;
                    }else if(equipmentChoice == 1) {
                        reservator.makeEquipmentReservation(VideoEquipments,scanner,user.getName());
                        break;
                    }else if(equipmentChoice == 2) {
                        reservator.makeEquipmentReservation(VideoEditingEquipments,scanner,user.getName());
                        break;
                    }else {break;}

                case 1:
                    System.out.println("Select a room to make a reservation");
                    for(int i = 0; i < Rooms.size(); i++) {
                        System.out.println(i + " - " + Rooms.get(i).roomName);
                    }
                    int roomChoice = scanner.nextInt();
                    if(roomChoice >= Rooms.size()) { break; }
                    reservator.makeRoomReservation(Rooms.get(roomChoice), scanner, user.getName());
                    break;

                case 2:
                    reservator.unlockRoom(security, scanner);
                    break;

                case 3:
                    reservator.getAvailableEquipmentsRoomsForDay(scanner, Equipments, Rooms);
                    break;
            }

        }
    }
}
