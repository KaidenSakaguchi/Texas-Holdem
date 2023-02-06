public class Table {
    Card [] table = new Card[5];
    int total=0;
    
    
    public void rTable(){
        System.out.println("The Table: ");
        for(int i=0; i<total; i++){
            System.out.print(table[i].toString()+" ");
            
            
        }
        System.out.println("");
        System.out.println("=================");
        
        
        
    }
    
    //deals the initial 3 cards onto the table
    public void flop(Deck c){
        for(int i=0; i<3; i++){
            total+=1;
            table[total-1]=c.deck[0];
            c.remove();
        }
        
    }
    // deals one card to table
    public void turn(Deck c){
        total+=1;
        table[total-1]=c.deck[0];
        c.remove();
        
        
    }
    // deals one card to table but burns first card
    public void river(Deck c){
        
        total+=1;
        c.remove();
        table[total-1]=c.deck[0];
        c.remove();
        
        
    }
}
