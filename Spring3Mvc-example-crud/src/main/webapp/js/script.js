$(function() {
	$( document ).tooltip();
});

function send(action){
	document.form.action = action;
	document.form.submit();	
}