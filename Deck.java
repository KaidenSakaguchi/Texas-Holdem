public class Deck {
    //shuffle, deal, return, remove
    
    Card[] newCards = new Card[52];
    Card[] deck=new Card[52];
    public Deck(){
        
        int count=0;
        int v=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<13; j++){
                
                    v=j+2;
                
                deck[count] = new Card(i,j,v);
                count++;
            }
        }
        
        
    }
    
    
    
    
    public void rDeck(){
        for(int i=0; i< deck.length; i++){
            System.out.println(deck[i].toString() + "V: "+ deck[i].tVal());
            
            
        }
        System.out.println("");
        
        
        
        
    }
    
    public void shuffle(){
       for(int i = 0; i < 52; i++){
           int c = (int)(Math.random()*52);
           Card a = deck[c];
           deck[c] = deck[i];
           deck[i] = a;
       }  
        
    }
    
    public void remove(){
        
        Card[] newCards = new Card[deck.length-1];
        for(int i=0; i<deck.length-1; i++){
            newCards[i]=deck[i+1];
        }
        deck=newCards;
    }
    
    
    
        

    
}
