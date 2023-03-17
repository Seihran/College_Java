
/**
 * a File class
 *
 * @author (Conor Hayes)
 * @version (November 9th )
 */
public class File extends AbstractFile
{
    private String contents;
    
    public File(String name)
    {
        super();
        this.name = name;
    }
    
    public void setContents(String contents)
    {
        this.contents = contents;
    }
    
    public String getContents()
    {
        return contents;
    }
    
    @Override
    public int size()
    {
        if (contents == null)
        {
            return 0;
        }
        
        return contents.length();
    }
    
    @Override
    public int getNumFiles()
    {
        return 0;
    }
    
    @Override
    public int getNumFolders()
    {
        return 0;
    }
      
    @Override
    public AbstractFile find(String name)
    {
        return null;
    }
}
