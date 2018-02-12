package Test;

import com.techpalace.calculator.util.InToPost;
import com.techpalace.calculator.util.PostfixCalculator;
import org.hamcrest.*;
import org.junit.*;
/**
 * Created by momen on 2/12/2018.
 */
public class DivideTest {
    InToPost inToPost;
    PostfixCalculator post;
    @Before
    public void init(){
        post = new PostfixCalculator();
    }
    @Test(expected = ArithmeticException.class)
    public void devideZeroTest(){
        inToPost = new InToPost("5 / 0");
        post.setExpression(inToPost.doTrans());
        post.evalPostfix();
        Assert.assertEquals(post.getResult(),0);
    }
}
