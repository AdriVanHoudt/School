var defaultPage = null;
var ellipse1 = null;
var ellipse2 = null;
var ellipse3 = null;
var rectangle1 = null;
var green = false;
var firstColumn = false;
var clickCounter = 0;
var isComplete = false;

function onLoaded() {
    defaultPage = document.getElementById('DefaultPage');
    ellipse1 = defaultPage.content.findName('ellipse1');
    rectangle1 = defaultPage.content.findName('rectangle1'); 
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

function oef3() {
    ellipse1.Visibility = "Collapsed";
    rectangle1.Visibility = "Visible";
}

setInterval(oef4, 1);

function oef4() {
    if (ellipse1.height==1) {
        isComplete = true;
    }else if (ellipse1.height==100) {
        isComplete=false;
    }
    if (!isComplete) {
        ellipse1.height -= 1;
        ellipse1.width -= 1;
    } else {
        ellipse1.height += 1;
        ellipse1.width += 1;
    }
}
