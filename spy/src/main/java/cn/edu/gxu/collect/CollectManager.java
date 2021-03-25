package cn.edu.gxu.collect;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.collect
 * @date 2021/3/24 15:51
 * @Description
 */
public class CollectManager {

    public static void record(String flag, String text) {
        try {
            text = flag + "\n" + text + "\n\n\n\n";
            FileUtils.write(new File("input.text"), text, "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
