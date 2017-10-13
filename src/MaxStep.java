import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricks on 9/25/17.
 */
public class MaxStep {

    static int maxStep(int n, int k) {
        int howManyStepsJumped = 0;
        int currentStep = 0;

        if(n == 0) {
            return 0;
        }

        for(int i = 0;  i<=n; i++) {
            if(i != k) {
                howManyStepsJumped = howManyStepsJumped + 1;
                currentStep = currentStep + 1;
            }
            if((currentStep + 1) == k && i < n-1) {
                howManyStepsJumped = howManyStepsJumped + 1;
                currentStep = currentStep + 2;
            }
        }

        return howManyStepsJumped;
    }
}
