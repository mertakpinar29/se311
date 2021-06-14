import java.util.ArrayList;
// Ekipmanlarla ilgili işlemler, odalarla ilgili işlemler, odaların açtırılması, bütün ekipman ve odaların display edilmesi

public class Test {
    public static void main(String[] args) {
        ArrayList<Asset> Equipments = new ArrayList<>();
        ArrayList<Room> Rooms = new ArrayList<>();

        Room VideoEditingRoom = new Room("Video Edit room 1");


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

    }
}
