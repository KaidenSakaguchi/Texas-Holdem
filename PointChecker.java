import java.util.Arrays;

public class PointChecker {
    Card [] cards = new Card[7];
    int total=0;
    int match=0;
    int points=0;
    int spade=0;
    int dia=0;
    int heart=0;
    int club=0;
    int twoOf=0;
    int threeOf=0;
    int fourOf=0;
    int straight=0;
    int [] sorts=new int[7];
    int hrow=0;
    int row=0;
    
    
    public PointChecker(){
        
        
        
        
        
    }
    
    public void setup(Table t, Hand h){
        total=t.total+h.total;
        for(int i=0; i<t.total+2; i++){
            if(i<2){
                cards[i]=h.hand[i];
            }else{
                cards[i]=t.table[i-2];
                
                
            }
            
        }
        for(int i=0; i<t.total+h.total; i++){
            //System.out.println("PC: "+cards[i]);
            
        }
        
        //System.out.println("total cards in pointchecker is: " + total);
        
        //checking starts here
        check();
        //checking ends here
        //System.out.println("spades: " +spade + ", dia: "+ dia+ ", heart: "+ heart+", clubs: "+ club );
        //System.out.println("twoOf: "+ twoOf+ ", threeOf: "+ threeOf + ", fourOf: " + fourOf+ ", straight: "+straight);
        
    }
    
    public void check(){
    //checks for every suit and checks how many there are   
       for(int i=0; i<total; i++){
            //  23456789TJQKA
            //  CDHS
            
            if(cards[i].suit=='S'){
                spade+=1;
                    
            }
            if(cards[i].suit=='D'){
                dia+=1;
                    
            }
            if(cards[i].suit=='H'){
                heart+=1;
                    
            }
            if(cards[i].suit=='C'){
                club+=1;
                    
            }
        }
        int match=0;
        //checks for how many matches of cards there are
        for(int k=2; k<16; k++){
            if(match==4){
              
                fourOf++;
            }
            if(match==3){
                
                threeOf++;
                
            }
            if(match==2){//doesnt consider aces or kings a pair
                twoOf++;

            }
            
            match=0;
            for(int i=0; i<total; i++){
                if(k==cards[i].cardValue){
                    match+=1;
                    
                }
            }
        }
        
        
    //     //checks for if there is a straight
        
        sort();
        for(int i=0; i< sorts.length-1; i++){
            //System.out.println(sorts[i+1]-sorts[i]);
            
            
            if(sorts[i+1]-sorts[i]==1){
                row++;
                //System.out.println(row);
                if(row>hrow){
                    //System.out.println(hrow);
                    hrow=row;
                }
            }
            
            // if(sorts[i+1]-sorts[i]!= 0 || sorts[i+1]-sorts[i]!= 1){
            //     row=0;
            // }
            if(row>=5){
                straight+=1;
            }
        }    
    }   
    
    
    
    
    
    public void sort(){
        
        for(int i=0; i<7; i++){
            sorts[i]=cards[i].cardValue;
        }
        Arrays.sort(sorts);
        
        //print
        // for(int i=0; i< 7; i++){
        //     System.out.println(sorts[i]);
        // }
       
        
    }
    
    
    
}
