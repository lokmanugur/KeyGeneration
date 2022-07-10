/* UGUR_BILISIM_SYS
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class AESencrp {
    
    private static final String ALGO = "AES";
    private static final byte[] keyValue ={0x55,0x47,0x55,0x52,0x5f,0x42,0x49,0x4c,0x49,0x53,0x49,0x4d,0x5f,0x53,0x59,0x53};

public static byte[] encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        byte[] encryptValue = Base64.getEncoder().encode(encVal);
        return encryptValue;
    }

public static String decrypt(byte[] encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
private static Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, ALGO);
}

}

//We use "generateKey()" method to generate a secret key for AES algorithm with a given key.

//Below is the code how you can use the above encryption algorithm.
