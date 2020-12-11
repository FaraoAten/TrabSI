package com.cripto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import java.util.Scanner;

public class Main {
	public static Scanner t = new Scanner(System.in);

	public static void main(String[] args) {
			System.out.println("Digite o texto que deseja criptografar:");
			String msgOriginal = t.nextLine();
			try {
				System.out.println("Gerando chave...\n");
				KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
				SecretKey chaveDES = keygenerator.generateKey();

				Cipher cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

				cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);

				byte[] textoPuro = msgOriginal.getBytes();
				
				System.out.println("Encriptando...\n");
				System.out.println("Texto [Formato de Byte] : " + textoPuro);
				System.out.println("Texto Puro : " + new String(textoPuro));
				
				byte[] textoEncriptado = cifraDES.doFinal(textoPuro);

				System.out.println("Texto Encriptado : " + textoEncriptado + "\n");
				
				System.out.println("Deseja decriptografar? 1-Sim/2-Não");
				if (t.nextLine().equals("1")) {
					try {
					cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);

				     byte[] textoDecriptografado = cifraDES.doFinal(textoEncriptado);
				     
				     System.out.println("Decriptando...\n");
				     System.out.println("Texto Decriptografado : " + new String(textoDecriptografado));

				     }catch(InvalidKeyException e){
				            e.printStackTrace();
				     }catch(IllegalBlockSizeException e){
				            e.printStackTrace();
				     }catch(BadPaddingException e){
				            e.printStackTrace();
				     }
				}
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
		}
	}

