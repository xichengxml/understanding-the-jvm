package com.xicheng.jvm.jvmdemo.jvm01;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.List;

/**
 * description
 *
 * @author xichengxml
 * @date 2019-08-31 14:53
 */
public class CmdParser {

    @Parameter(names = {"?", "-help"}, description = "print help message", order = 3, help = true)
    boolean helpFlag = false;

    @Parameter(names = "-version", description = "print version and exit", order = 2)
    boolean versionFlag = false;

    @Parameter(names = {"-cp", "-classpath"}, description = "classpath", order = 1)
    String classpath;

    @Parameter(description = "main class and args")
    List<String> mainClassAndArgs;

    boolean ok;

    String getMainClass() {
        String result = null;
        if (mainClassAndArgs != null && !mainClassAndArgs.isEmpty()) {
            result = mainClassAndArgs.get(0);
        }
        return result;
    }

    List<String> getAppArgs() {
        List<String> result = null;
        if (mainClassAndArgs != null && mainClassAndArgs.size() > 1) {
            result = mainClassAndArgs.subList(1, mainClassAndArgs.size());
        }
        return result;
    }

    static CmdParser parse(String[] args) {
        CmdParser result = new CmdParser();
        JCommander cmd = JCommander.newBuilder().addObject(result).build();
        cmd.parse(args);
        result.ok = true;
        return result;
    }
}
