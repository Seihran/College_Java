public class ProfessionalRunner extends Runner
{
    private int worldRank;
    
    public ProfessionalRunner(int id, int world)
    {
        super();
        idNumber = id;
        worldRank = world;
    }
    
    public int getWorldRank()
    {
        return worldRank;
    }
}
