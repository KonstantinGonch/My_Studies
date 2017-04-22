/**
 * Created by JohnCena on 13.03.2017.
 */
public class Speaker {
    private Speakable arg;
    public void speak()
    {
        arg.say();
    }
    public void setSpeaker(Speakable a)
    {
        arg = a;
    }
}
