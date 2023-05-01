import org.junit.jupiter.api.Test;
import sort.BinarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest extends BaseSortTest {

    BinarySearch bs = new BinarySearch();

    @Test
    void search() {
        Random random = new Random();
        List<Integer> randomList = Arrays.stream(this.createRandomArray(100)).boxed().sorted().collect(Collectors.toList());
        int[] randomArr = randomList.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < 100; i++) {
            int target = randomList.get(random.nextInt(randomList.size()));
            int result = bs.search(randomArr, target);
            assertEquals(randomList.get(result), target);
        }
    }
}
