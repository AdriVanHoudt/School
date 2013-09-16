import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import   org.jdom.xpath.XPath;


import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Week3 extends JFrame{

    Document document;

    public static void main(String[] args) {
        Week3 Week3 = new Week3();

    }

    public Week3(){
            Oef1Bars();
            Oef1Moreover();
        infogain();
    }

    private void Oef1Bars(){

        try {
            document = Utils.readXml("C:\\Users\\adri\\Documents\\GitHub\\XML\\Week3\\bars.xml");

            XPath xPath = XPath.newInstance("//y-axis-title");
            Element element = (Element) xPath.selectSingleNode(document);
            System.out.println(element.getValue());

            xPath = XPath.newInstance("/bar-chart/bars/bar[@number=4]");
            element = (Element) xPath.selectSingleNode(document);
            System.out.println(element.getValue());

            xPath = XPath.newInstance("//bar[@number=5]");
            element = (Element) xPath.selectSingleNode(document);
            System.out.println(element.getValue());


        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void Oef1Moreover(){
        try {
            document = Utils.readXml("C:\\Users\\adri\\Documents\\GitHub\\XML\\Week3\\moreover.xml");

            XPath xPath = XPath.newInstance("//article[@code=13549014]/harvest_time");
            Element element = (Element) xPath.selectSingleNode(document);
            System.out.println(element.getValue());

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void infogain(){
        try {
            document = Utils.readXml("C:\\Users\\adri\\Documents\\GitHub\\XML\\Week3\\informationgain.xml");

            XPath xPath = XPath.newInstance("count(//n-gram[@frequency<10])");
            int d = (int) xPath.selectSingleNode(document);
            System.out.println("" + d);

            xPath = XPath.newInstance("count(//n-gram[@frequency<10 and @gain>0.5])");
            d = (int) xPath.selectSingleNode(document);
            System.out.println("" + d);


            xPath = XPath.newInstance("//n-gram[string-length()>10]");
            List<Element> elements = (List<Element>) xPath.selectSingleNode(document);
            for(Element e : elements){
                System.out.println(e.getValue());
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
