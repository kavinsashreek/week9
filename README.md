# Week 9 — Abstraction, Abstract Classes and Interfaces

Java solutions for the Category C practice sheet and coding assignment.

## Coding Assignment

1. [Movie Ticket Counter](Assignment/M1/MovieTicketCounter.java) — abstract ticket type and shared convenience fee.
2. [Parcel Shipping Desk](Assignment/M2/ParcelShippingDesk.java) — abstract parcel class and `Insurable` interface.
3. [College Fee Counter](Assignment/M3/CollegeFeeCounter.java) — abstract student type and `BusUser` interface.
4. [City Cab Fare Meter](Assignment/M4/CityCabFareMeter.java) — shared minimum fare and `NightService` interface.
5. [Home Appliance Energy Report](Assignment/M5/HomeApplianceEnergyReport.java) — abstract appliance type and saver-mode capability.

## Practice Problems

1. [Garden Plot Area Report](Practice/M1/GardenPlotAreaReport.java)
2. [Weekly Staff Pay](Practice/M2/WeeklyStaffPay.java)
3. [Library Late Fine Counter](Practice/M3/LibraryLateFineCounter.java)
4. [Electricity Connection Billing](Practice/M4/ElectricityConnectionBilling.java)
5. [Travel Booking with a Common Fee](Practice/M5/TravelBookingCommonFee.java)

## Compile and run

Example from the repository root:

```bash
javac Practice/M1/GardenPlotAreaReport.java
java -cp Practice/M1 GardenPlotAreaReport
```

Each program reads from standard input and prints monetary values to two decimal places.

## Part B — Quiz Answers

1. **C** — Abstraction hides implementation details and shows what an object does.
2. **C** — An abstract class cannot be instantiated directly.
3. **B** — A concrete subclass must implement inherited abstract methods or itself be abstract.
4. **C** — An abstract method cannot be private.
5. **C** — Interface fields are implicitly `public static final`.
6. **C** — A class can implement any number of interfaces.
7. **D** — Implemented interface methods must be public.
8. **C** — Interfaces avoid multiple inheritance of class instance state; conflicting default methods still require resolution.
9. **D** — A class must override conflicting inherited default methods.
10. **B** — An abstract class constructor runs when a subclass object is created.

## Part C — Concept Answers

### 1. Explain abstraction with a real-life example.
A food delivery app shows restaurants, menus, prices, and order status. It hides internal details such as how the order is routed to a restaurant, how a delivery partner is assigned, and how the database is updated. The user can use the service without knowing its internal implementation.

### 2. Abstraction vs encapsulation
Abstraction exposes essential operations while hiding implementation complexity. Encapsulation groups data with the methods that operate on it and controls direct access to internal state. In one class, public methods can provide simple operations while private fields and validation protect the object's data.

### 3. Why can an abstract class have a constructor?
An abstract class cannot be instantiated directly, but its constructor can initialize common fields used by subclasses. It runs as part of creating a concrete subclass object, before the subclass constructor body completes.

### 4. Why cannot an abstract method be private, static, or final?
A private method is not accessible to subclasses to implement. A static method belongs to the class rather than being overridden as an instance method. A final method cannot be overridden. Since an abstract method requires a concrete subclass implementation, these modifiers conflict with that requirement.

### 5. Explain the diamond problem.
The diamond problem occurs when a class inherits the same method or state through two parent-class paths, creating ambiguity about which implementation or state to use. Java permits a class to extend only one class, avoiding multiple inheritance of class state. A class may implement multiple interfaces, but if interfaces provide conflicting default methods, the class must override the method and resolve the conflict explicitly.
