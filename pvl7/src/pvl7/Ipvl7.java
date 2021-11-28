package pvl7;
import java.util.List;

public interface Ipvl7 {
    int newNode();
    boolean setEdge(int from, int to);
    List<List<Integer>> getEdges();
    List<List<Integer>> getNGons(int n);
    boolean hasFullCircle();
}

