package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class RadixSorter<T extends DigitizedNaturalNumber> extends AbstractTwoWaySorter<T> {

    private final CountingSorter<T> countingSorter = new CountingSorter<>();

    @Override
    protected List<T> sort(List<T> unsortedList) {
        List<T> mutable = new ArrayList<>(unsortedList);
        for (int i = 32; i >= 0; i--) {
            int index = i;
            mutable.forEach(di ->di.setSortIndex(index));
            mutable = countingSorter.sort(mutable);
        }
        return mutable;
    }
}
