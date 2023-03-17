/**
 * Write a description of class TestMessagePost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestMessagePost
{
    public static void main(String[] args)
    {
        TestMessagePost tp = new TestMessagePost();
        
        tp.testMessagePost();
        tp.testPhotoPost();
        tp.testEventPost();
    }
    
    public void testMessagePost()
    {
        MessagePost mp = new MessagePost("My first message", "Frank Glavin", 12345);
        mp.addComment("A comment");
        mp.addComment("A second comment");
        mp.likePost();
        mp.likePost();
        mp.likePost();
        mp.likePost();
        
        System.out.println("==============Message Test==============");
        System.out.println(mp);
    }
    
    public void testPhotoPost()
    {
        PhotoPost pp = new PhotoPost("Photo.jpg", "My photo", "Frank Glavin", 12345);
        pp.addComment("A comment");
        pp.addComment("A second comment");
        pp.addComment("A comment");
        pp.addComment("A second comment");
        pp.likePost();
        pp.likePost();
        
        System.out.println("==============Photo Test==============");
        System.out.println(pp);
        System.out.println(pp.sharePost());
    }
    
    public void testEventPost()
    {
        EventPost ep = new EventPost("Exam", "Date", "Time", "Frank Glavin", 12345);
        
        System.out.println("==============Event Test==============");
        System.out.println(ep);
        System.out.println(ep.sharePost());
    }
}