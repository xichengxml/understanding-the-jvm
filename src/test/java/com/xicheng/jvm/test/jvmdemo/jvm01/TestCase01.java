package com.xicheng.jvm.test.jvmdemo.jvm01;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author xichengxml
 * @date 2019-09-01 23:25
 */
public class TestCase01 {

    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = "-arg01", description = "用于测试")
    private boolean arg01;

    @Parameter(names = "-arg02", arity = 1)
    private boolean arg02;

    private TestCase01 args;

    @Before
    public void init() {
        args = new TestCase01();
        String[] argv = { "-arg01", "false", "-groups", "unit", "-args02", "false"};
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
    }

    @Test
    public void test01() {
        // 不会考虑后面带的参数
        System.out.println(args.arg01);
    }

    @Test
    public void test02() {
        System.out.println(args.arg02);
    }
}
