public class Rectangle {
	//Fields - State
	private int length;
	private int width;

	//no-arg constructor
	public Rectangle(){
		length=1;
		width=1;

	}

	//parameterized constructor
	public Rectangle(int length, int width){
		this.length=length;
		this.width=width;
	}

	//Methods - Behaviour

	//instance methods
	public int area(){
		return length*width;
	}

	public int perimeter(){
		return 2*(length+width);
	}

	public boolean isSquare(){
		return length==width;
	}

	//getters - acessors
	public int getLength(){
		return length;
	}

	public void setLength(int length){
		if(length<20 && length <0){
			this.length=length;
		}
		else{
			length=1;
		}	
	}

	public int getWidth(){
		return width;
	}

	public void setWidth(int width){
		if(width<20 && width <0){
			this.width=width;
		}
		else{
			width=1;
		}	
	}

	//toString method
	public String toString() {
		return "Rectangle (width = " + width + ", length = " + length + ")";
	}

}