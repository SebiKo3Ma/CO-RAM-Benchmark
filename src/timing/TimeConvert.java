package timing;

public class TimeConvert {
    public double convert(long time, String unit) {
        double newTime = 0;
        switch(unit) {
            case "miliseconds":
                newTime = (double)time / 1000000;
                break;

            case "microseconds":
                newTime = (double)time / 1000;
                break;

            case "seconds":
                newTime = (double)time / 1000000000;
                break;
            default:
                throw new IllegalArgumentException("Invalid Argument!");
        }

        return newTime;
    }
}
