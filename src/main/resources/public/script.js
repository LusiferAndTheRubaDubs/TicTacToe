$(document).ready(function() {
    alert("works");
	$(".tile").click(function () {
        var tile = (this).value;
		var button = (this);
		alert(tile);
		$.ajax({
			type: "POST",
			url: "http://localhost:4567/playerMove",
			traditional: true,
			data: 'tile=' + tile,
			success: function (data) {
				obj = JSON.parse(data);
				alert(obj[tile]);
				button.innerHTML = obj[tile];
			},
			error: function (data) {
				alert("error");
			}
		});
    });
});

function makePlay(type){

};