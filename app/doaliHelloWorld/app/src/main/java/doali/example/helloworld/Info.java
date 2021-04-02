package doali.example.helloworld;

public class Info
{
    private String start;
    private String stop;
    private long duration;

    public String getStart() {
        return start;
    }

    public String getStop() {
        return stop;
    }

    public long getDuration() {
        return duration;
    }

    public void setStart(final String start) {
        this.start = start;
    }

    public void setStop(final String stop) {
        this.stop = stop;
    }

    public void setDuration(final long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "{'start':" + start + ",'stop':" + stop + ",'duration':" + duration + '}';
    }
}
