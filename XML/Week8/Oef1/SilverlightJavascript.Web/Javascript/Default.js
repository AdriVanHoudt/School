var defaultPage = null;
var xamlFragment = null;

function onLoaded()
{
    defaultPage = document.getElementById('DefaultPage');
}

function oef1(sender, mouseEventArgs) {
    alert("test");
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


