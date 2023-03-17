import java.util.ArrayList;

/**
 * Folder can contain File and other Folders
 *
 * @author (Conor Hayes)
 * @version (Nov 9th)
 */

public class Folder extends AbstractFile
{
    private ArrayList<AbstractFile> files = new ArrayList();
    
    public Folder(String name)
    {
        super();
        this.name = name;
    }

    public boolean add(AbstractFile fileObject)
    {
        return files.add(fileObject);
    }
    
    @Override
    public int size()
    {
        int size = 0;
        
        for (AbstractFile file : files)
        {
            size += file.size();
        }
        
        return size;
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
