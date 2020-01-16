/**
 * Remember: You are NOT allowed to modify this class
 *           except for adding a toString method and 
 *           adding an accessor and mutator for Cat desire
 */

public class Cat {
  private String name;
  private String color;
  private String owner;
  private String desire;
  
  public Cat(String name, String color, String owner) {
    this.name = name;
    this.color = color;
    this.owner = owner;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
 
  // Remember: You are not allowed to modify this accessor 
  private String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
  
  public String getDesire(){
	return desire;
  }

  public void setDesire(String desire){
	this.desire=desire;
  }

  public String toString(){
	return name+" is a "+color+" cat owned by "+owner;
  }

}

