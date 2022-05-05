package co.gov.icfes.PasarelaAutenticador.Controller;

import co.gov.icfes.PasarelaAutenticador.Services.ADAzure.Implement.ISecurityService;
import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.LoginUser;
import co.gov.icfes.PasarelaAutenticador.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController()
public class SecurityController {

    @Autowired
    private ISecurityService securityService;
    @RequestMapping(value = "/Security/GetToken",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ApiResponse<String> GetToken() {
        return securityService.GetToken();
    }

    /**
     * Servicio para el login del usuario
     * @param loginUser Datos de inicio de sesion
     * @return Token de acceso para operación Active Directory
     */
    @RequestMapping(value = "/Security/GetTokenUsernamePassword",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ApiResponse<String> GetTokenUsernamePassword(@RequestBody LoginUser loginUser) {
        return securityService.GetTokenUsernamePassword(loginUser);
    }

}
