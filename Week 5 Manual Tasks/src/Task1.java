class Counter {
    private int value;
    private final int rollover;

    public Counter(int rollover) {
        if (rollover <= 0) {
            throw new IllegalArgumentException("Rollover must be positive");
        }
        this.rollover = rollover;
        this.value = 0;
    }

    public boolean increment() {
        value++;
        if (value >= rollover) {
            value = 0;
            return true;
        }
        return false;
    }

    public void set(int newValue) {
        if (newValue < 0 || newValue >= rollover) {
            throw new IllegalArgumentException("Value must be between 0 and " + (rollover - 1));
        }
        value = newValue;
    }

    public int get() {
        return value;
    }

    public void reset() {
        value = 0;
    }

    @Override
    public String toString() {
        return String.format("%02d", value);
    }
}

class DigitalTimer {
    private Counter hours;
    private Counter minutes;

    public DigitalTimer() {
        hours = new Counter(24);
        minutes = new Counter(60);
    }

    public DigitalTimer(int hours, int minutes) {
        this();
        set(hours, minutes);
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

    public void tick() {
        if (minutes.increment()) {
            hours.increment();
        }
    }

    public void set(int hours, int minutes) {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException(
                    "Invalid time: hours must be 0-23 and minutes 0-59");
        }
        this.hours.set(hours);
        this.minutes.set(minutes);
    }
}

class Task1 {
    public static void main(String[] args) {
        DigitalTimer t1 = new DigitalTimer();
        System.out.println("Default timer: " + t1);

        DigitalTimer t2 = new DigitalTimer(23, 58);
        System.out.println("Start: " + t2);
        for (int i = 0; i < 4; i++) {
            t2.tick();
            System.out.println("After tick: " + t2);
        }

        t2.set(7, 5);
        System.out.println("After set(7, 5): " + t2);

        try {
            t2.set(24, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            new DigitalTimer(10, 60);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}