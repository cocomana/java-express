package examples;

import express.filter.Filter;
import express.http.HttpRequest;
import express.http.request.Request;
import express.http.response.Response;

public class PortMiddleware implements HttpRequest, Filter {


  /**
   * From interface HttpRequest, to handle the request.
   *
   * @param req - The request object
   * @param res - The response object
   */
  @Override
  public void handle(Request req, Response res) {

    // Get the port
    int port = req.getURI().getPort();

    // Add the port to the request middleware map
    req.addMiddlewareContent(this, port);

    /*
     * After that you can use this middleware by call:
     *	app.use(new PortMiddleware());
     *
     * Than you can get the port with:
     *	int port = (Integer) app.getMiddlewareContent("PortParser");
     */
  }

  /**
   * Defines the middleware.
   *
   * @return The middleware name.
   */
  @Override
  public String getName() {
    return "PortParser";
  }
}
