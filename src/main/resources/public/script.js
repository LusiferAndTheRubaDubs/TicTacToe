$(document).ready(function() {
    alert("works");
	$(".tile").click(function () {
        var tile = (this).value;
		$.ajax({
			type: "POST",
			url: "http://localhost:4567/playerMove",
			traditional: true,
			data: 'tile=' + tile,
			success: function (data) {
				obj = JSON.parse(data);
				alert(obj.state);
				for(var i = 0; i < obj.board.length; i++) {
					var button = document.getElementById(i+1);
					button.innerHTML = obj.board[i];
				}
				
			},
			error: function (data) {
				alert("error");
			}
		});
    });
});
