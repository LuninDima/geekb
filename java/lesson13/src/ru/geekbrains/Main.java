package ru.geekbrains;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
        public static final int CARS_COUNT = 4;
        public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            CyclicBarrier cb = new CyclicBarrier(5);
            CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10),cb, cdl);
            }
            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();

            }
            cb.await();
            cb.await();
            cb.await();
            cb.a wait();
            try {

                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
