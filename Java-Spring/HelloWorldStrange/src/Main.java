public class Main {

    public static void main(String[] args) {
        MessageRenderer rd = new COutRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        rd.setMessageProvider(mp);
        rd.render();
    }
}

interface MessageProvider
{
    public String getMessage();
}

interface MessageRenderer
{
    public void render();
    public MessageProvider getMessageProvider();
    public void setMessageProvider(MessageProvider arg);
}

class HelloWorldMessageProvider implements MessageProvider
{
    @Override
    public String getMessage()
    {
        return ("Hello,World!");
    }
}

class COutRenderer implements MessageRenderer
{
    private MessageProvider provider;
    @Override
    public void render()
    {
        System.out.println(provider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider arg)
    {
        provider=arg;
    }

    @Override
    public MessageProvider getMessageProvider()
    {
        return provider;
    }
}
