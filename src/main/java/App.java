import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    String body = "templates/input.vtl";

    get("/",(request,response) -> {
      HashMap<String, Object> model = new HashMap<String,Object>();

      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String,Object>();

        double length = Double.parseDouble(request.queryParams("length"));
        request.session().attribute("length", length);
        double width = Double.parseDouble(request.queryParams("width"));
        request.session().attribute("width", width);
        double height = Double.parseDouble(request.queryParams("height"));
        request.session().attribute("height", height);
        double weight = Double.parseDouble(request.queryParams("weight"));
        request.session().attribute("weight", weight);
        Parcel myParcel = new Parcel(request.session().attribute("length"), request.session().attribute("width"), request.session().attribute("height"), request.session().attribute("weight"));
        String cost = myParcel.Cost();
        model.put("cost", cost);
        model.put("body", body);
        model.put("template", "templates/output.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }


}
