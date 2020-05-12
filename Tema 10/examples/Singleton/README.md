# Singleton Design Pattern

![Singleton UML class diagram](resources/Singleton_UML_class_diagram.svg)

## References: 
- [Singleton pattern (Wikipedia)](https://en.wikipedia.org/wiki/Singleton_pattern)
- [Singleton design pattern in Java (javaTpoint)](https://www.javatpoint.com/singleton-design-pattern-in-java)
- [Java Singleton Pattern Explained (HowToDoInJava)](https://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/)
- [Java Singleton Design Pattern Best Practices with Examples (JournalDev)](https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#lazy-initialization)
- [Design Patterns in Java: Singleton Pattern (dragonprogrammer)](https://dragonprogrammer.com/design-patterns-java-singleton-pattern/)
- [Singleton Class in Java (GeeksforGeeks)](https://www.geeksforgeeks.org/singleton-class-java/)
- [When is a Singleton not a Singleton? (Oracle)](https://www.oracle.com/technetwork/articles/java/singleton-1577166.html)
- [Java.lang.Runtime.addShutdownHook(Thread hook) Method](https://www.tutorialspoint.com/java/lang/runtime_addshutdownhook.htm)

## Definition

The [**singleton design pattern**](https://en.wikipedia.org/wiki/Singleton_pattern) is one of the twenty-three well-known ["Gang of Four" design patterns](https://en.wikipedia.org/wiki/Design_Patterns) that describe how to solve recurring design problems to design flexible and reusable object-oriented software, that is, objects that are easier to implement, change, test, and reuse. 

[Singleton Pattern](https://www.javatpoint.com/singleton-design-pattern-in-java) says that just **"define a class that has only one instance and provides a global point of access to it"**.

In other words, a class must ensure that only single instance should be created and single object can be used by all other classes.

To [implement a Singleton pattern](https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#lazy-initialization), we have different approaches but all of them have the following common concepts.

- Private constructor to restrict instantiation of the class from other classes.
- Private static variable of the same class that is the only instance of the class.
- Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.

## [Quick-and-Dirty Implementation with Lazy Instantiation](https://dragonprogrammer.com/design-patterns-java-singleton-pattern/#1-quick-and-dirty-implementation-with-lazy-instantiation)

```
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// Call the singleton:
Singleton theSingleton = Singleton.getInstance();
```

First of all, observe that the constructor is marked as private. This means that from the outside, you can’t construct objects of this class.

Secondly, the singleton instantiates itself via the getInstance() static method. As this is a static method, it can be accessed from anywhere in your code.

Inside this method, we check if an instance of the singleton already exists. If that’s not the case, then we create it.

Subsequent calls to the getInstance() method return the same, previously created Singleton instance.

Furthermore, I’d like to point out that this is an example of lazy instantiation, as we’re delaying creating the object until we need it, i.e. when the getInstance() method is called the first time.

### Compile & Run the TestSingleton example:

- [TestSingleton.java](src/TestSingleton.java)
- [Singleton.java](src/Singleton.java)

## SQLite Connection Using Singleton Design Pattern

- [SQLiteConnection.java](src/SQLiteConnection.java)
- [CreateFruitsSQLite.java](src/CreateFruitsSQLite.java)

## SQLite Connection Using Singleton Design Pattern with ShutdownHook

- [RuntimeDemo.java](src/RuntimeDemo.java)
- [SQLiteConnectionShutdown.java](src/SQLiteConnectionShutdown.java)
- [CreateFruitsSQLite2.java](src/CreateFruitsSQLite2.java)


## [A Singleton Java class for MySQL DB connection](http://rdeshapriya.com/a-singleton-java-class-for-mysql-db-connection/)

- [MysqlConnect.java](src/MysqlConnect.java)
- [CreateFruitsMySQL.java](src/CreateFruitsMySQL.java)

## [Best Way to Implement the Singleton Pattern in Java](https://dragonprogrammer.com/design-patterns-java-singleton-pattern/#best-way)

I hate to break it to you, but **all of the methods aren’t bulletproof**.


