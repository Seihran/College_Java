/**
 * Write a description of class MessagePost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MessagePost extends CommentedPost
{
    private String message;
    
    public MessagePost(String m, String uName, long tStamp)
    {
        super();
        message = m;
        userName = uName;
        timeStamp = tStamp;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public void setMessage(String m, String tStamp)
    {
        message = m;
        message += "\nLast edited: " + tStamp;
    }
    
    @Override
    public String toString()
    {
        String msg = "Message: " + getMessage() + "\nUsername: " + getUserName()
        + "\nLikes: " + getNumLikes() + "\nComments: \n" + getAllComments() + "\n";
        return msg;
    }
}