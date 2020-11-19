public class Table {
    static int num;
    static int index;
    static String player;

    public static String[][] table(){
        String[][] chars=new String[3][3];
        num=0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                num++;
                chars[i][j]= String.valueOf(num);
            }
        }
        return chars;
    }
    public static void printTable(String[][] chars){
        String[][] chars1;
        chars1=chars;
        System.out.println("--*--");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(chars1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--*--");
    }
    public static void main(String[] args) {
        Game game= new Game();
        game.play();
    }
}
