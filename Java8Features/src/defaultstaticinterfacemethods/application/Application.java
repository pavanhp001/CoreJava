package defaultstaticinterfacemethods.application;

import defaultstaticinterfacemethods.model.Car;
import defaultstaticinterfacemethods.model.MultiAlarmCar;
import defaultstaticinterfacemethods.model.Vehicle;

public class Application {

	public static void main(String[] args) {
		
		Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
        System.out.println(Vehicle.getHorsePower(2500, 480));
        
        System.out.println("============================");
        
        MultiAlarmCar mCar = new MultiAlarmCar("balano");
        
        System.out.println(mCar.getBrand()); //balano
        System.out.println(mCar.speedUp()); //The motorbike is speeding up.
        System.out.println(mCar.slowDown()); //The mootorbike is slowing down.
        System.out.println(mCar.turnAlarmOn());//Turning the vehice alarm on. Turning the alarm on. // default method 
        System.out.println(mCar.turnAlarmOff());//Turning the vehicle alarm off. Turning the alarm off. //default method
        System.out.println(Vehicle.getHorsePower(2500, 480)); //228
        
        //if we comment MultiAlarmCar class defoult methods then we get bellow compilation error
        
       /* Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
        	Duplicate default methods named turnAlarmOn with the parameters () and () are inherited from the types Alarm and Vehicle
        	Duplicate default methods named turnAlarmOff with the parameters () and () are inherited from the types Alarm and Vehicle

        	at defaultstaticinterfacemethods.model.MultiAlarmCar.<init>(MultiAlarmCar.java:3)
        	at defaultstaticinterfacemethods.application.Application.main(Application.java:21)*/
        
        
        //System.out.println(Vehicle.turnAlarmOn()); //Cannot make a static reference to the non-static method turnAlarmOn() from the type Vehicle

	}

}

/*
If we dont create MultiAlarmCar class object and comment the if dont override the default method then there is no error we get.
*
*/
