public class Machine
{

public static final int SELECTION = 6;

public static final int QUANITY = 3;

public double money = 0.0;

public double cost;



Beverage[] beverages = new Beverage[SELECTION];


public Machine(double cost)
{
	this.cost = cost;
}

public void lbeverages (int choice, Beverage option)
{
	beverages[choice] = option;
}

public boolean getMoney(int choice)
{
	if(money < cost)
	return false;
	if(beverages[choice].quanity <= 0)
	return false;
	beverages[choice].quanity--;
	money = money - cost;
	return true;

}

public double refund()
{
	double refund = money;
	money = 0.0;
	return refund;
}
public String getName(int choice)
{
	return beverages[choice].name;
}

}
