🚗 Car Rental Management System

A fully object-oriented Java application that simulates a car rental company’s operations — including user management, vehicle management, rental tracking, and payment handling.

This project was developed for an Object-Oriented Programming (OOP) course to demonstrate inheritance, polymorphism, encapsulation, and exception handling in a real-world system.

🧠 Key Concepts Demonstrated

Encapsulation – through private attributes and public getters/setters.

Inheritance – Customer, Admin, and Staff all extend from User.

Polymorphism – collections of User and Vehicle objects can store subclasses.

Abstraction – interfaces like Payable and abstract classes like User and Vehicle.

Exception Handling – robust handling of invalid rentals, unavailable cars, and payments.

⚙️ Features
👥 User Management

Supports multiple user roles: Admin, Customer, CorporateCustomer, Staff.

Centralized authentication and user registry.

🚘 Vehicle Management

Add, remove, and search cars.

Support for multiple types of vehicles (Sedan, SUV, ElectricCar, Truck).

📅 Rental Management

Customers can rent available cars for specific dates.

Tracks active and past rentals.

Prevents double-booking or invalid rental periods.

💳 Payment System

Process payments with validation and exceptions.

Automatically records payment transactions and associates them with rentals.

🧾 Exception Handling

Handles errors gracefully with custom exceptions:

CarNotAvailableException

InvalidRentalPeriodException

InvalidPaymentException

UserNotFoundException

🚀 How to Run

Clone the repository

git clone https://github.com/your-username/car-rental-management-system.git
cd car-rental-management-system


Compile the code

javac -d bin src/**/*.java


Run the main program

java -cp bin Main


(Optional) Use your IDE (IntelliJ, Eclipse, or VS Code) to run and test.
