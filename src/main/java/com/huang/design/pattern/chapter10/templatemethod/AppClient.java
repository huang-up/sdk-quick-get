package com.huang.design.pattern.chapter10.templatemethod;

/**
 * 模板方法模式：定义一个操作中的算法的骨架，而将一些操步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 *
 * 当不变和可变的行为在方法的子类实现中混合在一起的时候，不变的行为就会在子类中重复出现。
 * 我们通过模板方法模式把这些行为搬移到单一的地方，这样就帮助子类摆脱重复的不变行为的纠缠。
 *
 * 模板方法模式就是通过把不可变行为搬移到超类，去除子类中的重复代码来体现它的优势。
 *
 * 模板方法模式就是提供了一个很好的代码复用平台。因为有时候，我们会遇到由一系列步骤构成的过程需要执行。
 * 这个过程从高层次上看是相同的，但有些步骤的实现可能不同。这时候，我们通常就应该考虑模板方法模式了。
 *
 * Created by admin on 2017/9/25.
 */
public class AppClient {

    public static void main(String[] args) {
        TestPaper testPaperA = new TestPaperA();
        testPaperA.testQuesttion1();
        testPaperA.testQuesttion2();
        testPaperA.testQuesttion3();

        TestPaper testPaperB = new TestPaperB();
        testPaperB.testQuesttion1();
        testPaperB.testQuesttion2();
        testPaperB.testQuesttion3();
    }

}
