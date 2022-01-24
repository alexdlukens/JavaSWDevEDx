package square;

public class Squarelotron {
    public int[][] squarelotron;
    public int size;

    public Squarelotron(int n){
        this.squarelotron = new int[n][n];
        this.size = n;
        for(int i = 0; i<this.size; i++){
            for(int j = 0; j<this.size; j++){
                this.squarelotron[i][j] = this.size*i + j + 1;
//                System.out.println("squarelotron[" + i + "][" + j + "] = " + this.squarelotron[i][j]);
            }
        }
    }

  //should reverse the row order and return new squarelotron
    public Squarelotron upsideDownFlip(int ring){
        if(ring > this.size-2) return this;
        Squarelotron tmp = new Squarelotron(this.size);
        //iterate through all rows
        for(int i=0; i< tmp.size; i++){
            //iterate through each element in row
            for(int j = 0; j<tmp.size; j++){
                //if whole row is part of ring
                if(i == ring-1 | i == tmp.size - ring){
                    if(j >=ring-1 && j<=tmp.size-ring) {
                    	tmp.squarelotron[i][j]=this.squarelotron[tmp.size-1-i][j];
                    }
                    
                    
                }
                //if whole row isn't part of ring, only flip elements part of ring
                else if(i > ring-1 && i< tmp.size-ring) {
                	if(j == ring-1 || j == tmp.size-ring){
                        tmp.squarelotron[i][j]=this.squarelotron[tmp.size-1-i][j];
                    }    
                }
                	            
            }
        }
        // printSquarelotron(tmp);
        return tmp;
    }
    
    public void printSquarelotron(Squarelotron tmp) {
    	for(int i = 0; i<tmp.size; i++) {
    		for(int j = 0; j<tmp.size; j++) {
    			System.out.print(" " + tmp.squarelotron[i][j] + " ");
    		}
    		System.out.println();
    	}
    }

    public Squarelotron mainDiagonalFlip(int ring){
        Squarelotron tmp = new Squarelotron(this.size);
        for(int i = 0; i<tmp.size; i++){
            for(int j = 0; j<tmp.size; j++){
                //if on ring row AND j within correct range for specific ring
                if((i==ring-1 | i == tmp.size-ring) & (i != j) & (j>=ring-1 & j <= tmp.size-ring)){
                    //flip i with j
                	System.out.println("here, i=" +i+ ", j=" +j);
                	
                	//flip current location AND mirror location
                    tmp.squarelotron[i][j]=this.squarelotron[j][i];
                    tmp.squarelotron[j][i]=this.squarelotron[i][j];
                }
                
                //if not on ring row, if j index is part of ring
//                else if((j==ring-1 | j == tmp.size-ring) & (j != i)) {
//                	System.out.println("here2, i=" +i+ ", j=" +j);
//                	tmp.squarelotron[i][j]=this.squarelotron[j][i];
//                    tmp.squarelotron[j][i]=this.squarelotron[i][j];
//                }
            }
        }
        printSquarelotron(tmp);
        return tmp;
    }
    
    public void rotateOnce() {
    	Squarelotron tmp = new Squarelotron(this.size);
    	
    	for(int i=0; i<this.size; i++) {
    		for(int j=0; j<this.size; j++) {
    			tmp.squarelotron[i][j] = this.squarelotron[this.size-1-j][i];
    		}
    	}
    	
    	this.squarelotron = tmp.squarelotron;
    }
    
    public void rotateRight(int numberOfTurns){
    	for(int i=0; i<numberOfTurns; i++) {
    		this.rotateOnce();
    	}
    }
    

    public static void main(String [] args){
        
    }
}
