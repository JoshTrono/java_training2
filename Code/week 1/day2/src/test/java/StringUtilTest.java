import com.revature.tests.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.revature.tests.StringUtil.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringUtilTest {

    @Test
    void testReverse() {
        String reversed = StringUtil.reverse("test");
        assertEquals("tset", reversed);
    }
    @Test
    void testFailedReverse() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> {String reversed = StringUtil.reverse(null);});
    }

}
