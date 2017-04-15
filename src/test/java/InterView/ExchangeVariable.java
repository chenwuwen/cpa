package InterView;

import org.junit.Test;

/**
 * Created by KANYUN on 2017/4/8.
 */
public class ExchangeVariable {
    @Test
//    不使用第三个变量，交换变量之间的值
    public void exec(){
        int a = 1;
        int b = 2;
        System.out.println("排序前："+"a的值为"+a+" ， "+"b的值为:"+b);
        b = a - (a = b)*0;
        System.out.println("排序后："+"a的值为"+a+" ， "+"b的值为:"+b);
    }

}
