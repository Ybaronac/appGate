package co.gov.icfes.PasarelaAutenticador.Services.ADAzure.Implement;

import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.LoginUser;
import co.gov.icfes.PasarelaAutenticador.dto.ApiResponse;

public interface ISecurityService {
    /**
     * Método para obtener el token de operación sobre Azure AD
     * @return Token de opearación
     */
    ApiResponse<String> GetToken();

    /**
     * Método para obtener el Token de operación sobre un usuario
     * @param loginUser
     * @return Token de operación
     */
    ApiResponse<String> GetTokenUsernamePassword(LoginUser loginUser);
}
