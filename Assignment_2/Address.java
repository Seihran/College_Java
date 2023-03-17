/**
 * Stores the address details and returns their combined details in one string
 *
 * @author (Ciarán McCarthy)
 * @version (12/10/2019)
 */

public class Address
{
    private String streetOne;
    private String streetTwo;
    private String city;
    private String zipcode;
    private String country;
    
    public Address()
    {
        
    }
    
    public void setAddress(String s1, String s2, String city, String z, String c)
    {
        streetOne = s1;
        streetTwo = s2;
        this.city = city;
        zipcode = z;
        country = c;
    }
    
    public String getAddress()
    {
        //Returns a string value containing all parts of address object in one
        String out = streetOne + ", " + streetTwo + ", " + city + ", " + zipcode + ", " + country;
        return out;
    }
}
