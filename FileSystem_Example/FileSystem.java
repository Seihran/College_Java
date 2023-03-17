
/**
 * Filesystem has a main method and is used to 
 * simulate different Folder/File scenarios.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileSystem
{
    public static void main(String[] args)
    {
        FileSystem fileSystem = new FileSystem();
        fileSystem.fileTest1();
    }
    
    public void fileTest1()
    {
        Folder documents = new Folder("Documents");
        Folder music = new Folder("Music");
        Folder photos = new Folder("Photos");
        documents.add(music);
        documents.add(photos);
        File assign1  = new File("assign1.doc");
        documents.add(assign1);
        Folder dylan = new Folder("Dylan");
        music.add(dylan);
        Folder band = new Folder("The Band");
        music.add(band);
        File family = new File("family.jpg");
        photos.add(family);
        File tambourine = new File("tambourine.mp3");
        dylan.add(tambourine);
        File weight = new File("");
        band.add(weight);
        File dixie = new File("");
        band.add(dixie);
        
        String contents1 = "Hey, mister";
        String contents2 = "";
        String contents3 = "";
        String contents4 = "";
        
        weight.setContents(contents1);
        tambourine.setContents(contents2);
        dixie.setContents(contents3);
        assign1.setContents(contents4);
        
        int expected = contents1.length() + contents2.length() + 
        contents3.length() + contents4.length();
        int result = documents.size();
        
        if (result == expected)
        {
            System.out.println();
        }
        else
        {
            System.out.println();
        }
    }
}
