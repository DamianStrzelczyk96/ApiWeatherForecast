package Project;

import org.json.JSONException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/")
    public String indexGet(){

        return "main";
    }

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getCityName(@RequestParam(value = "cityName") String cityName, @RequestParam(value="quantity") int number , Model model) throws IOException, JSONException {
        MainApp mainApp = new MainApp();
        model.addAttribute("cityName","Weather forecast for " + cityName);
        model.addAttribute("weather",mainApp.connectByCityForXDays(cityName,number));
        return "main";
    }

    @RequestMapping(value = "/back")
    public String back(){
        return "main";
    }

}
