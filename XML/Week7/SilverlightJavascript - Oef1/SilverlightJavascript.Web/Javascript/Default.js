var defaultPage = null;
var ellipse = null;
var green = false;
var firstColumn = false;

function onLoaded() {
    defaultPage = document.getElementById('DefaultPage');
    ellipse = defaultPage.content.findName('ellipse');
}

function upSize10() {   
    ellipse.width += 10;
    ellipse.height += 10;
    if (!green) {
        ellipse.fill = 'Green';
        green = true;
    }
    
    //modulo hier ook mogelijk
    if (!firstColumn) {
        ellipse['Grid.Column'] = 0;
        firstColumn = true;
    } else {
        ellipse['Grid.Column'] = 2;
        firstColumn = false;
    }
}


