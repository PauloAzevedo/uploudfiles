package br.com.lirasistemas.api.uploud.utils;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
/**
 *
 * @author paullo.azevedo@gmail.com
 */
public class Util {
    
    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }
    
    
    public static Integer gerarNumeroAleatorio(Integer maximo) {
        Random random = new Random();
        return random.nextInt(maximo);
    }
    
}   
