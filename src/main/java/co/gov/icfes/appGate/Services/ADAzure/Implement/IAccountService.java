package co.gov.icfes.appGate.Services.ADAzure.Implement;

import co.gov.icfes.appGate.dto.ADAzure.UserAccount;
import co.gov.icfes.appGate.dto.ApiResponse;

public interface IAccountService {

    ApiResponse<UserAccount> GetInformationAccount(String idUserAccount);

    ApiResponse<String> CreateUserAccount(UserAccount userAccount);

    ApiResponse<Boolean> DeleteUserAccount(String idUserAccount);

}
