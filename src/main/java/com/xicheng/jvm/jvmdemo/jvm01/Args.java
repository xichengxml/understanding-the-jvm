package com.xicheng.jvm.jvmdemo.jvm01;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.List;

/**
 * 如果输入java -version命令应该怎么解析？待完成
 *
 * @author xichengxml
 * @date 2019-08-31 14:53
 */
public class Args {

    /**
     * 将一个变量定义为boolean或Boolean, JCommander解析时默认不带参量，这种变量不依赖于外部提供的数据, 只要
     * 检测到参数中带有该变量，该变量的值就为true; 如果想要定义该参量的值，需要增加arity属性
     * 示例代码参见：{@link com.xicheng.jvm.test.jvmdemo.jvm01}
     */
    @Parameter(names = {"?", "-help"}, description = "print help message", help = true)
    boolean helpFlag = false;

    @Parameter(names = "-version", description = "print version and exit")
    boolean versionFlag = false;

    /**
     * 这里包含所有的输入参数
     */
    @Parameter(description = "main class and args")
    private List<String> mainClassAndArgs;

    /**
     * 用于命令标识解析完成
     */
    boolean ok;

    static Args parse(String[] args) {
        Args result = new Args();
        // 命令解析
        try {
            JCommander cmd = JCommander.newBuilder().addObject(result).build();
            cmd.parse(args);
            result.ok = true;
        } catch (Exception e) {
            e.printStackTrace();
            result.ok = false;
        }
        return result;
    }
}
