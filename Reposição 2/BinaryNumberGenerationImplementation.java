import java.util.List;

public class BinaryNumberGenerationImplementation implements BinaryNumberGeneration {

    public List<String> generateBinaryNumbers(int k) {
        
        ArrayDeque<String> queue = new ArrayDeque<>(k);
        List<String> bStrings = new ArrayList<>();
        queue.addLast("1");
        int i = 0;
        while (i < k) {
            queue.addLast(queue.getFirst() + "0");
            queue.addLast(queue.getFirst() + "1");
            bStrings.add(queue.getFirst());
            queue.removeFirst();
            i++;
        }
        return bStrings;
    }
}
