import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {

    /**
     * 根据 dayStep 重新格式化时间桶的长整型值。例如，当 dayStep == 11 时，20000105 重新格式化后的时间桶为 20000101，20000115 重新格式化后的时间桶为 20000112，20000123 重新格式化后的时间桶为 20000123。
     */
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
        
        // 将新日期转换回长整型
        String newTimeBucketStr = newDate.format(formatter);
        return Long.parseLong(newTimeBucketStr);
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(compressTimeBucket(20000105L, 11)); // 输出: 20000101
        System.out.println(compressTimeBucket(20000115L, 11)); // 输出: 20000112
        System.out.println(compressTimeBucket(20000123L, 11)); // 输出: 20000123
    }
}