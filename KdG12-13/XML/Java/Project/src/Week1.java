import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Week1 extends JFrame {
    private JButton btn1 = new JButton("Test");

    public static void main(String[] args) {
        Week1 Week1 = new Week1();
        Week1.init();
    }

    private void init() {
        JPanel panel = new JPanel();
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateBars();
            }
        });
        panel.add(btn1);
        this.add(panel);
        this.setSize(200, 100);
        setVisible(true);
    }

    /*
     switch(letter)
     {
         case 'A':
         case 'E':
         case 'I':
         case 'O':
         case 'U':
         vowel = true;
         break;
         default:
         vowel = false;
         break;
         }
     */
    private void generateBars() {
        Element rootElement = new Element("root");
        Element rootVal = new Element("value");
        rootVal.addContent("250");
        rootElement.addContent(rootVal);
        Element bars = new Element("bars");

        for (int i = 0; i < 10; i++) {
            Element bar = new Element("bar");
            bar.addContent(Integer.toString(i));
            bars.addContent(bar);
        }

        rootElement.addContent(bars);
        Document document = new Document(rootElement);
        saveXml(document);
    }

    public void saveXml(Document document) {
        XMLOutputter outputter = new XMLOutputter();
        Format format = Format.getPrettyFormat();
        outputter.setFormat(format);

        try {
            outputter.output(document, new FileWriter("C:\\Users\\adri\\Desktop\\test.Week1"));
        } catch (IOException io) {
            System.out.println("IO ERROR");
        }
    }
}
