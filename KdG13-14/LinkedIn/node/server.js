var http = require('http'),
	linkedin = require('linkedin-js'),
	url = require('url'),
	fs = require('fs'),
	path = require('path');

var server = http.createServer(function(request, respons) {
	var fileName = path.basename(request.url, '.html') || 'index.html',
    localFolder = __dirname + '/wwww/', 
    filePath = localFolder + fileName;

	var p_url = url.parse(request.url,false , true);
	if(fileName == "index"){
		var html = fs.readFileSync('./www/index.html');
		respons.writeHead(200, {"Content-Type": "text/html"});
		respons.write(html);		
		respons.end();
	}else if(fileName == "app"){
		linkedin.getAccessToken(request, respons, function (error, token) {
			request.session.token = token;
			request.render('auth');
		});
	}else{
		//404
		respons.writeHead(200);
		respons.write("noooo");
		respons.end();
	};
});

server.listen(8080);
console.log("server running");