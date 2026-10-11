public class Task1 {

    static class JTime {
        private int hour, minute, second;

        public JTime() { this(0, 0, 0); }

        public JTime(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public JTime(int totalSeconds) {
            totalSeconds = totalSeconds % 86400;
            this.hour = totalSeconds / 3600;
            this.minute = (totalSeconds % 3600) / 60;
            this.second = totalSeconds % 60;
        }

        public int toSeconds() { return hour * 3600 + minute * 60 + second; }

        public int elapsedSeconds(JTime other) {
            return Math.abs(this.toSeconds() - other.toSeconds());
        }

        public JTime elapsedTime(JTime other) {
            return new JTime(elapsedSeconds(other));
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", hour, minute, second);
        }
    }

    public static void main(String[] args) {
        JTime t1 = new JTime(2, 30, 15);
        JTime t2 = new JTime(10, 45, 50);
        JTime t3 = new JTime(3725);   // 1h 2m 5s

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t3 (from 3725 sec) = " + t3);
        System.out.println("Elapsed t1->t2 (seconds) = " + t1.elapsedSeconds(t2));
        System.out.println("Elapsed t1->t2 (time-stamp) = " + t1.elapsedTime(t2));
    }
}