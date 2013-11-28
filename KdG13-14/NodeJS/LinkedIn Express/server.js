var express = require('express'),
	linkedin_client = require('linkedin-js-patched')('77ikwpe94m3mio', 'RIe4knr7CtCHgJOn', 'http://localhost:3000/auth'),
	app = express(),
	oath_token, oath_token_secret;

	app.use(express.cookieParser());
	app.use(express.session({
		secret: "RIe4knr7CtCHgJOn"
	}));

app.get('/auth', function (req, res) {
	linkedin_client.getAccessToken(req, res, function (error, token) {
		console.log("error: " + error);
		console.log("token: " + token);
		oath_token = token;
		//store tokens globally
		res.send(token);
	});
});

app.get('/getProfile', function(req, res) {
	linkedin_client.apiCall('GET', '/people/~',
		{
			/*token: {
				oath_token_secret: req.session.token.oath_token_secret,
				oath_token: req.session.token.oath_token
			}*/
		},
		function (error, result) {
			console.log("error: " + error);
			res.send(result);
		}
	);
});

app.post('/setToken', function(req, res) {
	console.log(req.body.code);
	
});

app.listen(3000);
console.log('listening on port 3000');