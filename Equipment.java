import java.util.ArrayList;

// types: 0 -> VIDEO, 1 -> AUDIO, 2 -> EDIT, 3 -> Identifier, 4 -> Root
interface Asset {
    void Add(Asset d);
    void Display(int indent);
    public String getName();
}
//This is the "Leaf".
class PrimitiveEquipment implements Asset {
    private int type;
    private String name;
    public String getName() { return name;}
    public PrimitiveEquipment(String name, int type) {this.name = name; this.type = type;}
    public void Add(Asset c) {
        System.out.println("It can not have a sub-equipment.");
    }
    public void Display(int indent) {
        for(int i = 1;i <= indent;i++) 	System.out.print("-");
        System.out.println(" "  + name);
    }
}
// This is the "Composite"
class CompositeEquipment implements Asset {
    String[] weeklySchedule;
    private int type;
    private String name;
    public String getName() { return name;}
    public int getType() {
        return type;
    }

    public String[] getWeeklySchedule() {
        return weeklySchedule;
    }

    public void setWeeklySchedule(String[] weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }

    public CompositeEquipment(String name, int type) {
        this.name = name;
        this.type = type;
        if(type == 3) {
            this.weeklySchedule = new String[5];
            this.weeklySchedule[0] = "Monday";
            this.weeklySchedule[1] = "Tuesday";
            this.weeklySchedule[2] = "Wednesday";
            this.weeklySchedule[3] = "Thursday";
            this.weeklySchedule[4] = "Friday";
        }
    }
    public void Add(Asset d) {elements.add(d);};

    public void Display(int indent) {
        for(int i = 1;i <= indent;i++) System.out.print("-");
        System.out.println( "+ " + getName());

        // Display each child element on this node
        for (int i= 0; i< elements.size(); i++) {
            elements.get(i).Display(indent+2);
        }
    }

    private	ArrayList<Asset> elements = new ArrayList<Asset>();
}



//This is the "client"
public class Equipment {
    public static void getWeeklySchedule(CompositeEquipment compositeEquipment) {
        if(compositeEquipment.getType() != 3) {System.out.println("You can not check single equipment's schedule.");}
        else {
            String[] weeklySchedule = compositeEquipment.getWeeklySchedule();
            for(int i = 0; i < weeklySchedule.length; i++) {
                System.out.println(weeklySchedule[i]);
            }
        }
    }


}