public class NestedLoop{
	public static void main(String[] args) {
		int size=Integer.parseInt(args[0]);
		if(size<1||size>10){
			System.out.println("Sorry! Valid size from 1 to 10");
		}
		else{
			for(int i=1;i<=size;i++){
				for(int j=1;j<=size;j++){
					System.out.print((j*i)+"	");
				}
				System.out.println();
			}
		}
	}
}