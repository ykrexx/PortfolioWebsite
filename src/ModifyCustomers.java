import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.util.logging.Logger;

/**
 * The ModifyCustomers class reads customers.xml, appends additional
 * contact fields, and writes out customer_modified.xml.
 * 
 * Demonstrates DOM modification and includes logging as a Java 2 enhancement.
 * 
 * @author BLP
 * @version 04/22/2025
 */
public class ModifyCustomers {

    private static final String INPUT_FILE  = "customers.xml";
    private static final String OUTPUT_FILE = "customer_modified.xml";
    private static final Logger LOGGER = Logger.getLogger(ModifyCustomers.class.getName());
    // Step5 Enhancement: Logging of XML modification process

    /**
     * Reads the original XML, adds phone, contactName, email to each <Customer>,
     * and writes out the new document.
     */
    public void modifyCustomers() {
        try {
            LOGGER.info("Starting modification of customer XML.");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(INPUT_FILE));
            doc.getDocumentElement().normalize();

            NodeList customers = doc.getElementsByTagName("Customer");
            for (int i = 0; i < customers.getLength(); i++) {
                Element cust = (Element) customers.item(i);

                // Mock data for new fields
                appendElement(doc, cust, "phone",       "555-010" + (i + 1));
                appendElement(doc, cust, "contactName","Contact " + (i + 1));
                appendElement(doc, cust, "email",       "user" + (i + 1) + "@example.com");
            }

            // Write the updated document to a new file
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(OUTPUT_FILE));
            transformer.transform(source, result);

            LOGGER.info("Modified XML written to " + OUTPUT_FILE);
            System.out.println("Created modified file: " + OUTPUT_FILE);
        } catch (Exception e) {
            LOGGER.severe("Error modifying customers: " + e.getMessage());
            System.err.println("Failed to modify customers: " + e.getMessage());
        }
    }

    /**
     * Utility to create and append a new child element with text content.
     *
     * @param doc    The XML Document
     * @param parent The element to append to
     * @param tag     The name of the new element
     * @param value   The text content
     */
    private void appendElement(Document doc, Element parent, String tag, String value) {
        Element node = doc.createElement(tag);
        node.appendChild(doc.createTextNode(value));
        parent.appendChild(node);
    }
}
