Customer Data XML Processor using Java
A command-line Java application that parses, displays, and modifies customer data from an XML file. This project demonstrates core Java skills in file I/O, XML processing with the DOM API, and object-oriented design, showcasing a practical approach to handling structured data.

Table of Contents
About The Project

Key Features

Built With

Getting Started

Prerequisites

Installation & Usage

Contact

About The Project
This application uses a menu-driven interface to interact with a customers.xml file. Users can view a formatted list of all customers or add new contact fields to each record. The updated data is saved to a new XML file, preserving the original.

This project highlights proficiency in:

XML Parsing: Reading and interpreting structured XML data.

DOM Manipulation: Modifying the XML tree structure in memory.

File Handling: Reading from and writing to the file system.

Core Java Fundamentals: Building a clean and functional command-line application.

Key Features
✅ Parse XML: Parses customers.xml using the Java API for XML Processing (JAXP).

✅ Display Data: Shows a clean, formatted customer list on the console.

✅ Modify XML: Adds new elements (phone, contact name, email) to each customer record.

✅ Write to File: Saves modified data to customer_modified.xml, preserving the original file.

✅ Interactive CLI: A simple command-line menu guides the user.

Built With
This project relies entirely on the core Java SE platform.

Java - (Java 11+ recommended)

Getting Started
Prerequisites
Ensure you have a recent version of the Java Development Kit (JDK) installed.

JDK (Oracle or OpenJDK)

Create an input file:
Create a customers.xml file in the root directory with the following structure:

<Customers>
    <Customer>
        <id>1</id>
        <name>John Doe</name>
        <address>123 Main St, Anytown, USA</address>
    </Customer>
</Customers>

Compile the source files:

javac *.java

Run the application:

java GetUserInput

Follow the on-screen prompts. If you modify the data, a customer_modified.xml file will be generated.
