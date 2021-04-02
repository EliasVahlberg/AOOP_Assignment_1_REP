public class Message
{

    private String text;

    /**
     * Construct a Message object.
     *
     * @param messageText
     *            the message text
     */
    public Message(String messageText) {
        text = messageText;
    }

    /**
     * Get the message text.
     *
     * @return message text
     */
    public String toString() {
        return text;
    }
}