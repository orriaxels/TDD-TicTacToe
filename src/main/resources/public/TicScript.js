$(function() {

	   

});
	$('.bGrid').click(function(){
  		//ServiceCalls(this.id);
  		var data = "*X*******2";
		DrawBoard(data);
	});

	$('.newGame').click(function(){
		ResetGame(this);

	});

function ResetGame(disItem){
	$(disItem).css( "display", "none" );
	for(i = 1; i<9; i++){
		document.getElementById('sp'+i).innerHTML = "";
	}
	$('.GameBoard').css( "background-color", "#303E73" );
	$('.bGrid').css( "display", "flex" );
	ServiceCalls("/print");
}

function isGameOver(param){
	var message;
	var isOver;

	switch (param) {
	    case "0":
	        message = null;
	        isOver = false;
	        break;
	    case "1":
	        message = "Winner is 'X'";
	        isOver = true;
	        break;
	    case "2":
	        message = "Winner is '0'";
	        isOver = true;
	        break;
	    case "3":
	    	message = "Its a Draw";
	    	isOver = true;
	    	break;
	}
	if(isOver){
		document.getElementById('GameState').innerHTML = message;
		$('#GameState').css( "display", "block");
		$('.newGame').css( "display", "block");
		$('.newGame').css( "background-color", "rgba(255,255,255,0.5)");

	}
	return isOver;
}


function ServiceCalls(ServiceURL){
	$.ajax({
         type: "POST",
         data: null,
         url: ServiceURL,
         success: function (data) {
             console.log("Well that went well");
             console.log(data.split(''));
             DrawBoard(data);         
         },
         error: function () {
             console.log("shit, i fkd up!");
         }
     });
}


function DrawBoard(board){
	for(i = 0; i < board.split('').length; i++){
		var visability = $("#sp"+i).css('visibility');
		if(visability == "hidden"){
			document.getElementById('sp'+i).innerHTML = board.split('')[i];
			console.log("#sp"+i);
			$("#sp"+i).css( "visibility", "visible");
			$("#sp"+i).css( "opacity", "1" );
		}	
	}
	var x = isGameOver(board.split('')[board.split('').length - 1]);
}
