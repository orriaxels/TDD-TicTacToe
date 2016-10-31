package ttt;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;


public class tttWeb implements SparkApplication {

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
        final Board board = new Board();
        post("/random", (req, res) -> board.stringifyBoard());
    }

}
