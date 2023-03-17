/**
 * Write a description of class EventPost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EventPost extends Post implements Shareable
{
    private String eType;
    private String eDate;
    private String eTime;
    
    public EventPost(String eventT, String eventD, String eventTime, String uName, long tStamp)
    {
        eType = eventT;
        eDate = eventD;
        eTime = eventTime;
        userName = uName;
        timeStamp = tStamp;
    }
    
    public String getEventType()
    {
        return eType;
    }
    
    public String getEventDate()
    {
        return eDate;
    }
    
    public String getEventTime()
    {
        return eTime;
    }
    
    public void setEventType(String t)
    {
        eType = t;
    }
    
    public void setEventDate(String d)
    {
        eDate = d;
    }
    
    public void setEventTime(String time)
    {
        eTime = time;
    }
    
    @Override
    public String toString()
    {
        String msg = "Event: " + getEventType() + "\nUsername: " + getUserName()
        + "\nStart Date: " + getEventDate() + "\nStart Time: " + getEventTime() + "\n";
        return msg;
    }
    
    public String sharePost()
    {
        String toShare = "[================Shared Event Post================]\n";
        toShare += this;
        toShare += "[=================================================]\n";
        return toShare;
    }
}