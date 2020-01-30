/**
 * Remember: You are NOT allowed to modify this class
 *           except for adding a toString method and complete startsWithVowel code
 */

public class Fruit {
  private String name;
  private String color;
  
  public Fruit(String name, String color) {
    this.name = name;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  private boolean startsWithVowel() {
     // Complete the code
	 String vowels = "aeiouAEIOU";
	boolean starts=false;
    
    	for(int i = 0; i < vowels.length(); i++) {
        	if(name.startsWith(vowels.substring(i,i+1)))
            	starts=true;
    	}
	return starts;
  }
  public String toString(){
	 if(startsWithVowel()){
		return "An "+getName()+" with \""+getColor()+"\" color";
	}
	 else {
		return "A "+getName()+" with \""+getColor()+"\" color";
	}
  }


}

