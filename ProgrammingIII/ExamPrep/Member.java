import java.io.Serializable;
import java.time.LocalDate;

public class Member implements Comparable<Member>, Serializable
{
	private static final long serialVersionUID = 1235L;
	private String name;
	private static long baseID = 0;
	private long id;
	private LocalDate joinDate;
	private boolean paid;
	
	public Member(String name)
	{
		this.name = name;
		setID(baseID + 1);
		setJoinDate();
	}
	
	public String toString()
    {
        return name + ", ID: " + getID() + ", Joined: " + getJoinDate() + ", Paid: " + getPaid();
    }
	
	public String getName()
	{
		return name;
	}

    public LocalDate getJoinDate()
    {
		return joinDate;
	}

	public void setJoinDate()
	{
		joinDate = LocalDate.now();
	}
	
	public long getID()
    {
		return id;
	}

	public void setID(long id)
	{
		this.id = id;
		baseID = baseID + 1;
	}
	
	public boolean getPaid()
	{
		return paid;
	}
	
	public void setPaid(boolean paid)
	{
		this.paid = paid;
	}

	@Override
	public int compareTo(Member o)
	{
		return Long.compare(this.id, o.getID());
	}
}
