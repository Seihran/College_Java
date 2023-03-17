import java.util.ArrayList;

/**
 * Abstract class CommentedPost - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class CommentedPost extends Post
{
    int likes;
    ArrayList<String> comments = new ArrayList<>();
    
    public CommentedPost()
    {
        likes = 0;
    }
    
    public int getNumLikes()
    {
        return likes;
    }
    
    public void likePost()
    {
        likes++;
    }
    
    public void addComment(String comment)
    {
        comments.add(comment);
    }
    
    public String getAllComments()
    {
        String allComments = "";
        int i = 1;
        
        for (String c : comments)
        {
            allComments += "[" + i + "] " + c + "\n";
            i++;
        }
        
        return allComments;
    }
}