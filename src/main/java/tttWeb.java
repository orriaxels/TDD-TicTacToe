package ttt;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;


public class tttWeb implements SparkApplication {
    Board board = new Board();

    public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication tttW = new tttWeb();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }


        tttW.init();
    }

    @Override
	public void init() {
        post("/resetBoard", (req, res) -> {
            board.initializeBoard();
            return board.stringifyBoard();
        });
        post("/updateCell", (req, res) -> {
            Integer cellId = Integer.parseInt(req.queryParams("cellId"));
            board.updateCell(cellId);
            return board.stringifyBoard();
        });
    }
}
