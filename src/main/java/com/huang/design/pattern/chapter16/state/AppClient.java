package com.huang.design.pattern.chapter16.state;

/**
 * 状态模式：当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
 *
 * 状态模式主要解决的是当控制一个对象状态转换的条件表达式过于复杂时的情况。把状态的判断逻辑转移到
 * 表示不同状态的一系列类当中，可以把复杂的判断逻辑简化。当然如果这个状态判断很简单，那就没有必要用"状态模式"了。
 *
 * 好处：
 * 将与特定行为相关的行为局部化，并且将不同状态的行为分割开来。
 * 将特定的状态相关的行为都放入一个对象中，由于所有与状态相关的代码都存在于某个ConcreteState中，所以通过定义新的子类
 * 可以很容易的地增加新的状态和转换。
 * 说白了，这样做的目的就是为了消除庞大的条件分支语句，大的分支判断会使得它们难以修改和扩展，就像我们最早说的刻版印刷一样，任何改动和变化都是致命的。
 * 状态模式通过把各种状态转移逻辑分布到State的子类之间，来减少相互间的依赖，好比把整个版面改成了一个又一个的活字，此时就容易维护和扩展了。
 *
 * 当一个对象的行为取决于它的状态，并且它必须在运行时刻根据状态改变它的行为时，就可以考虑使用状态模式了。
 * 另外如果业务需求某项业务有多个状态，通常都是一些枚举变量，状态的变化都是依靠大量的多分支判断语句来实现，
 * 此时应该考虑将每一种业务状态定义为一个State的子类。这样这些对象就可以不依赖于其他对象而独立变化了，某一天客户需要更改需求，
 * 增加或者减少业务状态或改变状态流程，对你来说都不是困难的事。
 * Created by h on 2017/10/14.
 */
public class AppClient {
    public static void main(String[] args) {
        //
        Work project = new Work();
        project.setHour(9);
        project.writeProgram();
        project.setHour(10);
        project.writeProgram();
        project.setHour(12);
        project.writeProgram();
        project.setHour(13);
        project.writeProgram();
        project.setHour(14);
        project.writeProgram();
        project.setHour(17);
        project.setTaskFinished(false);
//        project.setTaskFinished(true);
        project.writeProgram();
        project.setHour(19);
        project.writeProgram();
        project.setHour(20);
        project.writeProgram();
        project.setHour(22);
        project.writeProgram();
    }
}
