package co.gov.icfes.PasarelaAutenticador.Services.ADAzure;

//region import
import co.gov.icfes.PasarelaAutenticador.Services.ADAzure.Implement.IAccountService;
import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.ChangePasswordAccount;
import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.UserAccount;
import co.gov.icfes.PasarelaAutenticador.dto.ApiResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import static co.gov.icfes.PasarelaAutenticador.Utils.Constants.Variables.*;
//endregion import


@Service
public class AccountService implements IAccountService {


    private static final Logger LOG = LogManager.getLogger(AccountService.class);
    @Value("${url.ADAzure}")
    private String urlADAzure;

    @Override
    public ApiResponse<UserAccount> GetInformationAccount(String idUserAccount) {

        ApiResponse<UserAccount> response = new ApiResponse<UserAccount>();
        try{
            LOG.info("Solicitud de información de cuenta de usuario " + idUserAccount);
            RestTemplate restTemplate = new RestTemplate();
            String url = urlADAzure + "Account/GetInformationAccount?idUserAccount="+idUserAccount;
            response = restTemplate.getForObject(url, ApiResponse.class);
            if(!response.getStatus()){
                throw new Exception(response.getException());
            }
        }catch (Exception ex){
            LOG.info(SERVICE_EXECUTION_ERROR + AccountService.class.getName());
            LOG.error(ex);
            response.setException(ex.getMessage());
        }
        return response;
    }

    @Override
    public ApiResponse<String> CreateUserAccount(UserAccount userAcount) {
        ApiResponse<String> response = new ApiResponse<String>();
        try{
            LOG.info("Solicitud de creación cuenta de usuario");
            RestTemplate restTemplate = new RestTemplate();
            String url = urlADAzure + "Account/CreateUserAccount";
            response = restTemplate.postForObject(url,userAcount,ApiResponse.class);

            if(!response.getStatus()){
                throw new Exception(response.getException());
            }

        }catch (Exception ex){
            LOG.info(SERVICE_EXECUTION_ERROR + AccountService.class.getName());
            LOG.error(ex);
            response.setException(ex.getMessage());
        }
        return response;
    }

    @Override
    public ApiResponse<Boolean> DeleteUserAccount(String idUserAccount) {
        ApiResponse<Boolean> response = new ApiResponse<Boolean>();

        try{
            LOG.info("Solicitud de eliminación de cuenta de usuario " + idUserAccount);

            RestTemplate restTemplate = new RestTemplate();
            String url = urlADAzure + "Account/DeleteUserAccount?idUserAccount="+idUserAccount;
            ResponseEntity<ApiResponse> responseEntity  = restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<String>(idUserAccount), ApiResponse.class);
            response = responseEntity.getBody();
            if(!response.getStatus()){
                throw new Exception(response.getException());
            }

        }catch (Exception ex){
            LOG.info(SERVICE_EXECUTION_ERROR + AccountService.class.getName());
            LOG.error(ex);
            response.setException(ex.getMessage());
        }
        return response;
    }

    @Override
    public ApiResponse<Boolean> ChangePassword(ChangePasswordAccount changePasswordAccount) {
        ApiResponse<Boolean> response = new ApiResponse<Boolean>();
        try{
            LOG.info("Solicitud de cambio de contraseña de la cuenta de usuario " + changePasswordAccount.getCorreoElectronico());
            RestTemplate restTemplate = new RestTemplate();
            String url = urlADAzure + "Account/ChangePassword";
            ResponseEntity<ApiResponse> responseEntity = restTemplate.exchange(url,HttpMethod.PUT,new HttpEntity<ChangePasswordAccount>(changePasswordAccount),ApiResponse.class);
            response = responseEntity.getBody();
            if(!response.getStatus()){
                throw new Exception(response.getException());
            }

        }catch (Exception ex){
            LOG.info(SERVICE_EXECUTION_ERROR + AccountService.class.getName());
            LOG.error(ex);
            response.setException(ex.getMessage());
        }
        return response;
    }

}
