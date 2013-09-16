var defaultPage = null;
var ellipse1 = null;
var ellipse2 = null;
var ellipse3 = null;
var green = false;
var firstColumn = false;
var clickCounter = 0;

function onLoaded() {
    defaultPage = document.getElementById('DefaultPage');
    ellipse1 = defaultPage.content.findName('ellipse1');
    ellipse2 = defaultPage.content.findName('ellipse2');
    ellipse3 = defaultPage.content.findName('ellipse3');
}

function upSize10() {   
    ellipse1.width += 10;
    ellipse1.height += 10;
    if (!green) {
        ellipse1.fill = 'Green';
        green = true;
    }
    
    //modulo hier ook mogelijk
    if (!firstColumn) {
        ellipse1['Grid.Column'] = 0;
        firstColumn = true;
    } else {
        ellipse1['Grid.Column'] = 2;
        firstColumn = false;
    }
}

function oef2() {
    clickCounter++;
    
    if (ellipse2.width < 400) {
        ellipse2.width += 5;
        ellipse2.height += 5;
    }
    
    if (clickCounter % 2 == 0) {
        ellipse1.Visibility = 'visible';
        ellipse2.Visibility = 'visible';
        ellipse3.Visibility = 'visible';
    } else {
        ellipse1.Visibility = 'collapsed';
        ellipse2.Visibility = 'collapsed';
        ellipse3.Visibility = 'collapsed';
    }
}


