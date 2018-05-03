package defaultstaticinterfacemethods.model;

public class MultiAlarmCar implements Vehicle, Alarm {
	
	//if we comment default methods then we give bellow compilation error
	//Duplicate default methods named turnAlarmOff with the parameters () and () are inherited from the types Alarm and Vehicle
	
	/* Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Duplicate default methods named turnAlarmOn with the parameters () and () are inherited from the types Alarm and Vehicle
	Duplicate default methods named turnAlarmOff with the parameters () and () are inherited from the types Alarm and Vehicle

	at defaultstaticinterfacemethods.model.MultiAlarmCar.<init>(MultiAlarmCar.java:3)
	at defaultstaticinterfacemethods.application.Application.main(Application.java:21)*/

	private final String brand;

	public MultiAlarmCar(String brand) {
		this.brand = brand;
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public String speedUp() {
		return "The motorbike is speeding up.";
	}

	@Override
	public String slowDown() {
		return "The mootorbike is slowing down.";
	}

	@Override
	public String turnAlarmOn() {
		return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
	}

	@Override
	public String turnAlarmOff() {
		return Vehicle.super.turnAlarmOff() + " " + Alarm.super.turnAlarmOff();
	}

}
