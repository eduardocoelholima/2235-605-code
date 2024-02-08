package exam3;

public class Deadlock2 extends Thread {
        private int id;
        static Object a = new Object(), b = new Object();
        boolean go1 = true, go2 = false;
        public Deadlock2(int id) {
            this.id = id;
            if ( id == 0 ) ( new Deadlock2(1) ).start();
        }

        public void run () {
            for (int i=0; i<2; i++) {
                if (id == 0) {
                    if (go1) try { sleep(100); go1 = !go1; } catch (Exception e) {}

                    synchronized (a) {
                        try { sleep(100); } catch (Exception e) {}
                        synchronized (b) {
                            System.out.println(id);
                        }
                        try { sleep(100); } catch (Exception e) {}

                    }
                } else {
                    if (go2) try { sleep(100); go2 = !go2; } catch (Exception e) {}

                    synchronized (a) {
                        try { sleep(100); } catch (Exception e) {}
                        synchronized (b) {
                            System.out.println(id);
                        }
                        try { sleep(100); } catch (Exception e) {}

                    }
                }
            }
        }
        public static void main (String[] args) { new Deadlock2(0).start(); }
    }

// Answer the questions.
//1 - What are the possible outputs of this program?
//2 - Will this program ever run into a deadlock? Why?
