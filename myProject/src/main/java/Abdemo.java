// Abstract Class and method

public class Abdemo
{
	
	public static void main(String args[])
	
	{
		MaheshPhone obj = new SureshPhone(); //Cannot instantiate abstract classes...
		obj.call();
		obj.dance();
		obj.move();
		obj.sing();
				
	}

}

abstract class MaheshPhone
{
	//Abstract class can't be instantiated i.e., object can't be created.
	public void call()
	{
		System.out.println("Calling...");
	}
	//Mahesh wants his mobile to dance but he's not able to define it's feature
	public abstract void dance(); //declared but not defined... Abstract methods
	public abstract void move();
	public abstract void sing();
}

abstract class RameshPhone extends MaheshPhone
/* Ramesh wants to use the features of MaheshPhone instead of creating it new...
If we are extending an abstract class, we have to define all the abstract methods here..
As Move and sing methods are not defined again in this class, this class can't be instantiated. i.e., Object can't be created with this method.
*/ 
{	public void dance()
	{
	System.out.println("Dancing...");
	}
}	
class SureshPhone extends RameshPhone //Concrete class
	{
	public void move()
	{
		System.out.println("Moving...");	
	}
	public void sing()
	{
		System.out.println("Singing...");
	}	
	
	}
