import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CW2 {
    static Scanner sc = new Scanner(System.in );

    public static int value,Level,hitdice,sum,s,skillpoints,StrBonus,DexBonus,ConBonus,IntBonus,WisBonus,ChaBonus;
    public static String[] characterclass={"Barberian","Bard","Druid","Monk","Rogue","Warlock","Fighter","Ranger","Paladin","Sorcerer","Wizard"};
    static String Class;


    private static int Str;  /*declare the values as static variables*/
    private static int Dex;
    private  static int Con;
    private static int Int;
    private static int Wis;
    private static int Cha;

    public static void main(String[] args) throws IOException {
        String user;

        System.out.println("Enter user's name : ");     //prompt user's name
        user = sc.next();

        System.out.println("Enter Level : ");   //ask value for Level
        Level= validate(Level);     //


        for(int i=0;i<characterclass.length;i++){
                    System.out.println(characterclass[i]);
        }

        int[] dicefaces={12,8,8,8,8,8,10,10,10,6,6};
        int a =1;
        while (a==1){
            System.out.println("Enter Character.class : ");
            Class= sc.next();

        switch(Class){
            case "Barberian" : hitdice=dicefaces[0];
                break;
            case "Bard" : hitdice=dicefaces[1];
                break;
            case "Druid" : hitdice=dicefaces[2];
                break;
            case "Monk" : hitdice=dicefaces[3];
                break;
            case "Rogue" : hitdice=dicefaces[4];
                break;
            case "Warlock" : hitdice=dicefaces[5];
                break;
            case "Fighter" : hitdice=dicefaces[6];
                break;
            case "Ranger" : hitdice=dicefaces[7];
                break;
            case "Paladin" : hitdice=dicefaces[8];
                break;
            case "Sorcerer" : hitdice=dicefaces[9];
                break;
            case "Wizard" : hitdice=dicefaces[10];
                break;
            default: System.err.println("invalid Character.class");

        }
        System.out.println("You select "+Class +" as Character.class,");
        System.out.println("If you want to change the Class enter '1' , " +
                "not enter 'any number'");
        a =sc.nextInt();
        }


        String[] Skill =new String[18];
        System.out.println("Enter any skill from fillowing list");
        System.out.println(" Athletics, Acrobactics, Animal_handling,Arcana,Deception,");
        System.out.println("History, Insight, Intimidation, Investigation, Medicine, Nature, Perception,");
        System.out.println(" Perfomanse, Persuasion, Religion, Sleight_of_hand, Stealth, Survival.");
       for(s=0;s<Level;s++){
           System.out.println("Enter skill "+(s+1));
           Skill[s] = sc.next();
       }

       skill.File();
       int method;
        System.out.println("there are four methods in this program.");
        System.out.println("Enter '1' to continue the program with method 1 ,");
        System.out.println("Enter '2' to continue the program with method 2 ,");
        System.out.println("Enter '3' to continue the program with method 3 ,");
        System.out.println("Enter '4' to continue the program with method 4 ,");

        method= sc.nextInt();

        if(method == 1){
            method1();
        }else if (method == 2){
            method2();
        }else if (method == 3){
            method3();
        }else {
            method4();
        }

        System.out.println("User's name : "+ user); // display user's name
        System.out.println("Level : ["+Level+"]");  //display Level
        System.out.println("Character.class : "+ Class);    //Display class

        for(s=0; s< Level;s++);{
            System.out.println("Skill "+(s+1)+ " : "+Skill[s]);
        }


        System.out.println("----------------------------------------");
        bonus("Str", Str,StrBonus);
        bonus("Dex", Dex,DexBonus);
        bonus("Con", Con,ConBonus);
        bonus("Int", Int,IntBonus);
        bonus("Wis", Wis,WisBonus);
        bonus("Cha", Cha,ChaBonus);
        System.out.println("----------------------------------------");

        int HP;
        if (ConBonus>0) {
            HP = (Level*((int)((Math.random()*1000%hitdice)+ConBonus)));
        }else{
            HP = (Level*((int)((Math.random()*1000%hitdice)+1)));
        }
        System.out.println("HP: [" + HP + "]");                         //display HintPoint

        calculate_skillpoints();
        System.out.println("Skill points : ["+skillpoints+"]");

        double BAB;
        if(Class.equals(characterclass[0]) || Class.equals(characterclass[6]) || Class.equals(characterclass[7]) || Class.equals(characterclass[8]) ){
            BAB = Level ;
        }else if (Class.equals(characterclass[1]) || Class.equals(characterclass[2]) || Class.equals(characterclass[3]) || Class.equals(characterclass[4]) || Class.equals(characterclass[5]) ){
            BAB = ((Level * 3)/4);
        }else{
            BAB = (Level/2);
        }
        System.out.println("Base Attack Bonus : ["+BAB+"]" );

        double combat = BAB + StrBonus;
        System.out.println("Combat : ["+combat+"]" );

        int damage = StrBonus;
        System.out.println("Damage : ["+damage+"]" );

        int save;
        System.out.println("'If you want to save the characters in a file' press 1 , not press any key");
        save = sc.nextInt();

        if(save ==1);

        File all = new File("Characters.txt");
        FileWriter cc = new FileWriter(all, false);

        PrintWriter writer = new PrintWriter(cc , true);

        writer.println("User name       : "+user);
        writer.println("Level           : "+Level);
        writer.println("Character.class : "+Class);
        writer.println("-------------------------------------");
        writer.println("Str    : "+Str+"  StrBonus    : "+StrBonus);
        writer.println("Dex    : "+Dex+"  DexBonus    : "+DexBonus);
        writer.println("Con    : "+Con+"  ConBonus    : "+ConBonus);
        writer.println("Int    : "+Int+"  IntBonus    : "+IntBonus);
        writer.println("Wis    : "+Wis+"  WisBonus    : "+WisBonus);
        writer.println("Cha    : "+Cha+"  ChaBonus    : "+ChaBonus);
        writer.println("-------------------------------------");
        writer.println("Hitpoints       : "+HP);
        writer.println("Skill points    : "+skillpoints);
        writer.println("Base Attack Bonus : "+BAB);
        writer.println("Combat : "+combat);
        writer.println("Damage : "+damage);

        }

    public static void method1() {
        System.out.println("Enter Str : ");     //ask value for Str
        Str = validate(Str);

        System.out.println("Enter Dex : ");     //ask value for Dex
        Dex = validate(Dex);

        System.out.println("Enter Con : ");     //ask value for Con
        Con = validate(Con);

        System.out.println("Enter Int : ");     //ask value for Int
        Int = validate(Int);

        System.out.println("Enter Wis : ");     //ask value for Wis
        Wis = validate(Wis);

        System.out.println("Enter Cha : ");     //ask value for Cha
        Cha = validate(Cha);
        }

    public static void method2 (){
        int input = 0;
        while (input != 1) {

            Str = select();
            Dex = select();                                    //get value for Dex
            Con = select();                                     //get value for Con
            Int = select();                                   //get value for Int
            Wis = select();                                      //get value for Wis
            Cha = select();                                    //get value for Cha

            System.out.println("Str : [" + Str + "]");
            System.out.println("Dex : [" + Dex + "]");
            System.out.println("Con : [" + Con + "]");
            System.out.println("Int : [" + Int + "]");
            System.out.println("Wis : [" + Wis + "]");
            System.out.println("Cha : [" + Cha + "]");

            System.out.println("If you agree with this values enter'1' & If you are not enter 'any key'.");
            input = sc.nextInt();
        }
    }

    public static void method3(){
        int input = 0;
        while (input != 1) {

            Str = select1();
            Dex = select1();                                    //get value for Dex
            Con = select1();                                     //get value for Con
            Int = select1();                                   //get value for Int
            Wis = select1();                                      //get value for Wis
            Cha = select1();                                    //get value for Cha

            System.out.println("Str : [" + Str + "]");
            System.out.println("Dex : [" + Dex + "]");
            System.out.println("Con : [" + Con + "]");
            System.out.println("Int : [" + Int + "]");
            System.out.println("Wis : [" + Wis + "]");
            System.out.println("Cha : [" + Cha + "]");

            System.out.println("If you agree with this values enter'1' & If you are not enter 'any key'.");
            input = sc.nextInt();
        }
    }

    public static void method4(){
        int input =0;
        while (input!=1){
            switch(Class){
                case "Barberian" :
                    Str = high1(9);
                    Dex = high1(8);
                    Con = high1(7);
                    Int = high1(5);
                    Wis = high1(6);
                    Cha = high1(4);
                    break;
                case "Bard" :
                    Str = high1(4);
                    Dex = high1(9);
                    Con = high1(6);
                    Int = high1(7);
                    Wis = high1(5);
                    Cha = high1(8);
                    break;
                case "Druid" :
                    Str = high1(9);
                    Dex = high1(6);
                    Con = high1(7);
                    Int = high1(5);
                    Wis = high1(8);
                    Cha = high1(4);
                    break;
                case "Monk" :
                    Str = high1(9);
                    Dex = high1(7);
                    Con = high1(6);
                    Int = high1(5);
                    Wis = high1(8);
                    Cha = high1(4);
                    break;
                case "Rogue" :
                    Str = high1(7);
                    Dex = high1(9);
                    Con = high1(8);
                    Int = high1(5);
                    Wis = high1(6);
                    Cha = high1(4);
                    break;
                case "Warlock" :
                    Str = high1(5);
                    Dex = high1(7);
                    Con = high1(8);
                    Int = high1(5);
                    Wis = high1(6);
                    Cha = high1(9);
                    break;
                case "Fighter" :
                    Str = high1(9);
                    Dex = high1(7);
                    Con = high1(8);
                    Int = high1(5);
                    Wis = high1(6);
                    Cha = high1(4);
                    break;
                case "Ranger" :
                    Str = high1(8);
                    Dex = high1(9);
                    Con = high1(6);
                    Int = high1(5);
                    Wis = high1(7);
                    Cha = high1(4); ;
                    break;
                case "Paladin" :
                    Str = high1(9);
                    Dex = high1(6);
                    Con = high1(7);
                    Int = high1(4);
                    Wis = high1(5);
                    Cha = high1(8);
                    break;
                case "Sorcerer" :
                    Str = high1(4);
                    Dex = high1(8);
                    Con = high1(7);
                    Int = high1(5);
                    Wis = high1(6);
                    Cha = high1(9);
                    break;
                case "Wizard" :
                    Str = high1(5);
                    Dex = high1(8);
                    Con = high1(7);
                    Int = high1(9);
                    Wis = high1(6);
                    Cha = high1(4);
                    break;
            }

            System.out.println("Str : [" + Str + "]");
            System.out.println("Dex : [" + Dex + "]");
            System.out.println("Con : [" + Con + "]");
            System.out.println("Int : [" + Int + "]");
            System.out.println("Wis : [" + Wis + "]");
            System.out.println("Cha : [" + Cha + "]");

            System.out.println("If you agree with this values enter'1' & If you are not enter 'any key'.");
            input = sc.nextInt();
        }
    }

    public static int validate(int value){
        Scanner sc = new Scanner(System.in); //declare variable for each value

        while (!sc.hasNextInt()) {      // check value is a integer
            System.out.println("Invalid input. Enter a number.");
            sc.next();
        }
        value = sc.nextInt();
        while(value <=0){       // check value is a positive number
            System.out.println("Invalid input ,Enter a positive number");
            value = sc.nextInt();
        }
        return value;
    }

    public static int select(){
        int a = (int) (Math.random() * 1000 % 6 + 1);
        int b = (int) (Math.random() * 1000 % 6 + 1);
        int c = (int) (Math.random() * 1000 % 6 + 1);
        int d = (int) (Math.random() * 1000 % 6 + 1);

        if (a < b || a < c || a < d) {
            value = b + c + d;
        } else if (b < a || b < c || b < d) {
            value = a + c + d;
        } else if (c < a || c < b || c < d) {
            value = a + b + d;
        } else {
            value = a + b + c;
        }
        return value;
    }

    public static int select1(){
        int a = (int) (Math.random() * 1000 % 6 + 1);
        int b = (int) (Math.random() * 1000 % 6 + 1);
        int c = (int) (Math.random() * 1000 % 6 + 1);
        int d = (int) (Math.random() * 1000 % 6 + 1);

        if (a < b || a < c || a < d) {
            value = b + c + d;
        } else if (b < a || b < c || b < d) {
            value = a + c + d;
        } else if (c < a || c < b || c < d) {
            value = a + b + d;
        } else {
            value = a + b + c;
        }
        if(value >16){
            int e =  (int) (Math.random() * 1000 % 6 + 1);
            value+=e;
        }
        return value;
    }

    public static int high1(int number){
        int[] values = new int[9];
        for(int i=0;i<number;i++){
            values[i] =(int) (Math.random() * 1000 % 6 + 1);
        }
        int max;
        int maxi;
        sum=0;
        for (int j=0;j<3;j++){
            maxi = 0;
            max= values[maxi];
            for (int q =1;q<number;q++){
                if (values[j]>max){
                    max=values[q];
                    maxi = q;
                }
            }
            sum +=max;
            values[maxi]=0;
        }
        return sum;
    }

    public static void bonus(String name, int value,int StatBonus){
        StatBonus = 0;

        if (value == 10){
            System.out.println(name+" : ["+value+"] ["+StatBonus+"]");
        } else if (value>10){

            for (int i = 11;i <= value;i++){
                if (i %2 ==0){
                    StatBonus++;
                }
            }System.out.println(name+" : ["+value+"]+["+StatBonus+"]");
        }else {
            for (int i= 9;i>=value;i--){
                if (i%2==1){
                    StatBonus++;
                }
            }System.out.println(name+" : ["+value+"]-["+StatBonus+"]");
        }
    }


    public static int skillpoint(int skill_grant){
        if (IntBonus<0){
            skillpoints = 1;
        }

        if (Level == 1){
            skillpoints = ((skill_grant+IntBonus)*4);
        }else{
            skillpoints= ((skill_grant+IntBonus)*(CW2.Level+3));
        }

        return skillpoints;
    }

    public static void calculate_skillpoints(){
        switch(Class){
            case "Barberian" :
                skillpoint(4);
                break;
            case "Bard" :
                skillpoint(6);
                break;
            case "Druid" :
                skillpoint(4);
                break;
            case "Monk" :
                skillpoint(4);
                break;
            case "Rogue" :
                skillpoint(8);
                break;
            case "Warlock" :
                skillpoint(2);
                break;
            case "Fighter" :
                skillpoint(2);
                break;
            case "Ranger" :
                skillpoint(6);
                break;
            case "Paladin" :
                skillpoint(2);
                break;
            case "Sorcerer" :
                skillpoint(2);
                break;
            case "Wizard" :
                skillpoint(2);
                break;
        }
    }

}

