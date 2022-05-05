package co.gov.icfes.PasarelaAutenticador.Services.ADAzure.Implement;

//region import
import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.ChangePasswordAccount;
import co.gov.icfes.PasarelaAutenticador.dto.ADAzure.UserAccount;
import co.gov.icfes.PasarelaAutenticador.dto.ApiResponse;
//endregion import

public interface IAccountService {

    /**
     * Método para obtener la información del usuario del Active Directory
     * @param idUserAccount Identificador del usuario en Active Directory
     * @return Información de la cuenta del usuario
     */
    ApiResponse<UserAccount> GetInformationAccount(String idUserAccount);

    /**
     * Método para crear una cuenta de usuario en el Active Directory
     * @param userAccount Información de la nueva cuenta
     * @return Información de la cuenta del usuario
     */
    ApiResponse<String> CreateUserAccount(UserAccount userAccount);

    /**
     * Método para eliminar un usuario del Active Directory
     * @param idUserAccount Identificador del usuario
     * @return Respuesta de la petición
     */
    ApiResponse<Boolean> DeleteUserAccount(String idUserAccount);

    /**
     * Método para cambiar la contraseña de un usuario
     * @param changePasswordAccount Objeto requeridos para la operación
     * @return Respuesta de la petición
     */
    ApiResponse<Boolean> ChangePassword(ChangePasswordAccount changePasswordAccount);
}
