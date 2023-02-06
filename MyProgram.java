import java.util.Scanner;

public class MyProgram
{
    public static Deck c;
    public static PointChecker pc;//player1 point checker
    public static PointChecker pt;//player2 point checker/computer's
    public static int betNum=0; //the bet that everyone has bet to keep playing
    public static Hand player1;
    public static Hand player2;
    public static Table t;
    public static void main(String[] args)
    {     
        game();
    }
    
    public static void ask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("call/check (c), fold(f), raise(r)");
        String str= scanner.nextLine();
        if(str.equals("f")){
            player1.fold=true;
        }
        if(str.equals("r")){
            bet();
        }
        if(player1.betting!=betNum){
            ask();
        }
        if(!str.equals("r")){
            if(!str.equals("c")){
                if(!str.equals("f")){
                    System.out.println("===================");
                    System.out.println("Invalid Response");
                    ask();
                }
            }
        }
    }
    
    public static void program(){
        c.shuffle();
        for(int i=0; i<2; i++){
            player1.draw(c);
        //player 2 temp gone for straight
            player2.draw(c);
        }
        
        player1.rHand();
        t.flop(c);
        t.rTable();
        ask();
        if(player1.fold==false){
            t.turn(c);
            clearScreen();
            player1.rHand();
            t.rTable();
            ask();
            if(player1.fold==false){
                t.river(c);
                clearScreen();
                player1.rHand();
                t.rTable();
                ask();
            }
        }
        if(player1.fold!=true){
            clearScreen();
            //System.out.println("final table: ");
            t.rTable();
            System.out.print("Computers ");
            player2.rHand();
            //pt.setup(t, player2);
            System.out.println("Your hand: ");
            player1.rHand();
            //pc.setup(t, player1);
            checkPoints();
            System.out.println("Your points: " +player1.points);
            System.out.println("Computers points: "+ player2.points);
            win();
            Scanner scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("========================");
            System.out.println("Play again, yes(y) no(n)");
            String sc= scanner.nextLine();
            if(!sc.equals("y")){
                clearScreen();
                System.out.println("\'y\' was not typed, GoodBye");
            }
            if(sc.equals("y")){
                clearScreen();
                game();  
            }
          
        }
        if(player1.fold){
            Scanner scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("========================");
            System.out.println("Play again, yes(y) no(n)");
            String sc= scanner.nextLine();
            if(!sc.equals("y")){
                clearScreen();
                System.out.println("\'y\' was not typed, GoodBye");
            }
            if(sc.equals("y")){
                clearScreen();
                game();  
            }
        }
    }
    
    public static void checkPoints(){
        pt.setup(t, player2);
        pc.setup(t, player1);
        //flush
        if(pc.dia>=5 || pc.heart>=5 || pc.club>=5 || pc.spade>=5){
            player1.points+=4;
            if(pc.straight>0){
                player1.points+=4;
            }
        }else{
            
            //full house
            if(pc.threeOf>=1 && pc.twoOf>=1){
                player1.points+=6;
            }else{
                //four of
                if(pc.fourOf>=1){
                    player1.points+=7;
                }
                //three of
                if(pc.threeOf>=1){
                    player1.points+=3;
                }
                if(pc.twoOf>=2){
                    player1.points+=2;
                }
                if(pc.twoOf==1){
                    player1.points+=1;
                }
            }
        }
             if(pt.dia>=5 || pt.heart>=5 || pt.club>=5 || pt.spade>=5){
            player2.points+=4;
            if(pt.straight>0){
                player2.points+=4;
            }
        }else{
            //full house
            if(pt.threeOf>=1 && pt.twoOf>=1){
                player2.points+=6;
            }else{
                //four of
                if(pt.fourOf>=1){
                    player2.points+=7;
                }
                //three of
                if(pt.threeOf>=1){
                    player2.points+=3;
                }
                if(pt.twoOf>=2){
                    player2.points+=2;
                }
                if(pt.twoOf==1){
                    player2.points+=1;
                }
            }
        }
        
    }
    
    public static void win(){
        if(player1.points>player2.points){
            System.out.println("you win");
        }
        if(player2.points>player1.points){
            System.out.println("computer wins");
        }
    }
    
    public static void bet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much are you raising");
        int sc= scanner.nextInt();
        betNum+=sc;
        player1.betting+=sc;
        System.out.println("your bet is: "+ betNum);
    }
    
    public static void compBet(){
        checkPoints();
        pt.setup(t,player2);
        if(betNum-player2.betting>=80 && player2.points<3){
            player2.fold=true;
        }else{
            if(betNum-player2.betting>=50 && player2.points<2){
                player2.fold=true;
            }else{
                if(betNum-player2.betting>=30 && player2.points<1){
                }
            }
        }
        
        
        
        
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
    }  
    
    public static void game(){
        c =new Deck();
        player1= new Hand();
        player2= new Hand();
        t= new Table();
        pc=new PointChecker();
        pt=new PointChecker();
        program();
    }
    
    
    
  
}
