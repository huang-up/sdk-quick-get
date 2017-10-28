package design.pattern.chapter27.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * 解释器模式(interpreter)：给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 * 解释器模式需要解决的是，如果一种特定类型的问题发生的频率足够高，那么可能就值得将该问题的各个实例表达为一个简单语言中的句子。
 * 这样就可以构造一个解释器，该解释器通过解释这些句子来解决该问题。
 *
 * 所谓的解释器模式，正则表达式就是它的一种应用，解释器为正则表达式定义了一个文法，
 * 如何表示一个特定的正则表达式，以及如何解释这个正则表达式。
 *
 * 解释器模式很难，就如同你开发了一个编程语言或脚本给自己或别人用。
 * 通常当一个语言需要解释执行，并且你可将该语言中的句子表示为一个抽象语法树时，可使用解释器模式。
 *
 * 好处
 * 用了解释器模式，就意味着可以很容易地改变和扩展文法，因为该模式使用类来表示文法规则，你可使用继承来改变或扩展该文法。
 * 也比较容易实现文法，因为定义抽象语法树中各个节点的类的实现大体类似，这些类都易于直接编写。
 *
 * 解释器模式用在正则表达式、浏览器等应用中，还有语法分析器、编译器生成器
 *
 * 解释器模式就是将这样一句话，转变成实际的命令程序执行而已。而不用解释器模式本来也可以分析，但通过继承抽象表达式，
 * 由于依赖倒转原则，使得对文法的扩展和维护都带来了方便。
 *
 * 不足
 * 解释器模式为文法中的每一条规则至少定义了一个类，因此包含许多规则的文法可能难以管理和维护。
 * 建议当文法非常复杂时，使用其他的技术和语法分析程序或编译器生成器来处理。
 *
 *
 * Created by h on 2017/10/26.
 */
public class AppClient {
    public static void main(String[] args) {
        Context context = new Context();
        List<AbstractExpression> list = new ArrayList<AbstractExpression>();
        list.add(new TerminalExpression());
        list.add(new NonTerminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());

        for (AbstractExpression abstractExpression:list) {
            abstractExpression.interpret(context);
        }
    }
}
