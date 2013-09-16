import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Adri
 * Date: 6/02/13
 * Time: 13:37
 */
public class Week2 extends JFrame {
    public static void main(String[] args) {
        Week2 Week2 = new Week2();
        Week2.init();
    }

    private void init() {
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("genOef4");
        JButton btn2 = new JButton("genBars");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genOef4();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    genBars();
                } catch (JDOMException | IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.add(btn1);
        panel.add(btn2);
        this.add(panel);
        this.setSize(200, 100);
        setVisible(true);
    }

    private void genBars() throws JDOMException, IOException {
        final double START_X_LOCATION = 60;

        //get xml
        Document values = Utils.readXml("C:\\Users\\adri\\Documents\\GitHub\\XML\\Week2\\BarchartValues 1.xml");

        //gen canvas
        Element canvas = new Element("Canvas", Utils.getDefaultNamespace());
        canvas.setAttribute("Width", "1000");
        canvas.setAttribute("Height", "500");
        canvas.addContent(Utils.makeGradientBackground("Canvas", "#556EA5", "#C0C0C0"));

        //gen title
        Element title = new Element("TextBlock", Utils.getDefaultNamespace());
        title.setAttribute("Text", values.getRootElement().getChild("title").getValue());
        title.setAttribute("Foreground", "#FFFFFF");
        title.setAttribute("Canvas.Left", "442" );
        canvas.addContent(title);

        //gen x-as
        canvas.addContent(drawLine("100", "400", "830", "400", "Red","2" ));
        //gen y-as
        canvas.addContent(drawLine("100", "50", "100", "410", "Red", "2"));
        //gen axis x
        int xVal = 170;
        for(int i =0; i<10; i++){
            canvas.addContent(drawLine(""+xVal, "400", ""+xVal, "410", "Red", "2"));
            xVal+=70;
        }

        //gen bars
        //get bar info from xml file
        List<Element> bars  = values.getRootElement().getChild("bars").getChildren("bar");

        for(Element e : bars){
            //Create bar with default values
                Element border = new Element("Border", Utils.getDefaultNamespace());
                border.setAttribute("BorderBrush", "White");
                border.setAttribute("BorderThickness","1");
                border.setAttribute("Background", "Maroon");
                border.setAttribute("Canvas.Left", "100");
            //Set custom attributes
                //calc length of bar
                double i = Double.parseDouble(e.getValue());
                double result = ((i/20)*70);
                border.setAttribute("Width",""+result);
                //calc location
                double pxPerBar = (340/bars.size());
                double loc = START_X_LOCATION + (pxPerBar*(Double.parseDouble(e.getAttributeValue("number"))-1));
                border.setAttribute("Canvas.Top",""+loc);
            //create textblock
                Element block = new Element("TextBlock", Utils.getDefaultNamespace());
                block.setAttribute("HorizontalAlignment", "Right");
                block.setAttribute("Text", e.getValue());
                block.setAttribute("Background","Maroon");
                block.setAttribute("Foreground","White");
            //add text to border
                border.addContent(block);
            //add to canvas
                canvas.addContent(border);
        }


        //save Xaml file
        Utils.saveXaml(new Document(canvas), "C:\\Users\\adri\\Desktop\\testBars.xaml");
    }




    private Element drawLine(String x1, String y1, String x2, String y2, String stroke, String thickness) {
        Element line = new Element("Line", Utils.getDefaultNamespace());
        line.setAttribute("X1", x1);
        line.setAttribute("X2", x2);
        line.setAttribute("Y1", y1);
        line.setAttribute("Y2", y2);
        line.setAttribute("Stroke", stroke);
        line.setAttribute("StrokeThickness", thickness);
        return line;
    }


    private void genOef4() {
        Element grid = new Element("Grid", Utils.getDefaultNamespace());
        grid.addNamespaceDeclaration(Utils.getXNamespace());

        grid.addContent(Utils.getGridRows(3));
        grid.addContent(Utils.getGridColums(3));
        grid.addContent(Utils.makeGradientBackground("Grid", "#FFFFFFF0", "#FFFF0000"));

        for (int i = 0; i < 3; i++) {
            for (int z = 0; z < 3; z++) {
                Element box = new Element("TextBlock", Utils.getDefaultNamespace());
                box.setAttribute("Grid.Row", "" + z);
                box.setAttribute("Grid.Column", "" + i);
                box.setAttribute("VerticalAlignment", "Center");
                box.setAttribute("HorizontalAlignment", "Center");
                box.setAttribute("Text", "[" + i + "," + z + "]");
                box.setAttribute("Foreground", "#000080");
                grid.addContent(box);
            }
        }
        Document document = new Document(grid);
        Utils.saveXaml(document, "C:\\Users\\adri\\Desktop\\test-oef4.xaml");
    }


}
