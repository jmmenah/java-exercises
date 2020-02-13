import java.util.ArrayList;
import java.util.List;

public class DemoPizzas{
	public static void main(String[] args) {

		List<Pizza> pizzas = new ArrayList<>();

		Pizza p1= new Pizza(5,"ham and cheese");
		Pizza p2= new Pizza(7,"sausagges and cheese");
		Pizza dp1= new DeliveryPizza(16,"ham, sausagges, bacon and cheese","Calle Tomillar n30");
		Pizza dp2= new DeliveryPizza(10,"ham, sausagges and cheese","Calle Fuente Nueva n25");

		pizzas.add(p1);
		pizzas.add(p2);
		pizzas.add(dp1);
		pizzas.add(dp2);

		for(Pizza pizza : pizzas){
			System.out.println(pizza);
		}
	}
}