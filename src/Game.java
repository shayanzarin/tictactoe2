import java.util.Scanner;
public class Game extends Table {
    static int count=0;
    static int x=0,o=0;
    static int flag=0;
    static boolean end = true;
    static String[][] string =table();

    public void play() {
        Scanner scanner = new Scanner(System.in);
        x=0;
        o=0;
        count=0;
        while (end) {
            while (true) {
                System.out.println("X or O?");
                player = scanner.next();
                if (player.equals("x") && x==0){
                    printTable(string);
                    x = 1;
                    o = 0;
                    break;
                }else if (player.equals("o") && o==0){
                    printTable(string);
                    x = 0;
                    o = 1;
                    break;
                }else System.out.println("Try again!");
            }
            while (true) {
                System.out.println("Enter the index");
                index = scanner.nextInt();
                if (index > 0 && index <10) {
                    count++;
                    printTable(done(string, player, index));
                    check();
                    break;
                } else System.out.println("try again!");
            }
        }
    }

    public static String[][] done(String[][] chars2, String player, int index) {
        string=chars2;
        int cnt=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (string[i][j].equals(String.valueOf(index))) {
                    cnt=1;
                    string[i][j] = player.toUpperCase();
                }
            }
        }
        if (cnt!=1){
            System.out.println("try again!");
            count--;
            if (player.equals("x")){
                x=0;
                o=1;
            }else if (player.equals("o")){
                o=0;
                x=1;
            }
        }
        return string;
    }
    public void check(){
        String[][] str = string;
        if (str[0][0].equals(str[0][1]) && str[0][0].equals(str[0][2])){
            if (continuePlaying() == 1) {
                end = false;
                return;
            }
        }if (str[1][0].equals(str[1][1]) && str[1][0].equals(str[1][2])){
            if (continuePlaying() == 1) {
                end = false;
                return;
            }
        }if (str[2][0].equals(str[2][1]) && str[2][0].equals(str[2][2])){
            if (continuePlaying() == 1) {
                end = false;
                return;
            }
        }if (str[0][0].equals(str[1][0]) && str[0][0].equals(str[2][0])){
            if (continuePlaying() == 1) {
                end = false;
                return;
            }
        }if (str[0][1].equals(str[1][1]) && str[0][1].equals(str[2][1])){
            if (continuePlaying() == 1) {
                end = false;
                return;
            }
        }if (str[0][2].equals(str[1][2]) && str[0][2].equals(str[2][2])){
            if (continuePlaying() == 1) {
                end = false;
                return;
            }
        }if (str[0][0].equals(str[1][1]) && str[0][0].equals(str[2][2])){
            if (continuePlaying() == 1) {
                end = false;
                return;
            }
        }if (str[0][2].equals(str[1][1]) && str[0][2].equals(str[2][0])){
            if (continuePlaying() == 1) {
                end = false;
            }
        }else if (count==9){
            System.out.println("The game ended in a draw");
            count=20;
            o=0;
            x=0;
            if (continuePlaying() == 1) {
                end = false;
            }
        }
    }

    public int continuePlaying(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("<------->");
        if (x==1 && count != 20){
            System.out.println("X won!");
        }else if (x==0 && count != 20){
            System.out.println("O won!");
        }
        System.out.println("<------->");
        System.out.println("Do you want to play again? yes or no");
        String str=scanner.nextLine();
        if (str.equals("yes")){
             flag=0;
            string=table();
            count=0;
        }else if (str.equals("no")){
            flag=1;
            end=false;
            System.out.println("*---*---*");
        }
        return flag;
    }
}
