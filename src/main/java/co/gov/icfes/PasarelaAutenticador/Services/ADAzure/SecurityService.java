package co.gov.icfes.PasarelaAutenticador.Services.ADAzure;

//region import
import co.gov.icfes.PasarelaAutenticador.Services.ADAzure.Implement.ISecurityService;
import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.LoginUser;
import co.gov.icfes.PasarelaAutenticador.dto.ApiResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import static co.gov.icfes.PasarelaAutenticador.Utils.Constants.Variables.*;
//endregion import


@Service
public class SecurityService implements ISecurityService {

    private static final Logger LOG = LogManager.getLogger(SecurityService.class);

    @Value("${url.ADAzure}")
    private String urlADAzure;

    @Override
    public ApiResponse<String> GetToken() {
        ApiResponse<String> response = new ApiResponse<String>();
        try{
            LOG.info("Solicitud de generación de token Active Directory.");
            RestTemplate restTemplate = new RestTemplate();

            String url = urlADAzure + "/Security/GetToken";
            response = restTemplate.getForObject(url, ApiResponse.class);
            if(!response.getStatus()){
                throw new Exception(response.getException());
            }

        }catch (Exception ex){
            LOG.info(SERVICE_EXECUTION_ERROR + SecurityService.class.getName());
            LOG.error(ex);
            response.setException(ex.getMessage());
        }
        return response;
    }

    @Override
    public ApiResponse<String> GetTokenUsernamePassword(LoginUser loginUser) {
        ApiResponse<String> response = new ApiResponse<String>();
        try{
            LOG.info("Solicitud de Login de Usuario");
            RestTemplate restTemplate = new RestTemplate();
            String url = urlADAzure + "/Security/GetTokenUsernamePassword";
            response = restTemplate.postForObject(url, loginUser, ApiResponse.class);

            if(!response.getStatus()){
                throw new Exception(response.getException());
            }

        }catch (Exception ex){
            LOG.info(SERVICE_EXECUTION_ERROR + SecurityService.class.getName());
            LOG.error(ex);
            response.setException(ex.getMessage());
        }

        return response;
    }

}
