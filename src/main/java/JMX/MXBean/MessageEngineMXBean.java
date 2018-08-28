package JMX.MXBean;

public interface MessageEngineMXBean {

    public void stop();
    public boolean isPaused();
    public void pause(boolean pause);
    public Message getMessage();
    public void changeMessage(Message m);
}
