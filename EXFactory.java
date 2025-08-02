package LibrarySystem;

import java.util.Arrays;
import java.util.List;

class EXFactory {
    // 根据编号创建附赠品
    public static EX create(int id) {
        switch (id) {
            case 1: return new CD();
            case 2: return new Bag();
            case 3: return new Pen();
            default: return null; // 无效编号返回 null
        }
    }
    // 获取所有附赠品名称
    public static List<String> getAllEX() {
        return Arrays.asList("CD", "Bag", "Pen"); // 名称列表
    }
}

