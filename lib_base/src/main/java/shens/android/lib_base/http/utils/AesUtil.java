package shens.android.lib_base.http.utils;

import android.text.TextUtils;
import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES-128 tool
 */
public class AesUtil {
    private final static String AES_KEY = "#z3u4^189kXEjY%I";
    private static final String AES = "AES";
    private static final String ENCODE = "UTF-8";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 解密
     */
    public static String decrypt(String sSrc) {
        if (TextUtils.isEmpty(sSrc)) {
            return "";
        }
        try {
            byte[] bKey = AES_KEY.getBytes(ENCODE);
            byte[] decodeOneByte = Base64.decode(sSrc, Base64.NO_WRAP);
            byte[] decodeTwoByte = Base64.decode(decodeOneByte, Base64.NO_WRAP);
            SecretKeySpec sKeySpec = new SecretKeySpec(bKey, AES);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
            byte[] original = cipher.doFinal(decodeTwoByte);
            return new String(original, ENCODE);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 加密
     */
    public static String encrypt(String sSrc) {
        if (TextUtils.isEmpty(sSrc)) {
            return "";
        }
        try {
            byte[] bKey = AES_KEY.getBytes(ENCODE);
            SecretKeySpec sKey = new SecretKeySpec(bKey, AES);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            byte[] byteContent = sSrc.getBytes(ENCODE);
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            byte[] result = cipher.doFinal(byteContent);
            return byte2Base64(result);
        } catch (Exception e) {
            return "";
        }
    }

    private static String byte2Base64(byte[] encode) {
        return Base64.encodeToString(Base64.encode(encode, Base64.NO_WRAP), Base64.NO_WRAP);
    }
}
