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

    public List<Dni> days = new ArrayList<>();
    String cityNameNormal = "Weather for: ";
    String cityName;

    @RequestMapping("/")
    public String indexGet(){

        return "main";
    }

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public ModelAndView getCityName(@RequestParam(value = "cityName") String cityName, @RequestParam(value="quantity") int number) throws IOException, JSONException {
        this.cityName = cityName;
        System.out.println(cityName);
        MainApp mainApp = new MainApp();
        days = mainApp.connectByCityForXDays(cityName,number);

        return new ModelAndView("redirect:/setCityName");
    }

    @RequestMapping(value = "/setCityName")
    public String setCityName(Model model){
        model.addAttribute("weatherFor",cityNameNormal);
        model.addAttribute("cityName",cityName);
        model.addAttribute("weather",days);
        return "main";

    }

    @RequestMapping(value = "/back")
    public String back(){
        return "main";
    }

}
