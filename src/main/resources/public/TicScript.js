$(function() {

	testStuff("/test2");
	var bb = true;
	var grid = [1,2,3,4,5,6,7,8,9];
	$('.bGrid').click(function(){
  		FakeGridSelector(this.id);
	});

	$('.newGame').click(function(){

		$(this).css( "display", "none" );
  		$('.GameBoard').css( "background-color", "#303E73" );
  		$('.bGrid').css( "display", "flex" );

	});

});

function testStuff(ServiceURL){
	$.ajax({
         type: "POST",
         data: null,
         url: ServiceURL,
         success: function (data) {
             console.log("Well that went well");
             console.log(data);
         },
         error: function () {
             console.log("shit, i fkd up!");
         }
     });
}

function FakeGridSelector(value){
	var character;
	if(bb == true){
		character = "X";
		bb = false;
	}
	else{
		character = "O";
		bb = true;
	}
	
	grid[value] = character;
	DrawBoard(grid,character);
}
function DrawBoard(grid,character){
	for(i = 0; i <= 9; i++){
		var visability = $("#sp"+i).css('visibility');
		if(grid[i] == "X" || grid[i] == "O"){
			if(visability == "hidden"){
				$("#sp"+i).text(character);
				document.getElementById('sp'+i).innerHTML = grid[i];
				$("#sp"+i).css( "visibility", "visible");
				$("#sp"+i).css( "opacity", "1" );
			}
			
		}
	}
}
