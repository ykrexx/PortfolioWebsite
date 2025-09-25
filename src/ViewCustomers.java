import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * The ViewCustomers class parses a customers.xml file and
 * prints a formatted listing to the console.
 * 
 * Expects customers.xml to live in the program working directory.
 * 
 * @author BLP
 * @version 04/22/2025
 */
public class ViewCustomers {

    private static final String INPUT_FILE = "customers.xml";

    /**
     * Parses the XML and prints each customer's data to the console.
     */
    public void displayCustomers() {
        try {
            // Prepare the document builder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input XML file
            Document doc = dBuilder.parse(new File(INPUT_FILE));
            doc.getDocumentElement().normalize();

            // Print root element name
            String rootName = doc.getDocumentElement().getNodeName();
            System.out.println("Root element is : " + rootName);
            
            // Retrieve all <Customer> elements
            NodeList customers = doc.getElementsByTagName("Customer");
            for (int i = 0; i < customers.getLength(); i++) {
                Node node = customers.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element custElem = (Element) node;
                    printCustomer(custElem);
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading " + INPUT_FILE + ": " + e.getMessage());
        }
    }

    /**
     * Helper to print one customer's fields in the required format.
     *
     * @param elem The <Customer> element
     */
    private void printCustomer(Element elem) {
        // Extract attributes and child elements
        String id      = elem.getAttribute("id");
        String name    = getTagValue("name", elem);
        String type    = getTagValue("type", elem);
        String address = getTagValue("address", elem);
        String city    = getTagValue("city", elem);
        String state   = getTagValue("state", elem);
        String zip     = getTagValue("zipcode", elem);

        // Output formatting
        System.out.println();
        System.out.println("Customer ID " + id);
        System.out.println("Name:\t" + name);
        System.out.println("Type:\t" + type);
        System.out.println("Address: " + address);
        System.out.println("\t\t" + city + ", " + state + " " + zip);
    }

    /**
     * Utility to fetch text content of a given tag name.
     *
     * @param tag   The child tag to find
     * @param elem  The parent element
     * @return      Text content, or empty string if missing
     */
    private String getTagValue(String tag, Element elem) {
        NodeList nl = elem.getElementsByTagName(tag);
        if (nl.getLength() > 0) {
            return nl.item(0).getTextContent();
        }
        return "";
    }
}
