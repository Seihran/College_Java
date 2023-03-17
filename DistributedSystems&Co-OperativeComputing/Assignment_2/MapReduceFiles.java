import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class MapReduceFiles
{
	private static int count = 0;
  public static void main(String[] args)
  {
    if (args.length < 3)
    {
      System.err.println("usage: java MapReduceFiles file1.txt file2.txt file3.txt");
    }

    Map<String, String> input = new HashMap<String, String>();
    try
    {
      input.put(args[0], readFile(args[0]));
      input.put(args[1], readFile(args[1]));
      input.put(args[2], readFile(args[2]));
    }
    catch (IOException ex)
    {
        System.err.println("Error reading files...\n" + ex.getMessage());
        ex.printStackTrace();
        System.exit(0);
    }

    // APPROACH #3: Distributed MapReduce
    {
      final Map<String, Map<String, Integer>> output = new HashMap<String, Map<String, Integer>>();

      // MAP:

      long mapStart = System.currentTimeMillis();

      final List<MappedItem> mappedItems = new LinkedList<MappedItem>();

      final MapCallback<String, MappedItem> mapCallback = new MapCallback<String, MappedItem>()
      {
        @Override
        public synchronized void mapDone(String file, List<MappedItem> results)
        {
          mappedItems.addAll(results);
        }
      };

      List<Thread> mapCluster = new ArrayList<Thread>(Integer.parseInt(args[3]));

      Iterator<Map.Entry<String, String>> inputIter = input.entrySet().iterator();
      int i=0;
      int chosenSize = count/Integer.parseInt(args[3]);
      Map.Entry<String, String> entryMap = inputIter.next();
      while(i < chosenSize)
      {
          final String file = entryMap.getKey();
          final String contents = entryMap.getValue();
          String lines[] = contents.split(System.getProperty("line.separator"), Integer.parseInt(args[3]));
          
        Thread t = new Thread(new Runnable()
        {
          @Override
          public void run()
          {
        	  for (int k=0; k<(count/Integer.parseInt(args[3])); k++)
        	  {
        		  String content = lines[k];
        		  map(file, content, mapCallback);
        	  }
          }
        });
        mapCluster.add(t);
        t.start();
      }

      // wait for mapping phase to be over:
      for(Thread t : mapCluster)
      {
        try
        {
          t.join();
        }
        catch(InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }

      // GROUP:

      long groupStart = System.currentTimeMillis();
      long timeMap = groupStart-mapStart;

      Map<String, List<String>> groupedItems = new HashMap<String, List<String>>();

      Iterator<MappedItem> mappedIter = mappedItems.iterator();
      while(mappedIter.hasNext())
      {
        MappedItem item = mappedIter.next();
        String word = item.getWord();
        String file = item.getFile();
        List<String> list = groupedItems.get(word);
        if (list == null)
        {
          list = new LinkedList<String>();
          groupedItems.put(word, list);
        }
        list.add(file);
      }

      // REDUCE:

      long reduceStart = System.currentTimeMillis();
      long timeGroup = reduceStart-groupStart;

      final ReduceCallback<String, String, Integer> reduceCallback = new ReduceCallback<String, String, Integer>()
      {
        @Override
        public synchronized void reduceDone(String k, Map<String, Integer> v)
        {
          output.put(k, v);
        }
      };

      List<Thread> reduceCluster = new ArrayList<Thread>(Integer.parseInt(args[4]));

      Iterator<Map.Entry<String, List<String>>> groupedIter = groupedItems.entrySet().iterator();
      i = 0;
      chosenSize = groupedItems.size()/Integer.parseInt(args[4]);
      while(i < (chosenSize))
      {
    	List<String> words = new ArrayList<String>();
        List<List<String>> lists = new ArrayList<List<String>>();
        for (int j=0; j<Integer.parseInt(args[4]);j++)
        {
          Map.Entry<String, List<String>> entry = groupedIter.next();
          final String word = entry.getKey();
          words.add(word);
          final List<String> list = entry.getValue();
          lists.add(list);
        }

        Thread t = new Thread(new Runnable()
        {
          @Override
          public void run()
          {
            for (int k=0; k<Integer.parseInt(args[4]); k++)
            {
              String word = words.get(k);
              List<String> list = lists.get(k);
              reduce(word, list, reduceCallback);
            }
          }
        });
        reduceCluster.add(t);
        t.start();
        i++;
      }

      // wait for reducing phase to be over:
      for(Thread t : reduceCluster)
      {
        try
        {
          t.join();
        }
        catch(InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }

      long reduceEnd = System.currentTimeMillis();
      long timeReduce = reduceEnd-reduceStart;

      //System.out.println(output);

      System.out.println("Map time: " + timeMap + "ms");
      System.out.println("Group time: " + timeGroup + "ms");
      System.out.println("Reduce time: " + timeReduce + "ms");
    }
  }

  public static void map(String file, String contents, List<MappedItem> mappedItems)
  {
    String[] words = contents.trim().split("\\s+");
    for(String word: words)
    {
      mappedItems.add(new MappedItem(word, file));
    }
  }

  public static void reduce(String word, List<String> list, Map<String, Map<String, Integer>> output)
  {
    Map<String, Integer> reducedList = new HashMap<String, Integer>();
    for(String file: list)
    {
      Integer occurrences = reducedList.get(file);
      if (occurrences == null)
      {
        reducedList.put(file, 1);
      }
      else
      {
        reducedList.put(file, occurrences.intValue() + 1);
      }
    }
    output.put(word, reducedList);
  }

  public static interface MapCallback<E, V>
  {
    public void mapDone(E key, List<V> values);
  }

  public static void map(String file, String contents, MapCallback<String, MappedItem> callback)
  {
    String[] words = contents.trim().split("\\s+");
    List<MappedItem> results = new ArrayList<MappedItem>(words.length);
    for(String word: words)
    {
      results.add(new MappedItem(word, file));
    }
    callback.mapDone(file, results);
  }

  public static interface ReduceCallback<E, K, V>
  {
    public void reduceDone(E e, Map<K,V> results);
  }

  public static void reduce(String word, List<String> list, ReduceCallback<String, String, Integer> callback)
  {
    Map<String, Integer> reducedList = new HashMap<String, Integer>();
    for(String file: list)
    {
      Integer occurrences = reducedList.get(file);
      if (occurrences == null)
      {
        reducedList.put(file, 1);
      }
      else
      {
        reducedList.put(file, occurrences.intValue() + 1);
      }
    }
    callback.reduceDone(word, reducedList);
  }

  private static class MappedItem
  {
    private final String word;
    private final String file;

    public MappedItem(String word, String file)
    {
      this.word = word;
      this.file = file;
    }

    public String getWord()
    {
      return word;
    }

    public String getFile()
    {
      return file;
    }

    @Override
    public String toString()
    {
      return "[\"" + word + "\",\"" + file + "\"]";
    }
  }

  private static String readFile(String pathname) throws IOException
  {
    File file = new File(pathname);
    StringBuilder fileContents = new StringBuilder((int) file.length());
    Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
    String lineSeparator = System.getProperty("line.separator");
    String tempText;

    try
    {
      if (scanner.hasNextLine())
      {
        fileContents.append(scanner.nextLine());
      }
      while (scanner.hasNextLine())
      {
        tempText = scanner.nextLine();
        count++;

        tempText = tempText.replace("'", " ");
        tempText = tempText.replace("_", " ");
        tempText = tempText.replace(".", " ");
        tempText = tempText.replace("\"", " ");
        tempText = tempText.replace("/", " ");
        tempText = tempText.replace(">", " ");
        tempText = tempText.replace("<", " ");
        tempText = tempText.replace("(", " ");
        tempText = tempText.replace(")", " ");
        tempText = tempText.replace(",", " ");
        tempText = tempText.replace("=", " ");
        tempText = tempText.replace("+", " ");
        tempText = tempText.replace("-", " ");
        tempText = tempText.replace(":", " ");
        tempText = tempText.replace("?", " ");
        tempText = tempText.replace(";", " ");
        tempText = tempText.replace("[", " ");
        tempText = tempText.replace("]", " ");
        tempText = tempText.replace("{", " ");
        tempText = tempText.replace("}", " ");
        tempText = tempText.replace("*", " ");

        fileContents.append(lineSeparator + tempText);
      }
      return fileContents.toString();
    }
    finally
    {
      scanner.close();
    }
  }
}
