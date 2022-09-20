package com.webflux.webfluxandlambda.javaFunctionals;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    @Test
    public void testOperation(){
        UnaryOperator<Integer> addFive = integer -> integer + 5;
        UnaryOperator<Integer> addSix = integer -> integer + 6;
        Function<String, Integer> test = str -> 4;

    }

    @Test
    public void testDefaultMethods(){
        // Extends Function 类型， 所以也有compose 和 addThen


//         21 -28 行在放屁， 但是很搞笑所以留着了， 没事别看
//         没有 compose 也没有 andThen()， 如何理解？
//         稍微想一下就能理解， operator 类型， 输入输出的类型都相同， 即e.g. 输入是int 返回的也是int， 不会有类型转换。
//         这也就意味着 ”你不可能“ 会遇到 需要 在 operator 前/后 再连接一个 Operator 的情况。 因为 就算你分成了三个步骤，
//         他们也是可以合并成一个步骤的。
//         e.g. input 1 --> op1: 1+2 -andThen-> op2: input, which is 3-> input +3 -> ...
//         上列不就是相当于: input = 1 --> op1 = 1 + 2 + 3 ...
//         但是Function类型不一样， 它必须得在头尾能相接其他的Function，
//         e.g. 基础元素能变成核酸， 核算能变成DNA， 但是基础元素不能直接变成DNA。


        // 那么为甚么 Function 类型的 andThen & Compose都只接受Function类型？
        // 也很好理解， 跟上文同样的道理 （虽然上文说是在放屁， 但是道理还是对的）。
        // Imagine that 一个 Funcion, 接受 String, 输出int.
        // 如果其后你要接一个Operator, 让它 接受int， 输出int。
        // 举例即： FUN: "13" -> int 13; 下一步在operator 中 13 -> 13 + 4 = 17 返回17；
        // 那么你什么不直接把 加4 这一步合并到 Function 中？？ 多此一举啊建这个Operator， 所以Function后永远不用接Operator，
        // 同样的道理， Function 之前也永远不用接 Operator， “只有可能接Function!!!”
    }
}
