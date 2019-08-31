package com.xicheng.jvm.jvmdemo.jvm01;

/**
 * description
 *
 * @author xichengxml
 * @date 2019-08-31 15:20
 */
public class Main {

    public static void main(String[] args) {

        CmdParser cmdParser = CmdParser.parse(args);

        if (!cmdParser.ok || cmdParser.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }

        if (cmdParser.versionFlag) {
            System.out.println("java version \"1.8.0\"");
        }

        startJVM(cmdParser);
    }

    private static void startJVM(CmdParser cmdParser) {
        System.out.printf("classpath: %s, class: %s, args: %s\n", cmdParser.classpath, cmdParser.getMainClass(),
                cmdParser.getAppArgs() + "");
    }
}
