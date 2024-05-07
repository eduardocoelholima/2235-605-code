package exam3.exam3_2235;

import java.util.ArrayList;

public class LetsJoin extends Thread {
        static int accumulator;
        static ArrayList<LetsJoin> list = new ArrayList<>();

        public LetsJoin() { list.add(this); }
        public void run () { for (int i=0; i<1000; i++) accumulator++; }

        public static void main (String[] args) {
            for (int i=0; i<1000; i++) new LetsJoin().start();
            try { for (LetsJoin t:LetsJoin.list) t.join(); } catch (Exception e) {}
            System.out.println(LetsJoin.accumulator);
        }
    }

// Answer the questions.

//1 - What possible issue could happen when running this program? Explain.

// Lost updates since the accumulator access is not "protected" by a mutex.

//2 - How to fix it?

// have the run implementation be inside a synchronized block with a lock shared
// by all threads (or equivalent logic, eg a properly synchronized method called from run()).
