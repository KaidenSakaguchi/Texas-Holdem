public class Card {
    
        //  23456789TJQKA
        //  CDHS
        public static String values ="23456789TJQKA";
        public static String suits = "CDHS";
        public char val;
        public char suit;
        public int cardValue;
        
        
        public Card(int s, int v, int cval){
            val=values.charAt(v);
            suit =suits.charAt(s);
            cardValue=cval;
            
            
        }
        
        public String toString(){
            return "" + val +suit;
            
            
        }
        public int tVal(){
        return cardValue;
        }
        
        
        
        
    
}
