var api_key = "77ikwpe94m3mio", 
	scope = "r_basicprofile&rw_nus", 
	state = "pompompom", 
	redirect_uri = "localhost:8080/app";
window.onload = function run () {
	$('#auth').click = function auth () {
		window.location.replace("https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id="+api_key+"&scope="+scope+"&state="+state+"&redirect_uri="+redirect_uri);
	}
}