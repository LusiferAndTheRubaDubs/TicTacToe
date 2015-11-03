$(document).ready(function() {
	$(".tile").click(function () {
        var tile = (this).value;
		$.ajax({
			type: "POST",
			url: "https://mighty-escarpment-3897.herokuapp.com/playerMove",
			traditional: true,
			data: 'tile=' + tile,
			success: function (data) {
				obj = JSON.parse(data);
				for(var i = 0; i < obj.board.length; i++) {
					var button = document.getElementById(i+1);
					button.innerHTML = obj.board[i];
				}
				if(obj.state === "WINNER") {
					var p = document.getElementById("winner");
					p.innerHTML = "The winner was " + obj.winnerName;
					p.style.display = "inline";
					
					for(var i = 1; i < 10; i++) {
					var button = document.getElementById(i);
					button.disabled = true;
					}
					var again = document.getElementById("again");
					again.style.display = "inline";
				}
				else if (obj.state === "TIE") {
					var p = document.getElementById("winner");
					p.innerHTML = "The game has tied... sorry";
					p.style.visibility = 'inline';
					
					for(var i = 1; i < 10; i++) {
					var button = document.getElementById(i);
					button.disabled = true;
					}
					var again = document.getElementById("again");
					again.style.display = "inline";
				}
			},
			error: function (data) {
				alert("error");
			}
		});
    });
	$("#again").click(function () {
        var tile = (this).value;
		$.ajax({
			type: "GET",
			url: "https://mighty-escarpment-3897.herokuapp.com/playagain",
			traditional: true,
			success: function (data) {
				location.reload();
			},
			error: function (data) {
				alert("error");
			}
		});
    });

		$("#oneplayer").click(function () {
        var tile = (this).value;
		$.ajax({
			type: "GET",
			url: "https://mighty-escarpment-3897.herokuapp.com/oneplayer",
			traditional: true,
			success: function (data) {
				location.reload();
			},
			error: function (data) {
				alert("error");
			}
		});
    });
		$("#twoplayer").click(function () {
        var tile = (this).value;
		$.ajax({
			type: "GET",
			url: "https://mighty-escarpment-3897.herokuapp.com/twoplayer",
			traditional: true,
			success: function (data) {
				location.reload();
			},
			error: function (data) {
				alert("error");
			}
		});
    });
});
