package com.jackdurrant.inheritance;

public class Main {

	public static void main(String[] args) {
		/**
		 * Suppose that we have [class Car] with various instance methods and field variables, including a constructor
		 * which accepts a parameter, [String make], and assigns that value to its private field variable[String make].
		 * Then, suppose that we have [class DeLorean extends Car], which inherits [class Car]'s functionality,
		 * but has a constructor that accepts no classes and provides no additional functionality.
		 *
		 * Below, I have created a new instance of each of the classes discussed above - [Car c] and [DeLorean d]. I
		 * initialised [Car c], passing "Mercedes" to its constructor.
		 */
		Car c = new Car("Mercedes");
		DeLorean d = new DeLorean();
		/**
		 * [class Car] includes an instance method, [public String isClean()], which we can use to determine whether a car
		 * is clean. I have called this method on [Car c] and [DeLorean d]. In the same way that every real life DeLorean
		 * is a car, every instance of [class DeLorean] is also a specialised instance of [class Car] and has access to
		 * the functionality from both classes.
		 */
		System.out.println(c.isClean()); // Filthy as a ditch
		System.out.println(d.isClean()); // Filthy as a ditch
		/**
		 * As you can see, these cars aren't very clean at all. Fortunately, I have created [class CarWash] to sort that
		 * out. It has a static method, [public static void clean(Car c)], which accepts a Car object, completes a process
		 * on it and calls its [isClean()] method again, printing the result to the console.
		 *
		 * Because [CarWash.clean(Car c)] is set up to accept a [Car] object, when it receives a [DeLorean] object, it has
		 * to _upcast_ that object to a [Car] object. This may sound like some extremely technical jargon, but it's not as
		 * complicated as it seems. To upcast an instance of a sub-class is to store it as an instance of its parent's
		 * class. To put it more simply, when [DeLorean d] is passed into [CarWash.clean(Car c)], that method stores our
		 * instance of [class DeLorean] as an instance of [class Car].
		 */
		CarWash.clean(c); // Clean as a whistle
		CarWash.clean(d); // Clean as a whistle
		/**
		 * While these cars weren't initially much to look at before we had them cleaned, they are undeniably nice cars.
		 * We've got a classy Mercedes and an awesome retro DeLorean here, and they deserve compliments. For this reason,
		 * I have allowed car wash employees to compliment the cars of their customers by giving [class CarWash] another
		 * static method, [public static void compliment(Car c)]. This method accepts a [Car] object, checks its make
		 * using its [public String getMake()] method and composes a compliment, which is printed to the console.
		 *
		 * [class Car]'s [public String getMake()] instance method returns its object's [String make] field variable,
		 * initialised in the constructor method. However, our instance of [class DeLorean] was initialised without an
		 * initialised [String make] field variable. Because of this, [class Car]'s [public String getMake()] instance
		 * method can't return the make of our [DeLorean] method. Fortunately, [class DeLorean] has its own [public String
		 * getMake()] instance method which simply returns "DeLorean". This overrides [class Car]'s instance method of the
		 * same name.
		 *
		 * As I mentioned earlier, when [CarWash.compliment(Car c)] is called with our [DeLorean] passed in as the
		 * parameter, the method stores it as an instance of [class Car]. Because of this, you might think that when
		 * [CarWash.compliment(Car c)] calls our passed in [DeLorean]'s methods, it will favour [class Car]'s instance
		 * methods over [class DeLorean]'s. However, that is not the case. Our [DeLorean] is passed in with its own set of
		 * instance methods and field variables, taken from [class DeLorean].
		 */
		CarWash.compliment(c);
		CarWash.compliment(d);
	}
}
