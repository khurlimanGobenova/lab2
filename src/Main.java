// Gobenova Xurliman 230044
// Wednesday 9:00
// Main Function

//Enums
enum Season{
    SPRING, SUMMER, AUTUMN,WINTER;
}
//Inheritance
class Vehicle {
    public void startEngine() {
        System.out.println("Engine has started.");
    }
}

class Car extends Vehicle {
    public void drive() {
        System.out.println("The car is moving.");
    }
}
//Interfaces
interface IStringable {
    String toString();
}

interface Printable {
    default void print(IStringable obj) {
        System.out.println(obj.toString());
    }
}

class Book implements IStringable {
    private String title, author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author;
    }
}
//Polymorphism
//Q1
abstract class Shape {
    abstract double getArea();
}

class Rectangle extends Shape {
    double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    double getArea() { return w * h; }
}

class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double getArea() { return Math.PI * r * r; }
}
public class Main {
    //Functions/Methods
    //Q1
    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false; // mismatch found, not a palindrome
            }
        }
        return true; // all characters matched
    }
    //Classes
    //Q1
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public double getBalance() {
            return balance;
        }
    }
    //Enums
    //Q1
    public static String recommendActivity(Season season) {
        switch (season) {
            case SPRING:
                return "Plant flowers";
            case SUMMER:
                return "Go to the beach";
            case AUTUMN:
                return "Rake leaves";
            case WINTER:
                return "Build a snowman";
            default:
                return "Rest";
        }
    }

    public static void main(String[] args) {
        // Q1: Print command line arguments
        System.out.println("Number of arguments: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + (i + 1) + ": " + args[i]);
        }

        /*
         * Q2: 'main' is the entry point. static so the object is not created when main is called.
         * Q3: C++: int main(int argc, char* argv[]) returns int
         *     Java: public static void main(String[] args) returns void
         * Q4: C++: return 0 = success, non-zero = error
         *     Java: System.exit(code)
         */

        // Variables
        // (Q1)
        int a = 10;
        int b = 20;
        System.out.println("Before swap: a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swap: a = " + a + ", b = " + b);
        /*
         * Q2: primitive = stored directly in memory
         *     non-primitive = store memory addresses pointing to actual objects
         * Q3: local scope = variable exists only inside a function
         *     class/static scope = variable tied to class or object
         * Q4: both C++ and Java require declaring variable types
         */

        // Control Flow
        // (Q1)
        int n1 = 0, n2 = 1, nextTerm;
        System.out.print("First 10 Fibonacci numbers: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                System.out.print(n1 + " ");
            } else if (i == 2) {
                System.out.print(n2 + " ");
            } else {
                nextTerm = n1 + n2;
                System.out.print(nextTerm + " ");
                n1 = n2;
                n2 = nextTerm;
            }
        }
        System.out.println();
        /*
         * Q2: while checks condition first, may run zero times
         *     do-while runs at least once, then checks condition
         * Q3: switch - multi-branch control structure
         *     case = defines match
         *     break = prevents fall-through
         *     default = runs if no match
         * Q4: for && and ||, evaluation stops early if result is known (short-circuit)
         */

        // Functions/Methods
        // Q1: method's above
        String[] words = {"madam", "hello", "racecar"};
        for (String word : words) {
            System.out.println(word + " is palindrome? " + isPalindrome(word));
        }
        /*
         * Q2:
         * C++: pass-by-value (copy), pass-by-pointer (address passed), pass-by-reference
         * Java: always pass-by-value, but for objects the reference itself is passed by value
         * Q3: same function name, but different parameter lists
         * Q4: a function calling itself. Base cas is a stopping condition
         */
        //Comments
        //Q1
        //Single line comment
        /*
        Multi
        line
        comment.
        /**
        This is documentation style comment
         */
        /*
        Q2: Comments improve readability, and help the teams to maintain the code.
        Q3: These are the tools to generate structured documentation from comments.
        Q4: Comments are needed for complex logic, algorithms.
         */
        //Classes
        //Q1
        BankAccount myAccount = new BankAccount(1000);
        System.out.println("Initial balance: " + myAccount.getBalance());
        myAccount.deposit(500);
        System.out.println("Balance after deposit of 500: " + myAccount.getBalance());
        //Q2: Class is a template defining data and behavior. Object is an actual instance of a class created in memory.
        /*Q3: public: accessible everywhere
              private: accessible inside the class only
              protected: accessible to the subclasses
         */
        //Q4: Constructor is a special method used for initialization of objects when created.

        //Enums
        //Q1
        Season now = Season.AUTUMN;
        System.out.println("It's autumn! Let's: " + recommendActivity(now));
        //Q2: Enums prevent invalid values by restricting to predefined constants, improve code clarity, group related constants logically.
        //Q3: Limiting values to a fixed set, eliminating bugs due to invalid constants.
        //Q4: Java enums can have methods/fields; C++ scoped enums are simpler but type-safe; Java enums are classes

        //Inheritance
        //Q1
        Car myCar = new Car();
        myCar.startEngine();
        myCar.drive();

        /*Q2: is-a: inheritance(Car is-a Vehicle)
              has-a: composition(Car has-a Engine)
         */
        //Q3: Overriding: subclass replaces superclass method.
        //Q4: "Diamond Problem" occurs when a class inherits from two classes that both inherit from a common base class.

        //Mixins and Interfaces
        //Q1
        Book myBook = new Book("The Hobbit", "J.R.R. Tolkien");
        Printable printer = new Printable() {};
        printer.print(myBook);
        //Q2: The primary goal of patterns like mixins or interfaces is to add reusable behavior to classes without forcing  strict inheritance hierarchy.
        //Q3: Java default methods allow interfaces to have implemented methods, simulating mixin behavior.
        /*Q4: Inheritance has a clear "is-a" relationship, but can cause diamond problem.
              Composition is flexible, "has-a" relationship.
              Mixins/interfaces promote code reuse, increase modularity.
         */
        //Polymorphism
        //Q1
        Shape[] shapes = {
                new Rectangle(10, 5),
                new Circle(3)
        };
        for (Shape s : shapes) {
            System.out.println("Area: " + s.getArea());
        }
        /*Q2: Compile-time: method overloading, binding time at compile time, ex: void print(int)
              Runtime: method overriding, binding time at runtime, subclass overrides getArea()
        Q3: Abstract class can have both abstract and regular methods.
            Interface has only method signatures.
            Interface is used for capability and abstract for common base behavior.
        Q4: Both let referring to objects via a common type
         */

        //Async Operations
        //Q1: already provided
        //Q2: Async used to prevent blocking during slow operations,allowing others tasks to continue
        //Q3: In Concurrent tasks can start, run, complete at overlapping times, in parallel tasks run at the same time.
        //Q4:


    }
}
