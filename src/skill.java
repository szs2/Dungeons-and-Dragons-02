import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class skill {
    private String name;
    private String optional;
    private String short_desc;
    private int stat_affinity;
    private int ranks;
    private skill next_skill;

    public skill(String name, String optional,String short_desc, int ranks, skill next_skill) {
        super();
        this.name = name;
        this.optional = optional;
        this.short_desc = short_desc;
        this.stat_affinity = stat_affinity;
        this.ranks = ranks;
        this.next_skill = next_skill;
    }
    public String getName(){
        return name;
    }

    public String getOptional(){
        return optional;
    }

    public String getshort_desc(){
        return short_desc;
    }

    public void setOptional(String optional){
        this.optional = optional;
    }

    public void setShort_desc(String short_desc){
        this.short_desc =short_desc;
    }

    public int getstat_affinity(){
        return stat_affinity;
    }

    public void setStat_affinity(int stat_affinit){
        this.stat_affinity = stat_affinity;
    }

    public int getRabk(){
        return ranks;
    }

    public void setRanks(int ranks){
        this.ranks = ranks;
    }

    public skill getNext_Skill(){
        return next_skill;
    }

    public void setNext_skill(skill next_Skill){
        this.next_skill = next_Skill;
    }

    public static void File() throws IOException {
        File file = new File("My file.txt");
        FileWriter fw = new FileWriter(file, false);

        PrintWriter printwriter = new PrintWriter(fw , true);

        printwriter.println("Athletics");
        printwriter.println("Acrobatics");
        printwriter.println("Animal_handling");
        printwriter.println("Arcana");
        printwriter.println("Deception");
        printwriter.println("History");
        printwriter.println("Insight");
        printwriter.println("Intimidation");
        printwriter.println("Investigation");
        printwriter.println("Medicine");
        printwriter.println("Nature");
        printwriter.println("Perception");
        printwriter.println("Perfomanse");
        printwriter.println("Persuasion");
        printwriter.println("Religion");
        printwriter.println("Sleight_of_Hand");
        printwriter.println("Stealth");
        printwriter.println("Survival");

        Scanner sc = new Scanner(file);

    }


}
