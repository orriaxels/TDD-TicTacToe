$(function() {
	var gameOver = false;
	console.log("The game is: " + gameOver);
	   
});

	$('.bGrid').click(function(){
		console.log("Tryin to click and game is: " + gameOver);
		if(!gameOver){
			ServiceCalls("/updateCell",this.id);
		}
  		
	});

	$('.newGame').click(function(){
		gameOver = false;
		ResetGame(this);

	});

function ResetGame(disItem){
	$(disItem).css( "display", "none" );
	document.getElementById('GState').innerHTML = "Tic Tac Toe";
	for(i = 0; i<9; i++){
		document.getElementById('sp'+i).innerHTML = "";
		$("#sp"+i).css( "visibility", "hidden");
	}
	$('.GameBoard').css( "background-color", "#303E73" );
	$('.GameBoard').css( "opacity", "1");
	$('.bGrid').css( "display", "flex" );
	ServiceCalls("/resetBoard");
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
		document.getElementById('GState').innerHTML = message;
		$('.GameBoard').css( "opacity", "0.5");
		$('.newGame').css( "display", "block");		

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
             DrawBoard(data);         
         },
         error: function () {
             console.log("shit, i fkd up!");
         }
     });
}

function ServiceCalls(ServiceURL, param){
	$.ajax({
         type: "POST",
         data: {"cellId":param},
         url: ServiceURL,
         success: function (data) {
             console.log("Well that went well");
             console.log(data);
             DrawBoard(data);         
         },
         error: function () {
             console.log("shit, i fkd up!");
         }
     });
}


function DrawBoard(board){
	for(i = 0; i < board.split('').length-1; i++){
		var visability = $("#sp"+i).css('visibility');
		if(visability == "hidden" && board.split('')[i] !="*"){
			document.getElementById('sp'+i).innerHTML = board.split('')[i];
			console.log("#sp"+i);
			$("#sp"+i).css( "visibility", "visible");
			$("#sp"+i).css( "opacity", "1" );
		}	
	}
	gameOver = isGameOver(board.split('')[board.split('').length - 1]);
}
