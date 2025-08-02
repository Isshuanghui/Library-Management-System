# 📚Library-Management-System
A Java-based simple library management system that supports two roles (admin and customer) with functionalities for book management, purchases, and handling of complimentary items.
# 🔖Project Overview
This system adopts object-oriented design, implementing functions such as book CRUD operations, inventory management, purchases, and complimentary item management through design patterns like Singleton and Interface Segregation. It provides a console-based interactive interface with simple and intuitive operations.
# Core Features

## Admin Functions
    Stock books (increase inventory of specified books)
    Remove books from stock (decrease inventory of specified books)
    Add new books to the system
    View all book information
    
## Customer Functions
    View all book information
    
    Purchase books (supports quantity selection with automatic total calculation)
    
    Check available complimentary items (CD, Bag, Pen)
    
    Purchase complimentary items (requires prior book purchase)
# 🛠️Technical Architecture
    Design Patterns: Singleton Pattern (BookMgr), Factory Pattern (EXFactory), Interface Segregation Principle
    
    Data Storage: In-memory HashMap for book information (with book ID as key)
    
    Interaction: Console command-line interface
    
# Class Structure
    Core Interfaces: IAdmin (admin permissions), ICustomer (customer permissions)
    
    Implementation Classes: AdminImpl (admin function implementation), CustomerImpl (customer function implementation)
    
    Management Class: BookMgr (core book management class, singleton)
    
    Entity Classes: Book (book information), EX (abstract class for complimentary items) and its subclasses CD/Bag/Pen
    
    Utility Class: EXFactory (factory for creating complimentary items)
    
    Entry Class: MainTest (system startup and interactive interface)
    
# Quick Start
1. Clone the repository to your local machine
   
2. Compile and run
 
    Navigate to the project directory and compile all Java files
   
    Run the MainTest class to start the system
   
3. Operation Flow
   
    Enter your name and select a role (1.Admin 2.Customer)
   
    Perform operations according to menu prompts




