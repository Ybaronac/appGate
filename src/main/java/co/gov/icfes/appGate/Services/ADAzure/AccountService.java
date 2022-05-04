package co.gov.icfes.appGate.Services.ADAzure;

import co.gov.icfes.appGate.Services.ADAzure.Implement.IAccountService;
import co.gov.icfes.appGate.dto.ADAzure.UserAccount;
import co.gov.icfes.appGate.dto.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static co.gov.icfes.appGate.Utils.Constants.Variables.*;

@Service
public class AccountService implements IAccountService {


    private static final Logger LOG = LogManager.getLogger(AccountService.class);

    @Override
    public ApiResponse<UserAccount> GetInformationAccount(String idUserAccount) {
        ApiResponse<UserAccount> response = new ApiResponse<UserAccount>();
        try{
            LOG.info("Solicitud de información de cuenta de usuario " + idUserAccount);
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl = "http://localhost:8080/Account/GetInformationAccount?idAccount="+idUserAccount;
            ResponseEntity<String> responseRequest = restTemplate.getForEntity(fooResourceUrl, String.class);
            HttpStatus statusCode = responseRequest.getStatusCode();

            ObjectMapper mapper = new ObjectMapper();
            ApiResponse<UserAccount> obj = mapper.readValue(responseRequest.getBody(), ApiResponse.class);

            response.setData(obj.getData());
            response.setMessage(SUCCESS_MESSAGE);
            response.setStatus(SUCCESS);

        }catch (Exception ex){
            LOG.info(SERVICE_EXECUTION_ERROR + AccountService.class.getName());
            LOG.error(ex);
            response.setException(ex.getMessage());
        }
        return response;
    }
}
