package jpass.util.mutation;

import static org.junit.Assert.assertEquals;

import jpass.util.mutation.CryptUtils;
import org.junit.Test;

public class CryptUtilsTest {

    @Test
    public void getSha256HashTest() throws Exception {

        char[] charArray = {'a'};
        byte[] result = CryptUtils.getSha256Hash(charArray);
        String expectResult = result.toString();

        assertEquals(expectResult, result.toString());
    }

    @Test
    public void getPKCS5Sha256HashTest() throws Exception {

        char[] charArray = {'a'};
        byte[] result = CryptUtils.getPKCS5Sha256Hash(charArray);
        String expectResult = result.toString();

        assertEquals(expectResult, result.toString());
    }
}