/**
 * Complete the code
 * 
 * 
 */
public class CatTest {
  public static void main(String[] args) {
    // Create array of cats
	Cat[] cats=new Cat[6];
    // Initialize array of cats using the constructor
    /*
	Name		Color		Owner
	Azrael		Brown		Gargamel
	Garfield	Orange		Jon Arbuckle
	Tom 		Grey and white  Unknown
	Puss in Boots   Golden tabby	Marquis of Carabas		
	Doraemon	Blue		Nobita Nobi
	Sylvester	Black and white	Granny
    */
	cats[0]=new Cat("Azrael","Brown","Gargamel");
	cats[1]=new Cat("Garfield","Orange","Jon Arbunckle");
	cats[2]=new Cat("Tom","Grey and white","unknown");
	cats[3]=new Cat("Puss in Boots","Golden tabby","Marquis of Carabas");
	cats[4]=new Cat("Doraemon","Blue","Nobita Nobi");
	cats[5]=new Cat("Sylvester","Black and white","Granny");
    //  Show Array of cats
    System.out.println();
	System.out.println("Show Array of cats: ");
	showCats(cats);
    // Desires for each cat
    /*
	Name		Desire	
	Azrael		Capture smurfs
	Garfield	Eat lasagna
	Tom 		Capture Jerry
	Puss in Boots   Live adventures		
	Doraemon	Eat dorayakis
	Sylvester	Eat Tweety
    */
    String[] desires = {"Capture smurfs", "Eat lasagna", 
                        "Capture Jerry", "Live adventures", 
                        "Eat dorayakis", "Eat Tweety"};
    
    // Initialize desires for each cat using a While loop
	int i=0;
	while(i<cats.length){
		cats[i].setDesire(desires[i]);
		i++;
	}
	System.out.println();
	System.out.println("List of Desires: ");

    // Show List of Desires using a DO While loop
	int j=0;
	do{
		System.out.println(cats[j].getName()+" likes \""+cats[j].getDesire()+"\"");
		j++;
  	}while(j<cats.length);
  }

  // Add a static method showCats that uses a For loop
 	public static void showCats(Cat[] cats){	
		for(int i=0;i<cats.length;i++){
			System.out.println("Cats #"+(i+1)+": "+cats[i]);
		}
	}
}

