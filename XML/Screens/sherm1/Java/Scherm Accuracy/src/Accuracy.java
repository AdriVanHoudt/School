import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class Accuracy extends JFrame {

    XPath xPath;

    public static void main(String[] args) {
      Accuracy a = new Accuracy();
        a.init();
    }


    private void init() {
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("genScreen1");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    genScreen1();
                } catch (JDOMException e1) {
                    e1.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
        panel.add(btn1);
        this.add(panel);
        this.setSize(200,100);
        this.setVisible(true);
    }
    private void genScreen1() throws JDOMException, IOException {
        //get source xml
        Document sourceDocument = Utils.readXml("C:\\Users\\adri\\Documents\\GitHub\\XML\\Screens\\sherm1\\accuracy 1.xml");

        //get grid
        Element grid = getGrid();

        //get canvas
        Element canvas = getCanvas(sourceDocument);
        grid.addContent(canvas);

        Document document = new Document();
        document.addContent(grid);
        Utils.saveXaml(document,"C:\\Users\\adri\\Documents\\GitHub\\XML\\Screens\\sherm1\\accuracy1.xaml" );

    }


    private Element getCanvas(Document source) throws JDOMException {
        //gen canvas
        Element canvas = new Element("Canvas", Utils.getDefaultNamespace());
        canvas.setAttribute("Grid.Column", "1");
        canvas.setAttribute("Height", "750");
        canvas.setAttribute("Width", "1000");

        //gen canvas back
        Element backgr = new Element("Canvas.Background", Utils.getDefaultNamespace());
        Element brush = new Element("LinearGradientBrush", Utils.getDefaultNamespace());
        Element stop1 = new Element("GradientStop", Utils.getDefaultNamespace());
        stop1.setAttribute("Color", "#FF93C5E8");
        brush.addContent(stop1);
        Element stop2 = new Element("GradientStop", Utils.getDefaultNamespace());
        stop2.setAttribute("Color","#FF3B596E");
        stop2.setAttribute("Offset", "1");
        brush.addContent(stop2);
        backgr.addContent(brush);
        canvas.addContent(backgr);

        //set axis
        setAxis(canvas, source);
        //set titles
        setTitles(canvas, source);
        //set legend
        setLegend(canvas, source);
        //set bars
        setBars(canvas, source);
        return canvas;
    }


    private void setBars(Element canvas, Document source) throws JDOMException {
        xPath = XPath.newInstance("//data");
        List<Element> data = xPath.selectNodes(source);
        int barcount=0;
        int left=140;
       for(Element e : data){
         List<Element> eChildren = e.getChildren();
         for(Element child : eChildren){
             Element bar = new Element("Border", Utils.getDefaultNamespace());
             bar.setAttribute("Canvas.Top", "200");
             bar.setAttribute("Canvas.Left", Integer.toString(left + (barcount * 60)));
             bar.setAttribute("Width", "40");
             bar.setAttribute("Height", Integer.toString(Integer.parseInt(child.getValue())*20));

             Element block = new Element("TextBlock",Utils.getDefaultNamespace());
             block.setAttribute("HorizontalAlignment", "Center");
             block.setAttribute("VerticalAlignment", "bottom");
             block.setAttribute("Text", child.getValue());
             block.setAttribute("Foreground", "Ivory");

             if(barcount==0){
                bar.setAttribute("Background", "#FF0093DD");
             }else if(barcount==1){
                 bar.setAttribute("Background", "#FF29166F");
             }else{
                 bar.setAttribute("Background", "#FF830F0F");
             }

             barcount++;
             bar.addContent(block);
             canvas.addContent(bar);
         }
           left+=220;
           barcount=0;
       }
    }

    private void setLegend(Element canvas, Document source) throws JDOMException {
        //gen legend
        for(int i = 0; i<3; i++){
        Element border = new Element("Border", Utils.getDefaultNamespace());
        border.setAttribute("Canvas.Top", "650");
        border.setAttribute("Width", "240");
        border.setAttribute("Height", "35");

        if(i==0){
            border.setAttribute("Background", "#FF0093DD");
        }else if(i==1){
            border.setAttribute("Background", "#FF29166F");
        }else{
            border.setAttribute("Background", "#FF830F0F");
        }
        border.setAttribute("Canvas.Left", Integer.toString(100+(i*240)));

            Element block = new Element("TextBlock", Utils.getDefaultNamespace());
            block.setAttribute("FontSize", "13");
            block.setAttribute("Foreground", "Ivory");
            block.setAttribute("HorizontalAlignment", "Center");
            block.setAttribute("VerticalAlignment", "Center");


                xPath = XPath.newInstance("//legend/label[@number="+ (i+1) +"]");
                Element header = (Element) xPath.selectSingleNode(source);
                block.setAttribute("Text", header.getValue());
                border.addContent(block);
                canvas.addContent(border);


        }

    }

    private void setTitles(Element canvas, Document source) throws JDOMException {
         //gen main title
        Element border = new Element("Border", Utils.getDefaultNamespace());
        border.setAttribute("Canvas.Top", "20");
        border.setAttribute("Canvas.Left", "415");
        border.setAttribute("Width", "170");
        border.setAttribute("Height", "40");
        Element block = new Element("TextBlock", Utils.getDefaultNamespace());
        block.setAttribute("HorizontalAlignment", "Center");
        block.setAttribute("VerticalAlignment", "Center");
        block.setAttribute("Foreground", "Ivory");
        block.setAttribute("FontSize", "25");

            xPath = XPath.newInstance("//heading");
            Element header = (Element) xPath.selectSingleNode(source);
            block.setAttribute("Text", header.getValue());
            border.addContent(block);
            canvas.addContent(border);

        //gen column titles
        for(int i = 0; i<3; i++){
            Element border2 = new Element("Border", Utils.getDefaultNamespace());
            border2.setAttribute("Canvas.Top", "100");
            border2.setAttribute("Canvas.Left", Integer.toString(160+(i*220)));
            border2.setAttribute("Width", "120");
            border2.setAttribute("Height", "40");
            border2.setAttribute("BorderBrush", "Red");
            border2.setAttribute("BorderThickness", "2");

            Element block2 = new Element("TextBlock", Utils.getDefaultNamespace());
            block2.setAttribute("HorizontalAlignment", "Center");
            block2.setAttribute("VerticalAlignment", "Center");
            block2.setAttribute("Foreground", "Ivory");
            block2.setAttribute("FontSize", "18");

                xPath = XPath.newInstance("//x-labels/label[@number="+ (i+1) +"]");
                header = (Element) xPath.selectSingleNode(source);
                block2.setAttribute("Text", header.getValue());
                border2.addContent(block2);
                canvas.addContent(border2);

        }

    }

    private void setAxis(Element canvas, Document source) throws JDOMException {
        //gen axis
        Element line = new Element("Line", Utils.getDefaultNamespace());
        line.setAttribute("X1", "100");
        line.setAttribute("X2", "820");
        line.setAttribute("Y1", "200");
        line.setAttribute("Y2", "200");
        line.setAttribute("Stroke", "Red");
        line.setAttribute("StrokeThickness", "3");
        canvas.addContent(line);
        Element line2 = new Element("Line", Utils.getDefaultNamespace());
        line2.setAttribute("X1", "100");
        line2.setAttribute("Y1", "200");
        line2.setAttribute("Stroke", "Red");
        line2.setAttribute("StrokeThickness", "3");
        line2.setAttribute("X2", "100");
        line2.setAttribute("Y2", "600");
        canvas.addContent(line2);
        //rest of axis
        for(int i = 1; i<5; i++){
            Element lineX = new Element("Line", Utils.getDefaultNamespace());
            lineX.setAttribute("X1", "100");
            lineX.setAttribute("X2", "820");
            lineX.setAttribute("Y1", Integer.toString(200+(i*100)));
            lineX.setAttribute("Y2", Integer.toString(200+(i*100)));
            lineX.setAttribute("Stroke", "Red");
            lineX.setAttribute("StrokeThickness", "3");
            canvas.addContent(lineX);
        }
        //gen axis titles
        for(int i =1; i<6;i++){
          Element border = new Element("Border", Utils.getDefaultNamespace());
          border.setAttribute("Canvas.Top",Integer.toString((i*100)+90));
          border.setAttribute("Canvas.Left", "0");
          border.setAttribute("Width", "150");
          border.setAttribute("Height", "20");

          Element block = new Element("TextBlock",Utils.getDefaultNamespace());
          block.setAttribute("HorizontalAlignment", "Center");
          block.setAttribute("VerticalAlignment", "Center");

                xPath = XPath.newInstance("//y-labels/label[@number="+ (i) +"]");
                Element header = (Element) xPath.selectSingleNode(source);
                block.setAttribute("Text", header.getValue());

          block.setAttribute("Foreground", "Ivory");
          block.setAttribute("FontSize", "20");

          border.addContent(block);
          canvas.addContent(border);
        }


    }
    private Element getGrid(){
        //gen grid
        Element grid = new Element("Grid", Utils.getDefaultNamespace());

        //gen grid columndef
        Element gridColumnDef = new Element("Grid.ColumnDefinitions", Utils.getDefaultNamespace());
        Element coldef1 = new Element("ColumnDefinition", Utils.getDefaultNamespace());
        coldef1.setAttribute("Width", "1*");
        gridColumnDef.addContent(coldef1);
        Element coldef2 = new Element("ColumnDefinition", Utils.getDefaultNamespace());
        coldef2.setAttribute("Width", "3*");
        gridColumnDef.addContent(coldef2);
        Element coldef3 = new Element("ColumnDefinition", Utils.getDefaultNamespace());
        coldef3.setAttribute("Width", "1*");
        gridColumnDef.addContent(coldef3);
        grid.addContent(gridColumnDef);

        //gen grid background
        Element backgr = new Element("Grid.Background", Utils.getDefaultNamespace());
        Element brush = new Element("LinearGradientBrush", Utils.getDefaultNamespace());
        Element stop1 = new Element("GradientStop", Utils.getDefaultNamespace());
        stop1.setAttribute("Color", "#FF3B596E");
        brush.addContent(stop1);
        Element stop2 = new Element("GradientStop", Utils.getDefaultNamespace());
        stop2.setAttribute("Color","#FF93C5E8");
        stop2.setAttribute("Offset", "1");
        brush.addContent(stop2);
        backgr.addContent(brush);
        grid.addContent(backgr);

        return grid;
    }
}
