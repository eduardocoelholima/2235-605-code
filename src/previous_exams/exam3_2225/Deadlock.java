package exam3;

public class Deadlock extends Thread {
        private int id;
        static Object a = new Object(), b = new Object();

        public Deadlock(int id) {
            this.id = id;
            if ( id == 0 ) ( new Deadlock(1) ).start();
        }

        public void run () {
            for (int i=0; i<2; i++) {
                if (id == 0) {
                    synchronized (a) {
                        try { sleep(100); } catch (Exception e) {}
                        synchronized (b) {
                            System.out.println(id);
                            try { sleep(100); } catch (Exception e) {}
                        }
                    }
                } else {
                    synchronized (a) {
                        try { sleep(100); } catch (Exception e) {}
                        synchronized (b) {
                            System.out.println(id);
                            try { sleep(100); } catch (Exception e) {}
                        }
                    }
                }
            }
        }
        public static void main (String[] args) { new Deadlock(0).start(); }
    }

// Answer the questions.
//1 - What are the possible outputs of this program?
//2 - Will this program ever run into a deadlock? Why?
