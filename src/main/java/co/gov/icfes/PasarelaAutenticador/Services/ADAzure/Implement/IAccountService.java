package co.gov.icfes.PasarelaAutenticador.Services.ADAzure.Implement;

import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.ChangePasswordAccount;
import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.UserAccount;
import co.gov.icfes.PasarelaAutenticador.dto.ApiResponse;

public interface IAccountService {

    ApiResponse<UserAccount> GetInformationAccount(String idUserAccount);

    ApiResponse<String> CreateUserAccount(UserAccount userAccount);

    ApiResponse<Boolean> DeleteUserAccount(String idUserAccount);

    ApiResponse<Boolean> ChangePassword(ChangePasswordAccount changePasswordAccount);
}
