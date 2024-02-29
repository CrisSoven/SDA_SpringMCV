package mx.edu.utez.sda.springmvc.control;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/peliculas")
public class ControlPeliculas {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADUL", "ROLE_NINIO"})
    public String index(){
        return "peliculas";
    };

    @RequestMapping(value = "/documentales", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADUL", "ROLE_NINIO"})
    public String documentales() {
        return "peliculas";
    }

    @RequestMapping(value = "/comedia", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADUL", "ROLE_NINIO"})
    public String comedia() {
        return "peliculas";
    }

    @RequestMapping(value = "/series", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADUL", "ROLE_NINIO"})
    public String series() {
        return "peliculas";
    }

    @RequestMapping(value = "/terror", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADUL"})
    public String terror() {
        return "peliculas";
    }

    @RequestMapping(value = "/horror", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADUL"})
    public String horror() {
        return "peliculas";
    }

    @RequestMapping(value = "/crimen", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADUL"})
    public String crimen() {
        return "peliculas";
    }
}
