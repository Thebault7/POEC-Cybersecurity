package fr.bufalo.acme.utils.encrypt;

import fr.bufalo.acme.bo.Customer;

/**
 * Classe en charge de crypter et décrypter une chaîne de caractères
 * par la méthode de Vigenère
 * @version cryptage - v1.0
 * @author fthebaul2019
 * @date 27 nov. 2019 - 08:01:07
 *
 */
public class Encrypt {
	
	private static final String listeCharacters = "S£/3~*674gUî=q'ù[;knR9ëJ%YMN>ïGl02X)jyçC]Qb1K(IWPTµ^,&}F<x+_.5pEwLHsc:#?|fèt -Be@aOA§Zm$¤iDé!dvozVh{êr8àu`â";
	private static final String cle1 = "o ntg, nn1é rdoeétouJmSresu8 y9eoeeepmsctn ei9nmap iaG3vBdeiéeelmlpet rc.et ar 1sao ik ycsuWéoSnaiuryS e2tboneMatsoa(aane2 slotdaJl reeanc lg95tPsoi rn éemrdaégir nhre toNf ilfp   emucto   uig g s ed ayc,f tsu )r ,doluoosvcn lnsnMlmea eJ ti mijl s";
	private static final String cle2 = "gJ r aftelNdot.galao ,soéet éno u Mn ltei vu eaS fey5leetJs2bdc phasivooép  kySl,t8reéceocisds,ntips 9 iPcasnlnamé iBacu 3 einWe  mii2ep lSsis arte(erguen  lrenmuartdoso1)erGtc eeyl  snenrmisdnagg1  ralo tnMdjut f mnmonroréa9oumme 9 Jo  au  eytcoe";
	private static final String cle3 = "apsesky5N n 2ev Bees fcd tSdyn2 g dpileam in,eo lgttiirmno t rmtéetiou )rnaa dueénc9 vnls  r ps ttl m9pte8le, nsMrcso1roo3sd iulo aréeyMoJoo  Jee.ém émlf  c,thine9eaugWjiaPJ Ssao ely ebtrrc1G  nno sl( cofSg uuluaas aute oseénet aeoairceenngmmidiar";
	private static final String cle4 = "ore eop  aseimpaut rl snlnus eosqlr eienc onura.tIsutlnnqjnGrmn tet éuel rlam aré  spFo êoenefiridmfil Piirh nmmteoap’ceifm én Fbafqevé eo eid. jisnedrcEti ertpdbotsdrt ’ ibclntaeWrdan àrrculisets-eto otP efutv, ’dloaeiocn uce d Pee,rle oieuia LéotrautntoepaeeterFAoan uan énre eynpottléeh s,  pPsé r  p ePaf eaulpl eé oo  erfeu nc bpr c àoete ’énno tdMatmcronc naeuttduarn,ulvSnpsrtrTnatfuesa fnpt’lsgiriis’nsoatui sn";
	
	public Encrypt() {
		super();
	}
	
	/*
	 * Cette méthode de chiffrage pourrait être nettement améliorée en
	 * utilisant en plus un sel différent pour chaque utilisateur,
	 * ce qui n'a pas été implémenté ici.
	 * */
	public String crypter4FoisSuccessives(String motACrypter) {
		String result1 = this.crypter(motACrypter, cle1);
		String result2 = this.crypter(result1, cle2);
		String result3 = this.crypter(result2, cle3);
		return this.crypter(result3, cle4);
	}
	
	public String decrypter4FoisSuccessives(String motADecrypter) {
		String result1 = this.decrypter(motADecrypter, cle4);
		String result2 = this.decrypter(result1, cle3);
		String result3 = this.decrypter(result2, cle2);
		return this.decrypter(result3, cle1);
	}
	
	/**
	 * Méthode qui transforme une chaîne de caractère en une autre chaîne de caractères.
	 * Le codage se fait par addition de la chaîne avec une clé
	 * et par l'utilisation d'une liste de caractères tous différents.
	 * {@inheritDoc}
	 * @see fr.eni.cryptage.InterfaceCryptage#crypter(java.lang.String)
	 */
	public String crypter(String motACrypter, String cle) {
		if (motACrypter.equals("")) {
			return "";
		}
		int index = 0;
		String motCrypte = "";
		StringBuffer sb = new StringBuffer();
		do {
			int numCle = associerNumeroLettre(cle.charAt(index % cle.length()));
			int numMot = associerNumeroLettre(motACrypter.charAt(index));
			char lettreCryptee = listeCharacters.charAt((numMot + numCle) % listeCharacters.length());
			sb.append(lettreCryptee);
			index++;
		} while (index < motACrypter.length());
		motCrypte = sb.toString();
		return motCrypte;
	}
	
	/**
	 * Méthode qui restore une chaîne de caractères cryptée en la chaîne originale.
	 * Le codage se fait par soustraction à la chaîne d'une clé
	 * et par l'utilisation d'une liste de caractères.
	 * {@inheritDoc}
	 * @see fr.eni.cryptage.InterfaceCryptage#decrypter(java.lang.String)
	 */
	public String decrypter(String motADecrypter, String cle) {
		if (motADecrypter.equals("")) {
			return "";
		}
		int index = 0;
		String motDecrypte = "";
		StringBuffer sb = new StringBuffer();
		do {
			int numCle = associerNumeroLettre(cle.charAt(index % cle.length()));
			int numCode = associerNumeroLettre(motADecrypter.charAt(index));
			char lettreDecryptee = listeCharacters.charAt(((numCode - numCle) + listeCharacters.length()) % listeCharacters.length());
			sb.append(lettreDecryptee);
			index++;
		} while (index < motADecrypter.length());
		motDecrypte = sb.toString();
		return motDecrypte;
	}
	
	/**
	 * 
	 * Méthode en charge d'associer à un caractère son numéro correspondant
	 * dans la liste de caractères fournie
	 * @param lettre
	 * @return
	 */
	private int associerNumeroLettre(char lettre) {
		int numeroLettre = 0;
		for (int i = 0; i < listeCharacters.length(); i++) {
			if (lettre == listeCharacters.charAt(i)) {
				numeroLettre = i;
				break;
			}
		}
		return numeroLettre;
	}
	
	public Customer cryptCustomer(Customer customer) {
		customer.setFirstName(this.crypter4FoisSuccessives(customer.getFirstName()));
		customer.setLastName(this.crypter4FoisSuccessives(customer.getLastName()));
		customer.setAddressLine1(this.crypter4FoisSuccessives(customer.getAddressLine1()));
		customer.setAddressLine2(this.crypter4FoisSuccessives(customer.getAddressLine2()));
		customer.setAddressLine3(this.crypter4FoisSuccessives(customer.getAddressLine3()));
		customer.setEmail(this.crypter4FoisSuccessives(customer.getEmail()));
		return customer;
	}
	
	public Customer decryptCustomer(Customer customer) {
		customer.setFirstName(this.decrypter4FoisSuccessives(customer.getFirstName()));
		customer.setLastName(this.decrypter4FoisSuccessives(customer.getLastName()));
		customer.setAddressLine1(this.decrypter4FoisSuccessives(customer.getAddressLine1()));
		customer.setAddressLine2(this.decrypter4FoisSuccessives(customer.getAddressLine2()));
		customer.setAddressLine3(this.decrypter4FoisSuccessives(customer.getAddressLine3()));
		customer.setEmail(this.decrypter4FoisSuccessives(customer.getEmail()));
		return customer;
	}
}


/*
 * Hereafter, a way to crypt using a randomly generated key
 */

//
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//
//public class Encrypt {
//
//	private static final String message = "Mon message a traiter";
//	private static KeyGenerator keyGen;
//	private static final String DESEDE = "DESede";
//
//	public static void generateKey() {
//
//		try {
//			keyGen = KeyGenerator.getInstance(DESEDE);
//			keyGen.init(168);
//			SecretKey cle = keyGen.generateKey();
//			System.out.println("cle : " + new String(cle.getEncoded()));
//
//			byte[] enc = encrypter(message, cle);
//			System.out.println("texte encrypte : " + new String(enc));
//
//			String dec = decrypter(enc, cle);
//			System.out.println("texte decrypte : " + dec);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static byte[] encrypter(final String message, SecretKey cle) throws NoSuchAlgorithmException,
//			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//		Cipher cipher = Cipher.getInstance("DESede");
//		cipher.init(Cipher.ENCRYPT_MODE, cle);
//		byte[] donnees = message.getBytes();
//
//		return cipher.doFinal(donnees);
//	}
//
//	public static String decrypter(final byte[] donnees, SecretKey cle) throws NoSuchAlgorithmException,
//			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//		Cipher cipher = Cipher.getInstance("DESede");
//		cipher.init(Cipher.DECRYPT_MODE, cle);
//
//		return new String(cipher.doFinal(donnees));
//	}
//
//}