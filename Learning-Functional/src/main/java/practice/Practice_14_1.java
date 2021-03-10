package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create a stream that will detect bad words in a text according to a bad words list. All words in the text are divided by whitespaces (always only one whitespace between two words).
 *
 * After calling collect(Collectors.toList()) the stream must return the list of bad words which were found in the text. The result should be dictionary ordered (in lexicographical order, i.e. sorted) and bad words shouldn't repeat.
 *
 * 创建一个流，该流将根据坏词列表检测文本中的坏词。文本中的所有单词都用空格分隔（两个单词之间总是只有一个空格）。
 *
 * 在调用collector（collectors.tolist（））之后，流必须返回在文本中找到的坏词列表。结果应该按字典顺序排列（按字典编纂顺序，即排序），而坏词不应该重复。
 *
 * @author zhangxin 2019-06-03 14:10:33
 */
public class Practice_14_1 {
    private static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        // write your stream here
        return Arrays.stream(text.split(" ")).filter(badWords::contains).sorted().distinct();
    }

    public static void main(String[] args) {
        List<String> badWords = Arrays.asList("fuck","fudk","cao","si");
        System.out.println(createBadWordsDetectingStream("ni ma si le fuck you mother fudk cao",badWords).collect(Collectors.toList()));
    }
}
