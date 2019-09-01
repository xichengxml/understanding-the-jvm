package com.xicheng.jvm.jvmdemo.jvm01;

/**
 * description
 *
 * @author xichengxml
 * @date 2019-08-31 15:20
 */
public class Main {

    public static void main(String[] args) {

        Args arguments = Args.parse(args);

        if (!arguments.ok || arguments.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }

        if (arguments.versionFlag) {
            System.out.println("java version \"1.8.0\"");
        }
    }
}
