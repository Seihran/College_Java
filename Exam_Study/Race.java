public class Race
{
    public static void main(String args[])
    {
        Race test = new Race();
        
        test.test1();
        test.test2();
        test.test3();
    }
    
    public void test1()
    {
        int rand1 = (int)(Math.random() * 10);
        int rand2 = (int)(Math.random() * 10);
        if (rand1 == 0) rand1 = 1;
        if (rand2 == 0) rand2 = 1;
        ProfessionalRunner pRun = new ProfessionalRunner(rand1, rand2);
        
        boolean success = false;
        String time = "00:00:00";
        if (Math.random() > 0.5)
        {
            success = true;
            time = "01:24:38";
        }
        
        System.out.println("Runner " + pRun.idNumber + " (Ranking "
        + pRun.getWorldRank() + ")");
        System.out.println("Status: ");
        pRun.results(success, time);
    }
    
    public void test2()
    {
        int rand = (int)(Math.random() * 10);
        if (rand == 0) rand = 1;
        AmateurRunner aRun = new AmateurRunner(rand);
        Sponsorship sponsor1 = new Sponsorship("John", "250.00");
        Sponsorship sponsor2 = new Sponsorship("Mary", "125.00");
        Sponsorship sponsor3 = new Sponsorship("Willow", "45.50");
        aRun.addSponsor(sponsor1);
        aRun.addSponsor(sponsor2);
        aRun.addSponsor(sponsor3);
        
        boolean success = false;
        String time = "00:00:00";
        if (Math.random() > 0.5)
        {
            success = true;
            time = "02:56:12";
        }
        
        System.out.println("Runner " + aRun.idNumber);
        aRun.dispSponsors();
        System.out.println("Status: ");
        aRun.results(success, time);
    }
    
    public void test3()
    {
        int rand = (int)(Math.random() * 10);
        if (rand == 0) rand = 1;
        FancyDressRunner fDRun = new FancyDressRunner(rand, "Red Crow");
        Sponsorship sponsor1 = new Sponsorship("Rick", "73.20");
        Sponsorship sponsor2 = new Sponsorship("Liam", "600.01");
        Sponsorship sponsor3 = new Sponsorship("Meredith", "137.00");
        fDRun.addSponsor(sponsor1);
        fDRun.addSponsor(sponsor2);
        fDRun.addSponsor(sponsor3);
        
        boolean success = false;
        String time = "00:00:00";
        if (Math.random() > 0.5)
        {
            success = true;
            time = "06:01:29";
        }
        
        System.out.println("Runner " + fDRun.idNumber + "("
        + fDRun.getCostume() + ")");
        fDRun.dispSponsors();
        System.out.println("Status: ");
        fDRun.results(success, time);
    }
}
