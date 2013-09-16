var defaultPage = null;
var xamlFragment = null;
var xamlFragmentEllips1 = null;
var xamlFragmentEllips2 = null;

function onLoaded()
{
    defaultPage = document.getElementById('DefaultPage');
    oef2();
}


function oef2(sender, mouseEventArgs) {
    var xamlFragmentEllips1 = '<Ellipse Name="ellipse1" Visibility="visible" Width="100"  Height="100"  Fill="Red" Canvas.Left="250" Canvas.Top="0" />';
    var xamlFragmentEllips2 = '<Ellipse Name="ellipse2" Visibility="visible" Width="100"  Height="100"  Fill="Red" Canvas.Left="250" Canvas.Top="100" />';
    
    var rootElement = defaultPage.content.findName('canvas');

    rootElement.children.add(defaultPage.content.createFromXaml(xamlFragmentEllips1));
    rootElement.children.add(defaultPage.content.createFromXaml(xamlFragmentEllips2));    
}


function oef1(sender, mouseEventArgs) {
    var xamlFragment = '<Rectangle '; 
    xamlFragment += 'Grid.Column="1" ';
    xamlFragment += 'Grid.Row="1" ';
    xamlFragment += 'Width="100" ';
    xamlFragment += 'Height="50" ';
    xamlFragment += 'Fill="Blue" ';
    xamlFragment += 'Name="rectangle" ';
    xamlFragment += '/>';

    var rootElement = defaultPage.content.findName('root');

    rootElement.children.add(defaultPage.content.createFromXaml(xamlFragment));
}


