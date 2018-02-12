package Test;

import com.techpalace.calculator.util.InToPost;
import com.techpalace.calculator.util.PostfixCalculator;
import org.junit.*;

/**
 * Created by momen on 2/12/2018.
 */
public class modTest {
    InToPost inToPost;
    PostfixCalculator post;
    @Before
    public void init(){
        post = new PostfixCalculator();
    }
    @Test
    public void intTest(){
        inToPost = new InToPost("8 % 2");
        post.setExpression(inToPost.doTrans());
        post.evalPostfix();
        Assert.assertEquals(post.getResult(),0,0.0);
    }
}
