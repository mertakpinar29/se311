public class Room {
    String roomName;
    String[] weeklySchedule;
    boolean locked;

    public String getName() { return roomName;}
    public String[] getWeeklySchedule() {
        return weeklySchedule;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setWeeklySchedule(String[] weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }

    public Room(String roomName) {
        this.roomName = roomName;
        this.locked = true;
        this.weeklySchedule = new String[5];
        this.weeklySchedule[0] = "full";
        this.weeklySchedule[1] = "Tuesday";
        this.weeklySchedule[2] = "Wednesday";
        this.weeklySchedule[3] = "full";
        this.weeklySchedule[4] = "Friday";
    }
}
