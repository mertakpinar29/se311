public class User {
    String name;

    public String getName() {
        return name;
    }

    public User(String name) {this.name = name;}

    public void EquipmentUpdate(Asset equipment) {
        System.out.println(equipment.getName() + " is available now,");
    }

    public void RoomUpdate(Room room) {
        System.out.println(room.getName() + " is available now,");
    }
}
