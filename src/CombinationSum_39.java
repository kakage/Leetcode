import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(res, list, candidates, target, 0);
        return res;
    }

    private void  findCombination(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            findCombination(res, list, candidates, target - candidates[i], i);
            list.remove(list.size()-1);
            while(i + 1 < candidates.length &&  candidates[i+1] == candidates[i]) i++;
        }
    }
}