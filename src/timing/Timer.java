package timing;

public class Timer implements ITimer{
    private long start, end, elapsed, totalTime;

    public void start() {
        totalTime = 0;
        start = System.nanoTime();
    }

    public long stop() {
        end = System.nanoTime();
        elapsed = end - start;
        totalTime += elapsed;
        return totalTime;
    }

    public void resume() {
        start = System.nanoTime();
    }

    public long pause() {
        end = System.nanoTime();
        elapsed = end - start;
        totalTime += elapsed;
        return elapsed;
    }
}
