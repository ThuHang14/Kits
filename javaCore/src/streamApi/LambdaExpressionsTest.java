package streamApi;

// @FunctionalInterface //It is optional
interface Addable { int add (int a,int b);
}
public class LambdaExpressionsTest {
public static void main(String[] args) {
Addable ad1= ( a, b ) -> (a+b) ; // Lambda expression without return keyword. // { return (a+b); }
System.out.println(ad1.add(10,20));
Addable ad2=( int a,int b )-> { // Lambda expression with return keyword.
return (a+b);
};
System.out.println(ad2.add(100,200));
}
} 
