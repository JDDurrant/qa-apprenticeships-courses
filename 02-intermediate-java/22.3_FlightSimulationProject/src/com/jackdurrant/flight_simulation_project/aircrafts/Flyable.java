package com.jackdurrant.flight_simulation_project.aircrafts;

import com.jackdurrant.flight_simulation_project.airport.DockingPosition;

public interface Flyable {

	boolean getFuel(int gallons);
	boolean dockOut();
	boolean accelerate(int mph);
	boolean takeOff();
	boolean ascend(int feet);
	boolean fly(int miles);
	boolean descend(int feet);
	boolean decelerate(int mph);
	boolean land();
	boolean docken(DockingPosition position);
}
