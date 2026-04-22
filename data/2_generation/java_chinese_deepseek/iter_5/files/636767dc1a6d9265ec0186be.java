import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {

    public static long compressTimeBucket(long timeBucket, int dayStep) {
        // 将时间桶转换为字符串
        String timeBucketStr = Long.toString(timeBucket);
        
        // 解析日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(timeBucketStr, formatter);
        
        // 计算新的日期
        int dayOfMonth = date.getDayOfMonth();
        int newDay = ((dayOfMonth - 1) / dayStep) * dayStep + 1;
        LocalDate newDate = date.withDayOfMonth(newDay);
        
        // 将新日期格式化为长整型
        String newTimeBucketStr = newDate.format(formatter);
        return Long.parseLong(newTimeBucketStr);
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(compressTimeBucket(20000105, 11)); // 输出: 20000101
        System.out.println(compressTimeBucket(20000115, 11)); // 输出: 20000112
        System.out.println(compressTimeBucket(20000123, 11)); // 输出: 20000123
    }
}