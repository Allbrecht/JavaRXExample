package com.example;

import rx.Observable;
import rx.Observer;

public class RXExample {

    public static void main(String[] names) {
        //hello(1, 2, 3, 4, 5);
        divide();
        //division();

    }

    public static void hello(Integer... names) {
        Observable.from(names).subscribe(s -> System.out.println("Hello " + s + "!"));
    }

    public static void divide() {
        Observer<Divider> obs = new Observer<Divider>() {


            @Override
            public void onCompleted() {
                System.out.println("Finished dividing");
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("Bad input: " + e.getMessage());
            }

            @Override
            public void onNext(Divider divider) {
                try {
                    System.out.println(divider.divide());
                } catch (RuntimeException e) {
                    onError(e);
                }
            }
        };
        Divider[] div = {new Divider(1,2), new Divider(2,0)};
        Observable.from(div).subscribe(obs);
    }

    static void division() {
        Observer<Calc> obs =  new Observer<Calc>() {
            @Override
            public final void onNext(Calc calc) {
                System.out.println(calc.a + "/" + calc.b + " = " + (calc.a / calc.b));
            }

            @Override
            public final void onCompleted() {
                System.out.println("Finished all");
            }

            @Override
            public final void onError(Throwable e) {
                System.out.println("Error! " + e.getMessage());
            }
        };
        Calc[] calc = {new Calc(10,2), new Calc(10, 5), new Calc(5,0),  new Calc(100,1)};
        Observable.from(calc).subscribe(obs);
    }

    static class Calc {
        int a;
        int b;

        Calc(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
