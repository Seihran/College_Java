
/**
 * Write a description of class AbstractFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class AbstractFile
{
    String name;
    
    public abstract int size();
    
    public abstract int getNumFiles();
    
    public abstract int getNumFolders();
    
    public abstract AbstractFile find(String name);
    
    public String getName()
    {
        return name;
    }   
}
