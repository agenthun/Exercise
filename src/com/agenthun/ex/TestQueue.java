package com.agenthun.ex;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by agenthun on 15/12/5.
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = o1 % 2 - o2 % 2;
                if (result == 0) result = o1 - o2;
                return result;
            }
        });
        for (int i = 0; i < 3; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(queue.poll() + " ");
        }
    }
/*
        private String name;
        private int population;
        public TestQueue(String name, int population)
        {
            this.name = name;
            this.population = population;
        }
        public String getName()
        {
            return this.name;
        }

        public int getPopulation()
        {
            return this.population;
        }
        public String toString()
        {
            return getName() + " - " + getPopulation();
        }
        public static void main(String args[])
        {
            Comparator<TestQueue> OrderIsdn =  new Comparator<TestQueue>(){
                public int compare(TestQueue o1, TestQueue o2) {
                    // TODO Auto-generated method stub
                    int numbera = o1.getPopulation();
                    int numberb = o2.getPopulation();
                    if(numberb > numbera)
                    {
                        return 1;
                    }
                    else if(numberb<numbera)
                    {
                        return -1;
                    }
                    else
                    {
                        return 0;
                    }

                }



            };
            Queue<TestQueue> priorityQueue =  new PriorityQueue<TestQueue>(11,OrderIsdn);



            TestQueue t1 = new TestQueue("t1",1);
            TestQueue t3 = new TestQueue("t3",3);
            TestQueue t2 = new TestQueue("t2",2);
            TestQueue t4 = new TestQueue("t4",0);
            priorityQueue.add(t1);
            priorityQueue.add(t3);
            priorityQueue.add(t2);
            priorityQueue.add(t4);
            System.out.println(priorityQueue.poll().toString());
        }*/

}
