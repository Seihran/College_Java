/**
 * Write a description of class PhotoPost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhotoPost extends CommentedPost implements Shareable
{
    private String fileName;
    private String caption;
    
    public PhotoPost(String fName, String cName, String uName, long tStamp)
    {
        super();
        fileName = fName;
        caption = cName;
        userName = uName;
        timeStamp = tStamp;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    public String getCaption()
    {
        return caption;
    }
    
    public void setFileName(String fName)
    {
        fileName = fName;
    }
    
    public void setCaption(String cName)
    {
        caption = cName;
    }
    
    @Override
    public String toString()
    {
        String msg = "Photo: " + getFileName() + "\nCaption: " + getCaption() + "\nUsername: "
        + getUserName() + "\nLikes: " + getNumLikes() + "\nComments: \n" + getAllComments() + "\n";
        return msg;
    }
    
    public String sharePost()
    {
        String toShare = "[================Shared Photo Post================]\n";
        toShare += this;
        toShare += "[=================================================]\n";
        return toShare;
    }
}