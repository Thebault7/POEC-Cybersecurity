package fr.bufalo.acme.constant;

/**
 * @Created 26/05/2021
 * @author Frederic Thebault
 * @version 1.0
 */
public enum ErrorConstant {

	INVALID_CONNECTION ("Identifiant ou mot de passe invalide"),
	INVALID_HASHING ("Erreur dans la configuration du hachage"),
	INEXISTING_DATE ("- La date de naissance fournie n'est pas une date valide<br>"),
	INVALID_CHARACTER_IN_ADDRESS ("- L'adresse entrée contient des caractères invalides<br>"),
	INVALID_EMAIL ("- L'email entré n'est pas valide<br>"),
	INVALID_CHARACTER_IN_FIRSTNAME ("- Le prénom entré contient des caractères invalides<br>"),
	INVALID_CHARACTER_IN_LASTNAME ("- Le nom entré contient des caractères invalides<br>"),
	EMPTY_NAMES ("- Les champs nom et prénom ne peuvent pas rester vides<br>"),
	INVALID_PHONE_NUMBER ("- Le numéro de téléphone n'est pas valide<br>"),
	INVALID_BIRTHDATE ("- La date de naissance n'est pas valide<br>"),
	BIRTHDATE_IN_FUTURE ("- La date de naissance ne peut pas être dans le futur<br>"),
	BIRTHDATE_TOO_FAR_IN_PAST ("- La date de naissance ne peut pas être plus de 130 ans dans le passé<br>"),
	SAVE_IN_DATABASE_FAIL ("Echec de la sauvegarde des données");
	
	private String errorMessage;
	
	ErrorConstant (String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
