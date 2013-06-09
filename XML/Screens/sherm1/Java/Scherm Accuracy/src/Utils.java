import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Adri
 * Date: 6/02/13
 * Time: 14:10
 */
public class Utils {
     /* Xaml Utils */


    public static Document readXml(String url) throws JDOMException, IOException {
        SAXBuilder parser = new SAXBuilder();
        return parser.build(url);
    }

    public static Element makeGradientBackground(String control, String startColor, String endColor) {
        Element gridBack = new Element(control + ".Background", getDefaultNamespace());
        Element brush = new Element("LinearGradientBrush", getDefaultNamespace());
        Element stop = new Element("GradientStop", getDefaultNamespace());
        Element stop2 = new Element("GradientStop", getDefaultNamespace());

        stop.setAttribute("Color", startColor);
        stop2.setAttribute("Color", endColor);
        stop2.setAttribute("Offset", "1");

        brush.addContent(stop);
        brush.addContent(stop2);
        gridBack.addContent(brush);

        return gridBack;
    }

    public static Element getGridRows(int number) {
        Element def = new Element("Grid.RowDefinitions", getDefaultNamespace());

        for (int i = 0; i < number; i++) {
            Element rowdef = new Element("RowDefinition", getDefaultNamespace());
            def.addContent(rowdef);
        }

        return def;
    }

    public static Element getGridColums(int number) {
        Element def = new Element("Grid.ColumnDefinitions", getDefaultNamespace());

        for (int i = 0; i < number; i++) {
            Element colmdef = new Element("ColumnDefinition", getDefaultNamespace());
            def.addContent(colmdef);
        }

        return def;
    }


    public static Namespace getDefaultNamespace() {
        return Namespace.getNamespace("http://schemas.microsoft.com/winfx/2006/xaml/presentation");
    }

    public static Namespace getXNamespace() {
        return Namespace.getNamespace("x", "http://schemas.microsoft.com/winfx/2006/xaml");
    }

    /* Utils */

    public static void saveXml(Document document, String url) {
        XMLOutputter outputter = new XMLOutputter();
        Format format = Format.getPrettyFormat();
        outputter.setFormat(format);

        try {
            //example "C:\\Users\\adri\\Desktop\\test.xml"
            outputter.output(document, new FileWriter(url));
            System.out.println(url + "  --succesfull save--");
        } catch (IOException io) {
            System.out.println("IO ERROR");
        }
    }

    public static void saveXaml(Document document, String url) {
        XMLOutputter outputter = new XMLOutputter();
        Format format = Format.getPrettyFormat();
        outputter.setFormat(format);

        try {
            outputter.output(document, new FileWriter(url));
            System.out.println(url + "  --succesfull save--");
        } catch (IOException io) {
            System.out.println("IO ERROR");
        }
    }
}
